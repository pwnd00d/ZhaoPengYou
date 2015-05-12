package testserver;

/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    private int x,y,vx,vy,r,g,b;
    
    public Player()
    {
        x=y=vx=vy=0;
        r=(int)(Math.random()*256);
        g=(int)(Math.random()*256);
        b=(int)(Math.random()*256);
    }
    
    public void move()
    {
        x+=vx;
        y+=vy;
    }
}
