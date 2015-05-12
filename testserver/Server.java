package testserver;

import java.util.ArrayList;
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
    private ArrayList<BufferedReader> in;
    private ArrayList<PrintWriter> out;
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
        in = new ArrayList<BufferedReader>();
        out = new ArrayList<PrintWriter>();
        players = new ArrayList<Player>();
        g = new Game();
    }
    
    public void loop() throws IOException
    {
        g.start();
        while(true){
            System.out.println("a");
            ServerSocket ss = new ServerSocket(9999);
            try{
                Socket s = ss.accept();
                in.add(new BufferedReader(new InputStreamReader(s.getInputStream())));
                out.add(new PrintWriter(s.getOutputStream()));
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
                System.out.println("b");
                try{
                    for(int i = 0; i<players.size(); i++) {
                        String l = in.get(i).readLine().toUpperCase();
                        Player p = players.get(i);
                        if(p==null || l==null)
                            continue;
                        if(l.equals("RIGHT"))
                            p.a(1,0);
                        else if(l.equals("UP"))
                            p.a(0,1);
                        else if(l.equals("LEFT"))
                            p.a(-1,0);
                        else if(l.equals("DOWN"))
                            p.a(0,-1);
                        else if(l.equals("QUIT")) {
                            players.set(i, null);
                            in.set(i, null);
                            out.set(i, null);
                            clients.get(i).close();
                            clients.set(i,null);
                            continue;
                        }
                        players.get(i).move();
                    }

                    for(PrintWriter p : out) {
                        if(p==null)
                            continue;
                        p.println("UPDATE");
                        for(Player pl : players) {
                            p.println(pl);
                        }
                        p.println("DONE");
                    }
                    sleep(20);
                }
                catch(Exception e){
                    System.err.println(e);
                }
            }
        }
    }
}
