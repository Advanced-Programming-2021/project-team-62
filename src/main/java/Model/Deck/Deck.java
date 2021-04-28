package Model.Deck;

public class Deck {
    private MainDeck mainDeck = new MainDeck();
    private SideDeck sideDeck = new SideDeck();
    private int numberOfCards;

    public void setMainDeck(MainDeck mainDeck) {
        this.mainDeck = mainDeck;
    }

    public MainDeck getMainDeck() {
        return mainDeck;
    }

    public void setSideDeck(SideDeck sideDeck) {
        this.sideDeck = sideDeck;
    }

    public SideDeck getSideDeck() {
        return sideDeck;
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }
}
