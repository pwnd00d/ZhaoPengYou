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
    private ArrayList<Player> players;
    private Game g;
    
    public Server()
    {
        in = new ArrayList<BufferedReader>();
        out = new ArrayList<PrintWriter>();
        players = new ArrayList<Player>();
        g = new Game();
    }
    
    public void loop()
    {
        while(true){
            try{
                ServerSocket ss = new ServerSocket(9999);
                Socket s = ss.accept();
                in.add(new BufferedReader(new InputStreamReader(s.getInputStream())));
                out.add(new PrintWriter(s.getOutputStream()));
                players.add(new Player());
            }
            catch(IOException e){
                System.err.println(e);
            }
        }
    }
    
    public class Game extends Thread
    {
        public void run()
        {
            while(true){
                try{
                    for(Player p : players){
                        p.move();
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
