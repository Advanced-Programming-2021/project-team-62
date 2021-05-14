package View;

import Controller.MainMenuController;
import Model.Player;

import java.util.Scanner;

public class MainMenuView {

    public void run(Scanner scanner, Player player){
        while(true){
            String command = scanner.nextLine();
            command=command.trim();
            String result= new MainMenuController(command).run();
            if(result.equals("exit")){
                return;
            }
            else if(result.equals("continue")){
                continue;
            }
            else{
                if(result.equals("duel menu")){

                }
                else if(result.equals("deck menu")){

                }
                else if(result.equals("scoreboard menu")) {

                }
                else if(result.equals("profile menu")){

                }
                else if(result.equals("shop menu")){

                }
                else if(result.equals("import/export menu")){

                }
                else{
                    printing("invalid command");
                    continue;
                }
            }
        }


    }
    public void printing(String result){
        System.out.println(result);
    }
}
