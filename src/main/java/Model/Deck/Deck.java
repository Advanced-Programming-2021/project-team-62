package Model.Deck;

import java.util.ArrayList;
import java.util.Comparator;

public class Deck  {
    private MainDeck mainDeck = new MainDeck();
    private SideDeck sideDeck = new SideDeck();
    private int numberOfCards;
    private String name;

    public Deck(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

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
        return sideDeck.getNumberOfCards() + mainDeck.getNumberOfCards();
    }
    public int getNumberOfCardByName(String name){
        int counter = sideDeck.getNumberOfCardByName(name) + mainDeck.getNumberOfCardByName(name);
        return counter;
    }


}
