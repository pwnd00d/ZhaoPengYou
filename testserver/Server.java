import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.*;
import java.net.*;

/**
 * Write a description of class Server here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Server
{
    private ArrayList<Socket> clients;
    private ArrayList<Player> players;
    private Game g;
    
    public static void main(String[] args) throws IOException
    {
        Server s = new Server();
        s.loop();
    }
    
    public Server()
    {
        players = new ArrayList<Player>();
        clients = new ArrayList<Socket>();
        g = new Game();
    }
    
    public void loop() throws IOException
    {
        g.start();
        while(true){
            ServerSocket ss = new ServerSocket(9999);
            try{
                Socket s = ss.accept();
                players.add(new Player());
                clients.add(s);
            }
            catch(IOException e){
                System.err.println(e);
            }
            finally{
                ss.close();
            }
        }
    }
    
    public class Game extends Thread
    {
        public void run()
        {
            while(true){
                try{
                    for(int i = 0; i<clients.size(); i++) {
                        if(clients.get(i) == null)
                            continue;
                        BufferedReader in = new BufferedReader(new InputStreamReader(clients.get(i).getInputStream()));
                        PrintWriter out = new PrintWriter(clients.get(i).getOutputStream());
                        StringTokenizer st = new StringTokenizer(in.readLine().toUpperCase());
                        Player p = players.get(i);
                        if(p==null)
                            continue;
                        while(st.hasMoreTokens()) {
                            String l=st.nextToken();
                            System.out.println(l==null?"":l);
                            if(l.equals("QUIT")) {
                                players.set(i, null);
                                in.close();
                                out.close();
                                clients.get(i).close();
                                clients.set(i,null);
                                continue;
                            }
                            if(l.equals("RIGHT"))
                                p.a(1,0);
                            else if(l.equals("UP"))
                                p.a(0,1);
                            else if(l.equals("LEFT"))
                                p.a(-1,0);
                            else if(l.equals("DOWN"))
                                p.a(0,-1);
                        }
                        players.get(i).move();
                    }

                    for(Socket s : clients) {
                        if(s==null)
                            continue;
                        PrintWriter p = new PrintWriter(s.getOutputStream());
                        System.out.println(p);
                        if(p==null)
                            continue;
                        p.println("UPDATE");
                        for(Player pl : players) {
                            p.println(pl);
                        }
                        p.println("DONE");
                    }
                    //sleep(20);
                }
                //catch(InterruptedException e){
                    //System.err.println(e);
                //}
                catch(IOException e){
                    
                }
            }
        }
    }
}
