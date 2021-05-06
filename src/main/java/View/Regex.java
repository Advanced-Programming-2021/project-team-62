package View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;

public class Regex {
    private static ArrayList<String> scoreBoardMeuRegex = new ArrayList<>();
    private static ArrayList<String> menuRegex = new ArrayList<>();
    static {
        menuRegex.add("menu enter (.+)");
        menuRegex.add("menu exit");
        menuRegex.add("menu show-current");
        scoreBoardMeuRegex.add("scoreboard show");
    }

    public static ArrayList<String> getMenuRegex() {
        return menuRegex;
    }

    public static ArrayList<String> getScoreBoardMeuRegex() {
        return scoreBoardMeuRegex;
    }
}
