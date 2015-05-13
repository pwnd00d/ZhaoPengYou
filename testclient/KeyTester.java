import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class KeyTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeyTester extends JFrame implements KeyListener
{
    public static void main(String[] args)
    {
        new KeyTester().setVisible(true);
    }
    
    public KeyTester()
    {
        addKeyListener(this);
    }
    
    public void keyPressed(KeyEvent e)
    {
        System.out.println(e.getKeyCode());
    }
    
    public void keyReleased(KeyEvent e)
    {
        
    }
    
    public void keyTyped(KeyEvent e)
    {
        
    }
}
