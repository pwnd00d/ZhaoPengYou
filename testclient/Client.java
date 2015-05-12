package testclient;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Write a description of class Client here.
 * 
 * @author Alex Shi
 * @version 0
 */
public class Client extends JPanel implements KeyListener, ActionListener
{
    private JFrame frame;
    private boolean[] keys;
    private ArrayList<String> objs;
    
    public static void main(String[] args)
    {
        Client c = new Client();
    }
    
    public Client()
    {
        keys=new boolean[256];
        objs = new ArrayList<String>();
        frame = new JFrame("Test Client");
        frame.setContentPane(this);
        setSize(500,500);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        repaint();
    }
    
    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()]=true;
    }
    
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
    
    
}
