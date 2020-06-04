/**
 * Class of the user interface
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintWriter;

public class UserInterface{

    private static MissionToMarsSystem system = new MissionToMarsSystem();

    public static void  main(String[] args) {
        boolean displayLogIn = true;
        Users user = new Users();
        System.out.println("-----Welcome to Mission to mars-----");
        while (displayLogIn) {
            System.out.println("Please entering your UserId.");
            String userId = readUserStringInput();
            System.out.println("Your userId is: " + userId + ". Please entering your password.");
            String password = readUserStringInput();
            System.out.println("Figuring authorization.");
            boolean logInSuccess = system.verifyUser(userId,password,user);
            if (logInSuccess)
            {
                System.out.println("Login Success. Welcome " + user.getCharacterType());
                displayLogIn = false;
            }
            else System.out.println("Wrong userId or Password. Please input again");
        }

        if(user.getCharacterType().equals("Administrator")) {
            //这里预先设个mission, 具体怎么load所有有关的mission在feature1里。
            Mission mission = new Mission();
            Administrator ad = user.setAdministrator();
            //设置个无限循环，这样1/2/3的活动结束后可以自动跳转到administrator界面。
            while(true){
                System.out.println("===Welcome Mr." + ad.getAdminName() + "===");
                System.out.println("You are working as an administrator ");
                System.out.println("Select your choice by inputing the corresponding number for the further operation.");
                System.out.println("1: My mission.");
                System.out.println("2: Space shuttle.");
                System.out.println("3: Candidates");
                System.out.println("4: LogOut");
                int i = readUserIntInput();
                switch(i) {
                    case 1:
                        System.out.println("Things to do in case 1.");
                        break;
                    case 2:
                        if (mission.getShuttle() == null) {
                            Shuttle shuttle = new Shuttle();
                            shuttle = MissionToMarsSystem.selectShuttle();
                            mission.setShuttle(shuttle);
                            //这里请做feature 1的同学把新选择的shuttle写进mission数据库中。

                        } else {
                            //showDetails()用来展示shuttle的信息，具体代码在Shuttle类里。
                            mission.getShuttle().showDetails();

                            System.out.println("Input any string to move back to move back to administrator interface.");
                            //在这里放个没啥用的读string方法是为了让页面能停留在shuttle detail上。
                            readUserStringInput();
                            break;
                        }
                    case 3:
                        System.out.println("Things to do in case 3");
                        break;
                    case 4:
                        MissionToMarsSystem.logOut();
                        break;
                    default:
                        System.out.println("Please enter the valid value.");
                        break;
                }
            }
        }
    }

    public static String readUserStringInput(){
            Scanner sc = new Scanner(System.in);
            String output = sc.nextLine();
            return output;
    }

    public static int readUserIntInput(){
            Scanner sc = new Scanner(System.in);
            int output = sc.nextInt();
            return output;
    }

    public static void logOut() {
        System.exit(00);
    }
}
