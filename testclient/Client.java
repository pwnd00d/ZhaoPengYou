import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Write a description of class Client here.
 * 
 * @author Alex Shi
 * @version 0
 */
public class Client extends JPanel implements KeyListener
{
    private JFrame frame;
    private boolean[] keys;
    private ArrayList<String> objs;
    private boolean quit;
    private String message;

    public static void main(String[] args)
    {
        Client c = new Client();
        c.loop();
    }

    public Client()
    {
        keys=new boolean[256];
        objs = new ArrayList<String>();
        message="";
        frame = new JFrame("Test Client");
        frame.setContentPane(this);
        setPreferredSize(new Dimension(500,500));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void loop()
    {
        boolean done = keys[27];
        try{
            Socket s = new Socket("localhost", 9999);
            while(!done){
                done=keys[27];
                PrintWriter out = new PrintWriter(s.getOutputStream());
                String[] strs = {"LEFT", "UP", "RIGHT","DOWN"};
                for(int k = 27; k<30; k++){
                    if(keys[k])
                        out.print(strs[k] + " ");
                }
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String l = in.readLine();
                while(!"UPDATE".equals(l)){
                    l=in.readLine();
                }
                objs=new ArrayList<String>();
                for(l=in.readLine(); !"DONE".equals(l); l=in.readLine()){
                    objs.add(l);
                }
                System.out.println(l);
            }
        }
        catch(IOException e){
            System.err.println(e);
        }
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
        g.drawString(message, 1, 20);
    }

    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()]=true;
    }

    public void keyReleased(KeyEvent e)
    {
        keys[e.getKeyCode()]=false;
    }

    public void keyTyped(KeyEvent e){}

}
