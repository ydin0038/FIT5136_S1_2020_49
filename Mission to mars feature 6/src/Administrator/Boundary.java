package Administrator;

import java.util.Scanner;

public class Boundary {

    public void displayLogInScreen() {
        Input input = new Input();
        String userName = "";
        int passWord = 0;
        System.out.println(" ");
        System.out.println("-----------Welcome to Mission to Mars-----------");
        System.out.println("Please enter your user name and password:");
        userName = input.acceptStringInput("User name: ");
        passWord = input.acceptStringInput("Password: ");
        System.out.println("Press enter to log in.");
        System.out.println("----------------------------------------------------");
    }
    public void displayExitScreen() {

    }
    public void displayHomeMenu() {

    }

    public void displayMissionInformation() {
    }
    public void displayShuttleInformation() {
    }
    public void displayCriteria() {
    }
    public void displayBestCandidates() {
    }
    public void displayCandidateInformation() {

    }
    public void displayUserCharacterTypeError() {
    }
    public void displayMissionNumberError() {

    }

}