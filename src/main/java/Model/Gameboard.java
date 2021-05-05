package Model;

import Model.Cards.Magic;
import Model.Cards.Monster;
import Model.Deck.Deck;

import java.util.ArrayList;

public class Gameboard {
    private Player playerOne;
    private Player playerTwo;
    private Deck playerOneDeck;
    private Deck playerTwoDeck;
    private Deck playerOneGraveYard;
    private Deck playerTwoGraveYard;
    private Magic playerOneField;
    private Magic playerTwoField;
    private ArrayList<Magic> playerOneMagics = new ArrayList<>();
    private ArrayList<Magic> playerTwoMagics = new ArrayList<>();
    private ArrayList<Monster> playerOneMonsters = new ArrayList<>();
    private ArrayList<Monster> playerTwoMonsters = new ArrayList<>();

    public Gameboard(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerOneDeck(Deck playerOneDeck) {
        this.playerOneDeck = playerOneDeck;
    }

    public Deck getPlayerOneDeck() {
        return playerOneDeck;
    }

    public void setPlayerTwoDeck(Deck playerTwoDeck) {
        this.playerTwoDeck = playerTwoDeck;
    }

    public Deck getPlayerTwoDeck() {
        return playerTwoDeck;
    }

    public void setPlayerOneGraveYard(Deck playerOneGraveYard) {
        this.playerOneGraveYard = playerOneGraveYard;
    }

    public Deck getPlayerOneGraveYard() {
        return playerOneGraveYard;
    }

    public void setPlayerTwoGraveYard(Deck playerTwoGraveYard) {
        this.playerTwoGraveYard = playerTwoGraveYard;
    }

    public Deck getPlayerTwoGraveYard() {
        return playerTwoGraveYard;
    }

    public void setPlayerOneField(Magic playerOneField) {
        this.playerOneField = playerOneField;
    }

    public Magic getPlayerOneField() {
        return playerOneField;
    }

    public void setPlayerTwoField(Magic playerTwoField) {
        this.playerTwoField = playerTwoField;
    }

    public Magic getPlayerTwoField() {
        return playerTwoField;
    }

    public void setPlayerOneMagics(ArrayList<Magic> playerOneMagics) {
        this.playerOneMagics = playerOneMagics;
    }

    public ArrayList<Magic> getPlayerOneMagics() {
        return playerOneMagics;
    }

    public void setPlayerTwoMagics(ArrayList<Magic> playerTwoMagics) {
        this.playerTwoMagics = playerTwoMagics;
    }

    public ArrayList<Magic> getPlayerTwoMagics() {
        return playerTwoMagics;
    }

    public void setPlayerOneMonsters(ArrayList<Monster> playerOneMonsters) {
        this.playerOneMonsters = playerOneMonsters;
    }

    public ArrayList<Monster> getPlayerOneMonsters() {
        return playerOneMonsters;
    }

    public void setPlayerTwoMonsters(ArrayList<Monster> playerTwoMonsters) {
        this.playerTwoMonsters = playerTwoMonsters;
    }

    public ArrayList<Monster> getPlayerTwoMonsters() {
        return playerTwoMonsters;
    }
}
