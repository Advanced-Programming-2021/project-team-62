package Controller;

import View.LoginMenuView;
import View.MainMenuView;
import View.Regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenuController {
    private String command;

    public MainMenuController (String command){
        this.command=command;
    }

    public Matcher getMatcher(String command, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);
        return matcher;
    }

    public String run(){
        ArrayList<String> menuRegex= Regex.getMenuRegex();
        if(getMatcher(command, menuRegex.get(0)).find()){
            return getMatcher(command, menuRegex.get(0)).group(1);
        }
        else if(getMatcher(command, menuRegex.get(1)).find()){
            return "exit";
        }
        else if(getMatcher(command, menuRegex.get(2)).find()){
            new MainMenuView().printing("Main Menu");
            return "continue";
        }
        else{
            new MainMenuView().printing("invalid command");
            return "continue";
        }
    }
}
