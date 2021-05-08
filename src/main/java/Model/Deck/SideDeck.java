package Model.Deck;

import Model.Cards.Card;
import Model.Cards.Magic.Magic;
import Model.Cards.Monster.Monster;

import java.util.ArrayList;

public class SideDeck {
    private ArrayList<Card> cards = new ArrayList<>();
    private int numberOfCards;

    public ArrayList<Card> getCards() {
        return cards;
    }
    public void addCard(Card card){
        this.cards.add(card);
        setNumberOfCards(getNumberOfCards()+1);
    }
    public void removeCard(Card card){
        this.cards.remove(card);
        setNumberOfCards(getNumberOfCards()-1);
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public int getNumberOfCardByName(String name) {
        int counter = 0;
        for (Card card : cards) {
            if (card.getName().equals(name)) counter++;
        }
        return counter;
    }
}
