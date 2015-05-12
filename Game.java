import java.util.ArrayList;
/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//THIS IS A TEST FOR THE SERVER LOGIC DONT KILL THIS MICHAEL ZHANG
public class Game
{
    public static void main(String[] args)
    {
        Deck d = new Deck();
        d.shuffle();
        int m = 0;
        //These are the server clients
        
        ArrayList<Card> p1 = new ArrayList<Card>();
        ArrayList<Card> p2 = new ArrayList<Card>();
        ArrayList<Card> p3 = new ArrayList<Card>();
        ArrayList<Card> p4 = new ArrayList<Card>();
        ArrayList<Card> p5 = new ArrayList<Card>();
        ArrayList[] room = {p1,p2,p3,p4,p5};
        Card c;
        while(m!=105)
        {
            c = d.deal();
            m++;
            room[m%5].add(c);
        }
        for(int i = 0;i<5;i++)
        {
            print(room[i]);
            System.out.println();
        }
        System.out.println(d.deal());
        System.out.println(d.deal());
        System.out.println(d.deal());
    }
    
    
    
    public static void  print(ArrayList<Card> a)
    {
        for(Card c:a)
        {
            System.out.println(c);
        }
    }
}
