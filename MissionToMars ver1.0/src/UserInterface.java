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
        System.out.println("-----Welcome to Mission to mars-----");
        while (displayLogIn) {
            System.out.println("Please entering your UserId.");
            String userId = readUserStringInput();
            System.out.println("Your userId is: " + userId + ". Please entering your password.");
            String password = readUserStringInput();
            System.out.println("Figuring authorization.");
            boolean logInSuccess = system.verifyUser(userId,password);
            if (logInSuccess)
            {
                System.out.println("Login Success. Welcome " + system.getUser().getCharacterType());
                displayLogIn = false;
            }
            else System.out.println("Wrong userId or Password. Please input agin");
        }
    }

    public static String readUserStringInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int readUserIntInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void logOut() {
        System.exit(00);
    }
}
