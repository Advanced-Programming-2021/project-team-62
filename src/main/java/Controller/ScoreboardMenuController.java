package Controller;

import Model.Player;
import View.Regex;
import View.ScoreBoardMenuView;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScoreboardMenuController {
    private String command;

    public boolean run(String command) {
        this.command = command;
        ArrayList<String> scoreboardRegex = Regex.getScoreBoardMeuRegex();
        ArrayList<String> menuRegex = Regex.getMenuRegex();
        if (getMatcher(command, scoreboardRegex.get(0)).find()) {
            showScoreboard();
            return true;
        } else if (getMatcher(command, menuRegex.get(0)).find()) {
            enterMenu();
            return true;
        } else if (getMatcher(command, menuRegex.get(1)).find()) {
            return false;
        } else if (getMatcher(command, menuRegex.get(2)).find()) {
            showCurrentMenu();
            return true;
        } else {
            invalidCommand();
            return true;
        }
    }

    public void showScoreboard() {
        StringBuilder result = new StringBuilder();
        ArrayList<Player> players = new ArrayList<>(Player.getAllPlayers());
        Collections.sort(players, new PlayerComparator());
        int rank = 1;
        for (int i = 0; i < players.size(); ++i) {
            if ((i != players.size() - 1) &&
                    (players.get(i).getScore() != players.get(i + 1).getScore())){
                rank++;
            }
                result.append(rank+"- "+players.get(i).getNickname()+": "+players.get(i).getScore()+"\n");
        }
        String printingResult = result.toString();
        new ScoreBoardMenuView().printing(printingResult);
    }

    public void enterMenu() {
        new ScoreBoardMenuView().printing("menu navigation is not possible");
    }

    public void showCurrentMenu() {
        new ScoreBoardMenuView().printing("Scoreboard");
    }

    public void invalidCommand() {
        new ScoreBoardMenuView().printing("invalid command");
    }

    public Matcher getMatcher(String command, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);
        return matcher;
    }

    static class PlayerComparator implements Comparator<Player> {
        public int compare(Player playerOne, Player playerTwo) {
            int scoreCompare = Integer.compare(playerOne.getScore(), playerTwo.getScore());
            int nameCompare = playerOne.getNickname().compareTo(playerTwo.getNickname());
            if (scoreCompare == 0) return nameCompare;
            else return scoreCompare;
        }
    }
}
