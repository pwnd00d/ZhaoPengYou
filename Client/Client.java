import java.net.Socket;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class Client
{
    private PrintWriter out;
    private BufferedReader in;

    public static void main(String[] args) throws IOException
    {
        (new Client()).run();
    }

    public void run() throws IOException
    {
        Socket socket = new Socket("localhost",9999);
        out = new PrintWriter(socket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        boolean done = false;

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input=in.readLine())!=null){
            System.out.println("hi");
            out.println(stdin.readLine());
        }

        out.close();
        in.close();
        socket.close();
    }
}
//are we actually giving up on this - jung
