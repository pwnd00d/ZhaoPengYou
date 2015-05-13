
/**
 * Write a description of class Deck here.
 * 
 * @author (Austin Zhou) 
 * @version (0)
 */
public class Deck
{
    private Card[] deck;
    private int index = 0;
    public Deck()
    {
        deck = new Card[108];
        int a = 0;
        String[] suits = {"hearts","spades","diamonds","clubs"};
        for(int j=0;j<2;j++){
        for(String s:suits)
        {
            for(int i = 2;i<15;i++)
            {
                deck[a] = new Card(i,s);
                a++;
            }
        }
        deck[a]=new Card(15,"joker");
        a++;
        deck[a]=new Card(16,"joker");
        a++;
        }
    }
    public void shuffle()
    {
        for ( int i = deck.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }    
    }

    public Card deal()
    {
        try
        {
            if(index!=deck.length)
                return deck[index];
            return null;
        }
        finally
        {
            index++;
        }
    }
}
