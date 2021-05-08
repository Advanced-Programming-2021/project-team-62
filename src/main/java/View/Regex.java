package View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;

public class Regex {
    private static ArrayList<String> scoreBoardMeuRegex = new ArrayList<>();
    private static ArrayList<String> menuRegex = new ArrayList<>();
    private static ArrayList<String> deckRegex = new ArrayList<>();
    static {
        menuRegex.add("menu enter (.+)");
        menuRegex.add("menu exit");
        menuRegex.add("menu show-current");
        scoreBoardMeuRegex.add("scoreboard show");
        deckRegex.add("deck create (.+)");
        deckRegex.add("deck delete (.+)");
        deckRegex.add("deck set-active (.+)");
        deckRegex.add("^deck add-card");
        deckRegex.add("^deck rm-card");
        deckRegex.add("deck show --all");
        deckRegex.add("^deck show");
        deckRegex.add("deck show --cards");
    }

    public static ArrayList<String> getMenuRegex() {
        return menuRegex;
    }

    public static ArrayList<String> getScoreBoardMeuRegex() {
        return scoreBoardMeuRegex;
    }

    public static ArrayList<String> getDeckRegex() {
        return deckRegex;
    }
}
