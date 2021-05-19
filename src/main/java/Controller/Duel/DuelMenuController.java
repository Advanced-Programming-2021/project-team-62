package Controller.Duel;

import Controller.DeckMenuController;
import Model.Player;
import View.Duel.DuelMenuView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuelMenuController {
    private static DuelMenuController duelMenuController;
    private static Player currentPlayer;

    public static DuelMenuController getInstance(Player player) {
        if (duelMenuController == null) duelMenuController = new DuelMenuController();
        currentPlayer = player;
        return duelMenuController;
    }

    public void processingNewGameWithAnotherPlayer(String command) {
        Pattern roundNumber = Pattern.compile("--rounds (\\d+)");
        Pattern rNoumber = Pattern.compile("-r (\\d+)");
        int rounds = 0;
        Matcher matcher = roundNumber.matcher(command);
        if (matcher.find()) rounds = Integer.parseInt(matcher.group(1));
        matcher = rNoumber.matcher(command);
        if (matcher.find()) rounds = Integer.parseInt(matcher.group(1));
        String secondPlayerName = "";
        String[] strings = command.split(" ");
        for (int i = 0; i < strings.length; ++i) {
            if (strings[i].equals("-s") || strings[i].equals("--second-player")) {
                StringBuilder stringBuilder = new StringBuilder();
                int size = strings.length - 5;
                for (int j = 1; j <= size; ++j) {
                    stringBuilder.append(strings[i + j]);
                    if (j != size) stringBuilder.append(" ");
                }
                secondPlayerName = stringBuilder.toString();
            }
        }

        newGameWithAnotherPlayer(secondPlayerName, rounds);
    }

    public void newGameWithAnotherPlayer(String secondPlayerName, int rounds) {
        if (newGameWithAnotherPlayerCheck(secondPlayerName, rounds)) {

        }
    }

    public boolean newGameWithAnotherPlayerCheck(String secondPlayerName, int rounds) {
        if (Player.getPlayerByUsername(secondPlayerName) == null) {
            DuelMenuView.getInstance(currentPlayer).printing("there is no player with this username");
            return false;
        } else if (((currentPlayer.getActiveDeck() == null)) ||
                (Player.getPlayerByUsername(secondPlayerName).getActiveDeck() == null)) {
            if (currentPlayer.getActiveDeck() == null) {
                DuelMenuView.getInstance(currentPlayer).printing(currentPlayer.getUsername() + " has no active deck");
            } else {
                Player player = Player.getPlayerByUsername(secondPlayerName);
                DuelMenuView.getInstance(currentPlayer).printing(player.getUsername() + " has no active deck");
            }
            return false;
        } else if ((!currentPlayer.getActiveDeck().isValid()) ||
                (!Player.getPlayerByUsername(secondPlayerName).getActiveDeck().isValid())) {
            if (!currentPlayer.getActiveDeck().isValid()) {
                DuelMenuView.getInstance(currentPlayer).printing(currentPlayer.getUsername() + "’s deck is invalid");
            } else {
                Player player = Player.getPlayerByUsername(secondPlayerName);
                DuelMenuView.getInstance(currentPlayer).printing(player.getUsername() + "’s deck is invalid");
            }
            return false;
        } else if (rounds != 3 && rounds != 1) {
            DuelMenuView.getInstance(currentPlayer).printing("number of rounds is not supported");
            return false;
        } else {
            return true;
        }

    }

    public void processingNewGameWithAi(String command) {
        Pattern roundNumberPattern = Pattern.compile("--rounds (\\d+)");
        Pattern rNumberPattern = Pattern.compile("-r (\\d+)");
        int roundNumbers = 0;
        Matcher matcher = roundNumberPattern.matcher(command);
        if (matcher.find()) roundNumbers = Integer.parseInt(matcher.group(1));
        matcher = rNumberPattern.matcher(command);
        if (matcher.find()) roundNumbers = Integer.parseInt(matcher.group(1));
        newGameWithAi(roundNumbers);

    }

    public boolean newGameWithAiCheck(int roundNumber) {
        if (roundNumber != 1 && roundNumber != 3) {
            DuelMenuView.getInstance(currentPlayer).printing("menu navigation is not possible");
            return false;
        } else return true;
    }

    public void newGameWithAi(int roundNumber) {
        if (newGameWithAiCheck(roundNumber)) {

        }
    }

}
