
/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card
{
    private int value;
    private String suit;
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
}
