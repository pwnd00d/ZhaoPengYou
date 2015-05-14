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
    private static int test = 0;
    public static void main(String[] args) throws IOException
    {
        (new Server()).run();
    }

    public void run() throws IOException
    {
        ServerSocket ss = new ServerSocket(9999);
        while(true){
            (new Handler(ss.accept())).run();
            test++;
        }
    }

    private class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket s)
        {
            super("Handler for " + s);
            socket = s;
        }

        public void run()
        {
            try(
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
            ){
                out.print("Type a word to reverse: ");
                String input;
                while((input = in.readLine())!=null){
                    System.out.println("it got here");
                    if(input.equals("quit"))
                        break;
                    out.println((new StringBuffer(input)).reverse().toString());
                }
                socket.close();
            }   
            catch(IOException e){

            }
        }
    }
}
