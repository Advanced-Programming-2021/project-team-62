package Model.Deck;

import Model.Cards.Magic;
import Model.Cards.Monster;

import java.util.ArrayList;

public class SideDeck {
    private ArrayList<Magic> magicCards = new ArrayList<>();
    public ArrayList<Monster> monsterCards = new ArrayList<>();
    private int numberOfCards;

    public void setMagicCards(ArrayList<Magic> magicCards) {
        this.magicCards = magicCards;
    }

    public ArrayList<Magic> getMagicCards() {
        return magicCards;
    }

    public void setMonsterCards(ArrayList<Monster> monsterCards) {
        this.monsterCards = monsterCards;
    }

    public ArrayList<Monster> getMonsterCards() {
        return monsterCards;
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }
}