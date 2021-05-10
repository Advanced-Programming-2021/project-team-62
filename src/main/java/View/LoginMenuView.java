package View;

import Controller.LoginMenuController;
import Model.Player;

import java.util.Scanner;

public class LoginMenuView {

    public void run(Scanner scanner){
        while(true){
            String command = scanner.nextLine();
            command=command.trim();
            Player result=new LoginMenuController(command).run();
            if(result.equals("Exit")){
                break;
            }
            else if(result.equals("go to main menu")){

            }
        }
    }

    public void printing(String result){
        System.out.println(result);
    }
}
