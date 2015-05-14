import java.util.HashMap;
import java.util.Map;
/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card implements Comparable<Card>
{
    private int value;
    private String suit;

    private static String trumpsuit;
    private static int trumpvalue;
    static Map<String,Integer> m = new HashMap<String,Integer>();

    /**
     * Ace val = 14
     * Joker:
     * suit = joker;
     *small joker, val = 15
     *big joker, val = 16
      */
    public Card(int v,String s)
    {
        m.put("diamonds",2);
        m.put("spades",3);
        m.put("hearts",4);
        m.put("clubs",1);
        m.put("joker",6);
        value = v;
        suit = s;
    }

    public static void declare(Card c)
    {
        trumpsuit = c.suit();
        trumpvalue = c.value();
        m.put(trumpsuit,5);
    }



    public int value()
    {
        return value;
    }
    public String suit()
    {
        return suit;
    }
    public String toString()
    {
        return suit + " " + value;
    }
    public int compareTo(Card c)

    {
        if(c.value() == trumpvalue && this.value() == trumpvalue)
        {       
                return m.get(this.suit) - m.get(c.suit); 
        }
        return 0;
    }

   
}
