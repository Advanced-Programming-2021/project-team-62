package Controller;

import Model.Player;
import View.LoginMenuView;
import View.Regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenuController {
    private final String command;

    public LoginMenuController(String command) {
        this.command = command;
    }

    public Matcher getMatcher(String command, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);
        return matcher;
    }

    public Player run() {
        ArrayList<String> loginRegex = Regex.getLoginRegex();
        ArrayList<String> menuRegex = Regex.getMenuRegex();
        ArrayList<String> registerRegex = Regex.getRegisterRegex();
        if (getMatcher(command, loginRegex.get(0)).find()){
            Matcher matcher=getMatcher(command,loginRegex.get(0));
            return login(matcher.group(1),matcher.group(2));
        }
        else if(getMatcher(command,loginRegex.get(1)).find()){
            Matcher matcher=getMatcher(command,loginRegex.get(1));
            return login(matcher.group(2),matcher.group(1));
        }
        /*else if(getMatcher(command,loginRegex.get(2)).find()){

        }
        else if(getMatcher(command,loginRegex.get(3)).find()){

        }
        else if(getMatcher(command,loginRegex.get(4)).find()){

        }
        else if(getMatcher(command,loginRegex.get(5)).find()){

        }
        else if(getMatcher(command,loginRegex.get(6)).find()){

        }
        else if(getMatcher(command,loginRegex.get(7)).find()){

        }*/
        else if(getMatcher(command,registerRegex.get(0)).find()){
            Matcher matcher=getMatcher(command,registerRegex.get(0));
            register(matcher.group(1),matcher.group(3),matcher.group(2));
            return null;
        }
        else if(getMatcher(command,registerRegex.get(1)).find()){
            Matcher matcher=getMatcher(command,registerRegex.get(1));
            register(matcher.group(1),matcher.group(2),matcher.group(3));
            return null;
        }
        else if(getMatcher(command,registerRegex.get(2)).find()){
            Matcher matcher=getMatcher(command,registerRegex.get(2));
            register(matcher.group(2),matcher.group(1),matcher.group(3));
            return null;
        }
        else if(getMatcher(command,registerRegex.get(3)).find()){
            Matcher matcher=getMatcher(command,registerRegex.get(3));
            register(matcher.group(2),matcher.group(3),matcher.group(1));
            return null;
        }
        else if(getMatcher(command,registerRegex.get(4)).find()){
            Matcher matcher=getMatcher(command,registerRegex.get(4));
            register(matcher.group(3),matcher.group(1),matcher.group(2));
            return null;
        }
        else if(getMatcher(command,registerRegex.get(5)).find()){
            Matcher matcher=getMatcher(command,registerRegex.get(5));
            register(matcher.group(3),matcher.group(2),matcher.group(1));
            return null;
        }
        /*else if(getMatcher(command,registerRegex.get(6)).find()){

        }
        else if(getMatcher(command,registerRegex.get(7)).find()){

        }
        else if(getMatcher(command,registerRegex.get(8)).find()){

        }
        else if(getMatcher(command,registerRegex.get(9)).find()){

        }
        else if(getMatcher(command,registerRegex.get(10)).find()){

        }
        else if(getMatcher(command,registerRegex.get(11)).find()){

        }*/
        else if(getMatcher(command,menuRegex.get(0)).find()){
            new LoginMenuView().printing("please login first");
            return null;
        }
        else if(getMatcher(command,menuRegex.get(1)).find()){
            return new Player("Exit","Exit","Exit");
        }
        else if(getMatcher(command,menuRegex.get(2)).find()){
            new LoginMenuView().printing("Login Menu");
            return null;
        }
        else{
            new LoginMenuView().printing("invalid command");
            return null;
        }
    }

    private Player login(String username, String password){
        if(isPasswordIncorrect(username,password)){
            new LoginMenuView().printing("Username and password didn’t match!");
            return null;
        }
        else{
            return Player.getPlayerByUsername(username);
        }
    }

    private void register(String username, String password, String nickname){
        if(isUsernameNew(username)){
            if(isNicknameNew(nickname)){
                new Player(username,password,nickname);
                new LoginMenuView().printing("user created successfully!");
            }
            else{
                new LoginMenuView().printing("user with nickname "+nickname+" already exists");
            }
        }
        else{
            new LoginMenuView().printing("user with username "+username+"already exists");
        }
    }

    private boolean isUsernameNew(String username){
        return Player.getPlayerByUsername(username) == null;
    }

    private boolean isNicknameNew(String nickname){
        return Player.getPlayerByNickname(nickname) == null;
    }

    private boolean isPasswordIncorrect(String username, String password){
        Player player=Player.getPlayerByUsername(username);
        return player == null || !player.getPassword().equals(password);
    }

}
