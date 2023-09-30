
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    { 
        // Initializations here...
        Deck cardDeck = new Deck();

        cardDeck.initializeNewDeck();
        cardDeck.shuffle();

        Deck dealtDeck[] = cardDeck.dealDeck();
        Deck deckHalf1 = dealtDeck[0];
        Deck deckHalf2 = dealtDeck[1];

        int halfLength1 = deckHalf1.getDeckSize();
        int halfLength2 = deckHalf2.getDeckSize();

        while (halfLength1 > 0 && halfLength2 > 0) {
            this.runEventLoop(cardDeck, deckHalf1, deckHalf2, halfLength1, halfLength2);
        }
    }

    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(Deck cardDeck, Deck deckHalf1, Deck deckHalf2, int halfLength1,int halfLength2) {
        cardDeck.shuffle();
        cardDeck.dealDeck();
        while (halfLength1 < 52 && halfLength2 < 52) {
            Card dealtCard = deckHalf1.dealCardFromDeck();
            Card dealtCard2 = deckHalf2.dealCardFromDeck();
            int cardRank = dealtCard.getRank();
            int cardRank2 = dealtCard2.getRank();
            Card[] playing = {dealtCard, dealtCard2};
            int n = playing.length;
            if (cardRank < cardRank2) {
                Card cpuStack[] = new Card[n];
                for (int i = 0; i < n; i++) {
                    cpuStack[i] = playing[i];
                }
            }
            if (cardRank > cardRank2) {
                Card playerStack[] = new Card[n];
                for (int i = 0; i < n; i++) {
                    playerStack[i] = playing[i];
                }
            }
        }
       
    }

    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
