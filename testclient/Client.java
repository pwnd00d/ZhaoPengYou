package testclient;

import java.net.*;
import java.io.*;
import java.util.Timer;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class Client here.
 * 
 * @author Alex Shi
 * @version 0
 */
public class Client extends JPanel implements MouseListener, ActionListener
{
    private JFrame frame;
    
    public static void main(String[] args)
    {
        Client c = new Client();
    }
    
    public Client()
    {
        frame = new JFrame("Test Client");
        frame.setContentPane(this);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
    }
    
    public void mouseMoved(MouseEvent e)
    {
        
    }
    
    public void mouseClicked(MouseEvent e)
    {
        
    }
    
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}
