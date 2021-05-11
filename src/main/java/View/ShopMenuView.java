package View;

import Controller.ShopMenuController;
import Model.Player;

import java.util.Scanner;

public class ShopMenuView {
    private Player player;
    private static ShopMenuView menu;

    public static ShopMenuView getInstance(Player player) {
        if (menu == null) {
            menu = new ShopMenuView();
        }
        menu.setPlayer(player);
        return menu;
    }

    public void run(Scanner scanner) {
        while (true) {
            String command = scanner.nextLine();
            command = command.trim();
            if (!ShopMenuController.getInstance(player).run(command)) break;
        }
    }

    public void printing(String result) {
        System.out.println(result);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
