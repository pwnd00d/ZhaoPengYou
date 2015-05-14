import java.net.*;
import java.io.*;
import java.util.HashSet;


/**
 * Write a description of class Server here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Server
{
    private class Handler extends Thread
    {
        private Socket socket;
        
        public Handler(Socket s)
        {
            socket = s;
        }
    }
}
