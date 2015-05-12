package testserver;

/**
 * Player
 * 
 * @author Alex Shi
 * @version 0
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
    
    public void a(int x, int y)
    {
        vx+=x;
        vy+=y;
    }
    
    public void move()
    {
        x+=vx;
        y+=vy;
    }
    
    public String toString()
    {
        return x+" "+y+" "+r+" "+g+" "+b;
    }
}
