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
    private int trumpvalue;
    private String trumpsuit;
    /**
     * Ace val = 14
     * Joker:
     * suit = null;
     *small joker, val = 15
     *big joker, val = 16
      */
    public Card(int v,String s)
    {
        value = v;
        suit = s;
    }
    public static void declare()
   {
     trumpvalue = this.value();
     trumpsuit = this.suit();

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

   }
}
