package Model;

import Model.Cards.Card;
import Model.Cards.Magic.Magic;
import Model.Cards.Monster.Monster;
import Model.Deck.Deck;

import java.util.ArrayList;

public class Player {
    private String username;
    private String password;
    private String nickname;
    private int score;
    private int coin;
    private int maxHp;
    private int currentHp;
    private Deck activeDeck;
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Deck> decks = new ArrayList<>();
    private static ArrayList<Player> allPlayers = new ArrayList<>();

    public Player(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        allPlayers.add(this);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getCoin() {
        return coin;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setActiveDeck(Deck activeDeck) {
        this.activeDeck = activeDeck;
    }

    public Deck getActiveDeck() {
        return activeDeck;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
    public boolean isCardAvailable(String name){
        for (Card card : cards){
            if (card.getName().equals(name)) return true;
        }
        return false;
    }

    public void setDecks(ArrayList<Deck> decks) {
        this.decks = decks;
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public static ArrayList<Player> getAllPlayers() {
        return allPlayers;
    }

    public static Player getPlayerByUsername(String username) {
        for (Player player : allPlayers) if (player.username.equals(username)) return player;
        return null;
    }

    public static Player getPlayerByNickname(String nickname){
        for (Player player : allPlayers) if (player.nickname.equals(nickname)) return player;
        return null;
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public void addDeck(Deck deck) {
        this.decks.add(deck);
    }

    public Deck getDeckByName(String name) {
        for (Deck deck : decks) {
            if (deck.getName().equals(name)) return deck;
        }
        return null;
    }
    public Card getCardByName(String name){
        for (Card card : cards){
            if (card.getName().equals(name)) return card;
        }
        return null;
    }
}
