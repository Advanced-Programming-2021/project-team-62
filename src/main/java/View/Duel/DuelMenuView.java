package View.Duel;

import Controller.Duel.DuelMenuController;
import Model.Player;
import View.DeckMenuView;
import View.Regex;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuelMenuView {
    private static DuelMenuView menu;
    private static Player currentPlayer;

    public static DuelMenuView getInstance(Player player) {
        if (menu == null) menu = new DuelMenuView();
        currentPlayer = player;
        return menu;
    }

    public void run(Scanner scanner) {
        while (true){
            String command = scanner.nextLine();
            command = command.trim();
            if (!commandProcessor(command)) break;
        }
    }
    public boolean commandProcessor(String command){
        ArrayList<String> menuRegex = Regex.getMenuRegex();
        ArrayList<String> duelRegex = Regex.getDuelRegex();
        if (getMatcher(command,menuRegex.get(0)).find()){
            printing("menu navigation is not possible");
            return true;
        }else if (getMatcher(command,menuRegex.get(1)).find()){
            return false;
        }else if (getMatcher(command,menuRegex.get(2)).find()){
            printing("Duel");
            return true;
        }else if ((getMatcher(command,duelRegex.get(0)).find())||
                (getMatcher(command,duelRegex.get(1)).find())||
                (getMatcher(command,duelRegex.get(2)).find())||
                (getMatcher(command,duelRegex.get(3)).find())||
                (getMatcher(command,duelRegex.get(4)).find())||
                (getMatcher(command,duelRegex.get(5)).find())||
                (getMatcher(command,duelRegex.get(6)).find())||
                (getMatcher(command,duelRegex.get(7)).find())||
                (getMatcher(command,duelRegex.get(8)).find())||
                (getMatcher(command,duelRegex.get(9)).find())||
                (getMatcher(command,duelRegex.get(10)).find())||
                (getMatcher(command,duelRegex.get(11)).find())){
            DuelMenuController.getInstance(currentPlayer).processingNewGameWithAnotherPlayer(command);
            return true;
        }else if ((getMatcher(command,duelRegex.get(12)).find())||
                (getMatcher(command,duelRegex.get(13)).find())||
                (getMatcher(command,duelRegex.get(14)).find())||
                (getMatcher(command,duelRegex.get(15)).find())||
                (getMatcher(command,duelRegex.get(16)).find())||
                (getMatcher(command,duelRegex.get(17)).find())||
                (getMatcher(command,duelRegex.get(18)).find())||
                (getMatcher(command,duelRegex.get(19)).find())||
                (getMatcher(command,duelRegex.get(20)).find())||
                (getMatcher(command,duelRegex.get(21)).find())||
                (getMatcher(command,duelRegex.get(22)).find())||
                (getMatcher(command,duelRegex.get(23)).find())){
            DuelMenuController.getInstance(currentPlayer).processingNewGameWithAi(command);
            return true;
        }else{
            printing("invalid command");
            return true;
        }
    }
    public void printing(String result){
        System.out.println(result);
    }
    public Matcher getMatcher(String command, String regex){
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(command);
    }

}
