package View;

import Controller.ScoreboardMenuController;

import java.util.Scanner;


public class ScoreBoardMenuView {
    private static ScoreBoardMenuView menu;

    public static ScoreBoardMenuView getInstance() {
        if (menu == null) {
            menu = new ScoreBoardMenuView();
        }
        return menu;
    }

    public void run(Scanner scanner) {
        while (true) {
            String command = scanner.nextLine();
            command = command.trim();
            if (!new ScoreboardMenuController(command).run()) break;
        }
    }

    public void printing(String result) {
        System.out.println(result);
    }

}
