package View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static ArrayList<String> scoreBoardMeuRegex = new ArrayList<>();
    private static ArrayList<String> menuRegex = new ArrayList<>();
    private static ArrayList<String> deckRegex = new ArrayList<>();
    private static ArrayList<String> loginRegex = new ArrayList<>();
    private static ArrayList<String> registerRegex = new ArrayList<>();
    private static ArrayList<String> profileRegex = new ArrayList<>();
    private static ArrayList<String> shopRegex = new ArrayList<>();
    private static ArrayList<String> duelRegex = new ArrayList<>();

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
        loginRegex.add("user login --username (.+) --password (.+)");
        loginRegex.add("user login --password (.+) --username (.+)");
        loginRegex.add("user login --username (.+) -p (.+)");
        loginRegex.add("user login --password (.+) -u (.+)");
        loginRegex.add("user login -u (.+) --password (.+)");
        loginRegex.add("user login -u (.+) -p (.+)");
        loginRegex.add("user login -p (.+) -u (.+)");
        loginRegex.add("user login -p (.+) --username (.+)");
        registerRegex.add("user create --username (.+) --nickname (.+) --password (.+)");
        registerRegex.add("user create --username (.+) --password (.+) --nickname (.+)");
        registerRegex.add("user create --nickname (.+) --username (.+) --password (.+)");
        registerRegex.add("user create --password (.+) --username (.+) --nickname (.+)");
        registerRegex.add("user create --nickname (.+) --password (.+) --username (.+)");
        registerRegex.add("user create --password (.+) --nickname (.+) --username (.+)");
        registerRegex.add("user create -u (.+) -n (.+) -p (.+)");
        registerRegex.add("user create -u (.+) -p (.+) -n (.+)");
        registerRegex.add("user create -n (.+) -u (.+) -p (.+)");
        registerRegex.add("user create -p (.+) -u (.+) -n (.+)");
        registerRegex.add("user create -n (.+) -p (.+) -u (.+)");
        registerRegex.add("user create -p (.+) -n (.+) -u (.+)");
        profileRegex.add("profile change --nickname (.+)");
        profileRegex.add("profile change --current (.+) --new (.+)");
        duelRegex.add("duel --new --second-player (.+) --rounds (\\d+)");
        duelRegex.add("duel --new --rounds (\\d+) --second-player (.+)");
        duelRegex.add("duel --rounds (\\d+) --new --second-player (.+)");
        duelRegex.add("duel --rounds (\\d+) --second-player (.+) --new");
        duelRegex.add("duel --second-player (.+) --rounds (\\d+) --new");
        duelRegex.add("duel --second-player (.+) --new --rounds (\\d+)");
        duelRegex.add("duel -n -s (.+) -r (\\d+)");
        duelRegex.add("duel -n -r (\\d+) -s (.+)");
        duelRegex.add("duel -r (\\d+) -n -s (.+)");
        duelRegex.add("duel -r (\\d+) -s (.+) -n");
        duelRegex.add("duel -s (.+) -r (\\d+) -n");
        duelRegex.add("duel -s (.+) -n -r (\\d+)");
        duelRegex.add("duel --new --ai --rounds (\\d+)");
        duelRegex.add("duel --new --rounds (\\d+) --ai");
        duelRegex.add("duel --rounds (\\d+) --new --ai");
        duelRegex.add("duel --rounds (\\d+) --ai --new");
        duelRegex.add("duel --ai --rounds (\\d+) --new");
        duelRegex.add("duel --ai --new --rounds (\\d+)");
        duelRegex.add("duel -n -a -r (\\d+)");
        duelRegex.add("duel -n -r (\\d+) -a");
        duelRegex.add("duel -r (\\d+) -n -a");
        duelRegex.add("duel -r (\\d+) -a -n");
        duelRegex.add("duel -a -r (\\d+) -n");
        duelRegex.add("duel -a -n -r (\\d+)");

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

    public static ArrayList<String> getLoginRegex() {
        return loginRegex;
    }

    public static ArrayList<String> getRegisterRegex() {
        return registerRegex;
    }

    public static ArrayList<String> getProfileRegex() {
        return profileRegex;
    }

    public static ArrayList<String> getShopRegex() {
        return shopRegex;
    }

    public static ArrayList<String> getDuelRegex() {
        return duelRegex;
    }
}
