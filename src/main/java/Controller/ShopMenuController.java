package Controller;

import Model.Player;
import View.Regex;
import View.ShopMenuView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShopMenuController {
    private Player player;
    private static ShopMenuController menu;

    public static ShopMenuController getInstance(Player player) {
        if (menu == null) {
            menu = new ShopMenuController();
        }
        menu.setPlayer(player);
        return menu;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    private Matcher getMatcher(String command, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(command);
    }

    public boolean run(String command) {
        ArrayList<String> menuRegex = Regex.getMenuRegex();
        ArrayList<String> ShopMenuRegex = Regex.getProfileRegex();
        Matcher matcher;
        if (getMatcher(command, menuRegex.get(0)).find()) {
            enterMenu();
            return true;
        } else if (getMatcher(command, menuRegex.get(1)).find()) {
            return false;

        } else if (getMatcher(command, menuRegex.get(2)).find()) {
            showCurrentMenu();
            return true;
        } else {
            ShopMenuView.getInstance(player).printing("invalid command");
            return true;
        }
    }

    private void enterMenu() {
        ShopMenuView.getInstance(player).printing("menu navigation is not possible");
    }

    private void showCurrentMenu() {
        ShopMenuView.getInstance(player).printing("Shop");
    }
}
