package Model;

import Model.Cards.Magic;
import Model.Cards.Monster;
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
    private ArrayList<Magic> magics = new ArrayList<>();
    private ArrayList<Monster> monsters = new ArrayList<>();
    private ArrayList<Deck> decks = new ArrayList<>();
    private ArrayList<Player> allPlayers = new ArrayList<>();
    public Player(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.allPlayers.add(this);
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

    public void setMagics(ArrayList<Magic> magics) {
        this.magics = magics;
    }

    public ArrayList<Magic> getMagics() {
        return magics;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setDecks(ArrayList<Deck> decks) {
        this.decks = decks;
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public ArrayList<Player> getAllPlayers() {
        return allPlayers;
    }

    public Player getPlayerByUsername(String username) {
        for (Player player : allPlayers) if (player.username.equals(username)) return player;
        return null;
    }

    public void addMagic(Magic magic) {
        this.magics.add(magic);
    }

    public void addMonster(Monster monster) {
        this.monsters.add(monster);
    }

    public void addDeck(Deck deck) {
        this.decks.add(deck);
    }
}
