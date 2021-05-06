package View;

import Controller.ScoreboardMenuController;
import Model.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScoreBoardMenuView {
    public void run(Scanner scanner){
        while (true) {
            String command = scanner.nextLine();
            if (!new ScoreboardMenuController(command).run()) break;
        }
    }
    public void printing(String result){
        System.out.println(result);
    }
    
}
