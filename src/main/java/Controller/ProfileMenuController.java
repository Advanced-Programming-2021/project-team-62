package Controller;

import Model.Player;
import View.DeckMenuView;
import View.ProfileMenuView;
import View.Regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileMenuController {
    private Player player;
    private static ProfileMenuController menu;

    public static ProfileMenuController getInstance(Player player) {
        if (menu == null) {
            menu = new ProfileMenuController();
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
        ArrayList<String> profileMenuRegex = Regex.getProfileRegex();
        Matcher matcher;
        if (getMatcher(command, menuRegex.get(0)).find()) {
            enterMenu();
            return true;
        } else if (getMatcher(command, menuRegex.get(1)).find()) {
            return false;

        } else if (getMatcher(command, menuRegex.get(2)).find()) {
            showCurrentMenu();
            return true;

        } else if (getMatcher(command, profileMenuRegex.get(0)).find()) {
            matcher = getMatcher(command, profileMenuRegex.get(0));
            changeNickname(matcher);
            return true;

        } else if (getMatcher(command, profileMenuRegex.get(1)).find()) {
            matcher = getMatcher(command, profileMenuRegex.get(1));
            changePassword(matcher);
            return true;

        } else {
            ProfileMenuView.getInstance(player).printing("invalid command");
            return true;

        }
    }

    private void enterMenu() {
        ProfileMenuView.getInstance(player).printing("menu navigation is not possible");
    }

    private void showCurrentMenu() {
        ProfileMenuView.getInstance(player).printing("Profile");
    }

    private void changeNickname(Matcher matcher) {
        matcher.find();
        String newNickname = matcher.group(1);
        Player tempPlayer = Player.getPlayerByNickname(newNickname);
        if (tempPlayer == null) {
            ProfileMenuView.getInstance(player).printing("nickname changed successfully!");
            player.setNickname(newNickname);
        } else {
            ProfileMenuView.getInstance(player).printing("user with nickname " + newNickname + " already exists");
        }
    }

    private void changePassword(Matcher matcher) {
        matcher.find();
        String currentPassword = matcher.group(1);
        String newPassword = matcher.group(2);
        String realPassword = player.getPassword();
        if (!currentPassword.equals(realPassword)) {
            ProfileMenuView.getInstance(player).printing("current password is invalid");
            return;
        }
        if (currentPassword.equals(newPassword)) {
            ProfileMenuView.getInstance(player).printing("please enter a new password");
            return;
        }
        ProfileMenuView.getInstance(player).printing("password changed successfully!");
        player.setPassword(newPassword);
    }
}
