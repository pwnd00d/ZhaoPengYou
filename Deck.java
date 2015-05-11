
/**
 * Write a description of class Deck here.
 * 
 * @author (Austin Zhou) 
 * @version (0)
 */
public class Deck
{
    Card[] deck;
    public Deck()
    {
        deck = new Card[54];
        int a = 0;
        String[] suits = {"hearts","spades","diamonds","clubs"};
        for(String s:suits)
        {
            for(int i = 2;i<15;i++)
            {
                deck[a] = new Card(i,s);
                a++;
            }
        }
    }
    public void shuffle()
    {
        
    }
}
