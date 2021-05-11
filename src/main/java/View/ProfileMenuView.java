package View;

import Controller.ProfileMenuController;
import Model.Player;

import java.util.Scanner;

public class ProfileMenuView {
    private Player player;
    private static ProfileMenuView menu;

    public static ProfileMenuView getInstance(Player player) {
        if (menu == null) {
            menu = new ProfileMenuView();
        }
        menu.setPlayer(player);
        return menu;
    }

    public void run(Scanner scanner) {
        while (true) {
            String command = scanner.nextLine();
            command = command.trim();
            if (!ProfileMenuController.getInstance(player).run(command)) break;
        }
    }

    public void printing(String result) {
        System.out.println(result);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
