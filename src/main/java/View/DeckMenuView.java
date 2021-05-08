package View;

import Controller.DeckMenuController;
import Model.Player;

import java.util.Scanner;

public class DeckMenuView {
    private Player player;
    private static DeckMenuView menu;

    public static DeckMenuView getInstance(Player player) {
        if (menu == null) {
            menu = new DeckMenuView();
        }
        menu.setPlayer(player);
        return menu;
    }

    public void run(Scanner scanner) {
        while (true) {
            String command = scanner.nextLine();
            command = command.trim();
            if (!DeckMenuController.getInstance(player).run(command)) break;
        }
    }

    public void printing(String result) {
        System.out.println(result);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
