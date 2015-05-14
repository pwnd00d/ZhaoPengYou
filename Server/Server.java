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
    public static void main(String[] args) throws IOException
    {
        (new Server()).run();
    }

    public void run() throws IOException
    {
        ServerSocket ss = new ServerSocket(9999);
        while(true){
            new Handler(ss.accept()).run();
        }
    }

    private class Handler extends Thread
    {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public Handler(Socket s)
        {
            socket = s;
        }

        public void run()
        {
            try{
                out = new PrintWriter(socket.getOutputStream(),true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out.print("Type a word to reverse: ");
                String input;
                while((input = in.readLine())!=null){
                    if(input.equals("quit"))
                        break;
                    out.println((new StringBuffer(input)).reverse().toString());
                }
                out.close();
                in.close();
                socket.close();
            }   
            catch(IOException e){

            }
        }
    }
}
