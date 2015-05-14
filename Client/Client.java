import java.net.Socket;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class Client here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Client
{
    private PrintWriter out;
    private BufferedReader in;
    
    public void run() throws IOException
    {
        Socket socket = new Socket("localhost",9999);
        out = new PrintWriter(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        boolean done = false;
        while(!done){
            String input = 
        }
    }
}
