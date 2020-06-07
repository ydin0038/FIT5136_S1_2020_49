/**
 * Class of the user interface
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    private static MissionToMarsSystem system = new MissionToMarsSystem();

    public static void main(String[] args) {
        boolean displayLogIn = true;
        System.out.println("-----Welcome to Mission to mars-----");
        while (displayLogIn) {
            System.out.println("Please entering your UserId.");
            String userId = readUserStringInput();
            System.out.println("Your userId is: " + userId + ". Please entering your password.");
            String password = readUserStringInput();
            System.out.println("Figuring authorization.");
            boolean logInSuccess = system.verifyUser(userId, password);
            if (logInSuccess) {
                System.out.println("Login Success. Welcome " + system.getUser().getCharacterType());
                switch (system.getUser().getCharacterType()) {
                    case "Administrator":
                        homeMenuforAdmin();
                        break;
                    case "Coordinator":
                        homeMenuforCoordinator();
                        break;
                    case "Candidate":
                        homeMenuforCandidate();
                        break;
                }
                displayLogIn = false;
            } else System.out.println("Wrong userId or Password. Please input again");
        }
    }

    public static void homeMenuforCoordinator() {
        while (true) {
            System.out.println("===Welcome " + "Coordinator " + system.getUser().getUserID() + "===");
            System.out.println("You are working as an Coordinator");
            System.out.println("Select your choice by inputing the corresponding number for the further operation.");
            System.out.println("1: Create Mission.");
            System.out.println("2: Edit Mission information.");
            System.out.println("3: LogOut");
            int i = readUserIntInput();
            switch (i) {
                // 1.missionId;2.missionName;3.missionDescription;4.countryOfOrigin;5.countriesAllowed;
                // 6.coordinator;7.cargoRequirement;8.Jobs;9.launchDate;10.destination;11.duration;12,missionStatus;13.shuttle
                case 1:
                    system.createMission();
                    break;
                case 2:
                    system.editMission();
                    break;
                case 3:
                    System.out.println("Log out");
                    break;
                default:
                    System.out.println("Please enter the valid value.");
                    break;
            }
        }
    }

    public static void homeMenuforAdmin() {
        //这里预先设个mission, 具体怎么load所有有关的mission在feature1里。
        Mission mission = new Mission();
        Administrator ad = system.getUser().setAdministrator();
        while (true) {
            System.out.println("===Welcome " + ad.getAdminName() + "===");
            System.out.println("You are working as an administrator ");
            System.out.println("Select your choice by inputing the corresponding number for the further operation.");
            System.out.println("1: Edit mission information.");
            System.out.println("2: Space shuttle.");
            System.out.println("3: Candidates");
            System.out.println("4: LogOut");
            int i = readUserIntInput();
            switch (i) {
                case 1:
                    system.editMission();
                    break;
                case 2:
                    system.selectShuttle();
                    break;
                case 3:
                    system.viewBestCandidates();
                    break;
                case 4:
                    logOut();
                    break;
                default:
                    System.out.println("Please enter the valid value.");
                    break;
            }
        }
    }

    public static void homeMenuforCandidate() {
        while (true) {
            System.out.println("===Welcome to Mission to Mars, " + system.getUser().getUserID() + "===");
            System.out.println("You are working as a candidate ");
            System.out.println("Select your choice by inputting the corresponding number for the further operation.");
            System.out.println("1: Create your profile ");
            System.out.println("2: Edit your profile ");
            System.out.println("3: LogOut");
            int i = readUserIntInput();
            switch (i) {
                case 1:
                    system.createCandidateProfile();
                    break;
                case 2:
                    system.editCandidateProfile();
                    break;
                case 3:
                    logOut();
                    break;
                default:
                    System.out.println("Please enter the valid value.");
                    break;
            }
        }
    }


    public static String readUserStringInput() {
        Scanner sc = new Scanner(System.in);
        String output = sc.nextLine();
        while (output.trim().equals("")) {
            System.out.print("Empty input.Please input again");
            output = sc.nextLine();
        }
        return output;
    }

    public static int readUserIntInput() {
        Scanner sc = new Scanner(System.in);
        int output = 0;
        try {
            output = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("Invalid.Please input again");
        }
        return output;
    }

    public static void logOut() {
        System.exit(00);
    }
}
