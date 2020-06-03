/**
 * Class of the user interface
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintWriter;

public class UserInterface {

    public static void startTheProgram() {
        System.out.println("Welcome to mission to mars.Press 1 to login, press 2 to log out.");
        int Selection = 0;
        switch (Selection) {
            case 1:
                //Login（）方法的代码在MissionToMarsSystem中。
                Users user = MissionToMarsSystem.Login();
                System.out.print('\u000C');
                //当用户是coordinator时。

                //当用户是administrator时。
                if(user.getCharacterType().equals("Administrator")) {
                    //这里预先设个mission, 具体怎么load所有有关的mission在feature1里。
                    Mission mission = new Mission();
                    Administrator ad = user.setAdministrator();
                    System.out.println("===Welcome Mr." + ad.getAdminName() + "===");
                    System.out.println("You are working as an administrator ");
                    System.out.println("Select your choice by inputing the corresponding number for the further operation.");
                    System.out.println("1: My mission.");
                    System.out.println("2: Space shuttle.");
                    System.out.println("3: Candidates");
                    System.out.println("4: LogOut");
                        int S = 0;
                        //设置个无限循环，这样1/2/3的活动结束后可以自动跳转到administrator界面。
                    while(true){
                        switch(S){
                            case 2:
                                if(mission.getShuttle() == null) {
                                    Shuttle shuttle = new Shuttle();
                                    shuttle = MissionToMarsSystem.selectShuttle();
                                    //这里请做feature 1的同学把新选择的shuttle写进mission数据库中。

                                }
                                else{
                                    //showDetails()用来展示shuttle的信息，具体代码在Shuttle类里。
                                    mission.getShuttle().showDetails();

                                    System.out.println("Input any string to move back to move back to administrator interface.");
                                    //在这里放个没啥用的读string方法是为了让页面能停留在shuttle detail上。
                                    MissionToMarsSystem.readUserStringInput();
                                }
                            case 4:
                                MissionToMarsSystem.logOut();
                        }
                    }
                }
                //当用户是candidate时。

            case 2:
                MissionToMarsSystem.logOut();
        }
    }

}
