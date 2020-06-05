package Administrator; /**
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
                System.out.println("===Welcome Mr/Ms." + ad.getAdminName() + "===");
                System.out.println("You are working as an administrator ");
                System.out.println("Select your choice by inputting the corresponding number for the further operation.");
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

        if(user.getCharacterType().equals("Candidate")) {

            //设置个无限循环，这样1/2/3的活动结束后可以自动跳转到candidate界面。
            while(true){
                System.out.println("===Welcome to Mission to Mars, " + user.getUserID() + "===");
                System.out.println("You are working as a candidate ");
                System.out.println("Select your choice by inputting the corresponding number for the further operation.");
                System.out.println("1: Create your profile ");
                System.out.println("2: Edit your profile ");
                System.out.println("3: LogOut");
                int i = readUserIntInput();
                switch(i) {
                    case 1:
                        System.out.println("Please entering your information.");
                        System.out.println("1. Name: ");
                        String name = readUserStringInput();
                        System.out.println("Your name is: " + name);
                        System.out.println("2. Date of birth: ");
                        String birthDay = readUserStringInput();
                        System.out.println("Your birthday is: " + birthDay);
                        System.out.println("3. Address: ");
                        String address = readUserStringInput();
                        System.out.println("Your address is: " + address);
                        System.out.println("4. Nationality: ");
                        String nationality = readUserStringInput();
                        System.out.println("Your nationality is: " + nationality);
                        System.out.println("5. Identification number: ");
                        int id = readUserIntInput();
                        System.out.println("Your ID is: " + id);
                        String identification = Integer.toString(id);
                        System.out.println("6. Gender: ");
                        String gender = readUserStringInput();
                        System.out.println("Your gender is: " + gender);
                        System.out.println("7. Allergies: ");
                        String allergies = readUserStringInput();
                        System.out.println("Your allergies are: " + allergies);
                        System.out.println("8. Food preferences: ");
                        String foodPre = readUserStringInput();
                        System.out.println("Your food preferences are: " + foodPre);
                        System.out.println("9. Qualification(s): ");
                        String qualification = readUserStringInput();
                        System.out.println("Your qualification(s) is/are: " + qualification);
                        System.out.println("10. Work experience: ");
                        String workExp = readUserStringInput();
                        System.out.println("Your work experience is: " + workExp);
                        System.out.println("11. Occupation(s): ");
                        String occupation = readUserStringInput();
                        System.out.println("Your occupation(s) is/are: " + occupation);
                        System.out.println("12. Computer skills: ");
                        String comSki = readUserStringInput();
                        System.out.println("Your computer skills are: " + comSki);
                        System.out.println("13. Language(s) spoken: ");
                        String languageSpo = readUserStringInput();
                        System.out.println("Your language(s) spoken is/are: " + languageSpo);
                        String canInfo = user.getUserID() + ";" + name + ";" + birthDay + ";" + address + ";" + nationality + ";"
                                + identification + ";" + gender + ";" + allergies + ";" + foodPre + ";"
                                + qualification + ";" + workExp + ";" + occupation + ";" + comSki + ";"
                                + languageSpo;
                        int input = 0;
                        do {
                            System.out.println("Do you want to submit your information? ");
                            System.out.println("1. Yes.   2. No. ");
                            input = readUserIntInput();
                            if (input == 1) {
                                system.writeFile("CandidateInfo.txt", canInfo);
                                System.out.println("Successfully submitted. ");
                                }
                            else if (input == 2)
                                System.out.println("The information is not submitted. ");
                            else
                                System.out.println("Please enter the valid value.");
                        } while(input != 1 && input != 2 );
                        break;
                    case 2:
                        ArrayList<Candidate> canList = new ArrayList<Candidate>();
                        String[] candidateInfo = system.readFile("CandidateInfo.txt").split("\\n");
                        String[] canDetails = new String[16];
                        for (int index = 0; index < candidateInfo.length; index++){
                            canDetails = candidateInfo[index].split(";");
                                                        Candidate tempCan = new Candidate(canDetails[1], canDetails[2], canDetails[3], canDetails[4],
                                    Integer.parseInt(canDetails[5]), canDetails[6], canDetails[7], canDetails[8], canDetails[9],
                                    canDetails[10], canDetails[11], canDetails[12], canDetails[13], Boolean.valueOf(canDetails[14]),
                                    Boolean.valueOf(canDetails[15]));
                            canList.add(tempCan);
                            canList.get(index).setUserID(canDetails[0]);
                        }
                        int can = 0;
                        for (int index = 0; index < canList.size(); index++) {
                            if ( user.getUserID().equals( canList.get(index).getUserID()) ) {
                                System.out.println("There is your profile information: ");
                                System.out.println("1. Name: " + canList.get(index).getCanName());
                                System.out.println("2. Date of birth: " + canList.get(index).getBirthday());
                                System.out.println("3. Address: " + canList.get(index).getAddress());
                                System.out.println("4. Nationality: " + canList.get(index).getNationality());
                                System.out.println("5. Identification number: " + canList.get(index).getIdentificationNumb());
                                System.out.println("6. Gender: " + canList.get(index).getGender());
                                System.out.println("7. Allergies: " + canList.get(index).getAllergies());
                                System.out.println("8. Food preferences: " + canList.get(index).getFoodPreference());
                                System.out.println("9. Qualification(s): " + canList.get(index).getQualification());
                                System.out.println("10. Work experience: " + canList.get(index).getWorkExperience());
                                System.out.println("11. Occupation(s): " + canList.get(index).getOccupation());
                                System.out.println("12. Computer skills: " + canList.get(index).getComputerSkill());
                                System.out.println("13. Language(s) spoken: " + canList.get(index).getLanguage());
                                System.out.println("14. Health records: " + canList.get(index).isHealthRecord());
                                System.out.println("15. Criminal records: " + canList.get(index).isCriminalRecord());
                                can = index;

                            }
                        }
                        int option = 1;
                        do {
                            System.out.println("Please enter the option which you want to edit (without 14 and 15)");
                            System.out.println("Please press 0 to end the edit");
                            option = readUserIntInput();
                            if (option == 0)
                                break;
                            else {
                                System.out.println("Please enter your new information: ");
                                String info = readUserStringInput();
                                System.out.println("Do you want to save it?");
                                System.out.println("1. Yes.   2. No. ");
                                int save = readUserIntInput();
                                if (save == 1) {
                                    switch (option) {
                                        case 1:
                                            canList.get(can).setCanName(info);
                                            break;
                                        case 2:
                                            canList.get(can).setBirthday(info);
                                            break;
                                        case 3:
                                            canList.get(can).setAddress(info);
                                            break;
                                        case 4:
                                            canList.get(can).setNationality(info);
                                            break;
                                        case 5:
                                            canList.get(can).setIdentificationNumb(Integer.parseInt(info));
                                            break;
                                        case 6:
                                            canList.get(can).setGender(info);
                                            break;
                                        case 7:
                                            canList.get(can).setAllergies(info);
                                            break;
                                        case 8:
                                            canList.get(can).setFoodPreference(info);
                                            break;
                                        case 9:
                                            canList.get(can).setQualification(info);
                                            break;
                                        case 10:
                                            canList.get(can).setWorkExperience(info);
                                            break;
                                        case 11:
                                            canList.get(can).setOccupation(info);
                                            break;
                                        case 12:
                                            canList.get(can).setComputerSkill(info);
                                            break;
                                        case 13:
                                            canList.get(can).setLanguage(info);
                                            break;
                                        default:
                                            break;
                                    }
                                    System.out.println("Successfully saved!");
                                }
                                if (save == 2)
                                    System.out.println("Fail to save.");
                            }
                        } while (option != 0);
                        String canNewInfo = canList.get(can).getUserID() + ";" + canList.get(can).getCanName() + ";" +
                                canList.get(can).getBirthday() + ";" + canList.get(can).getAddress() + ";" +
                                canList.get(can).getNationality() + ";" + canList.get(can).getIdentificationNumb() + ";" +
                                canList.get(can).getGender() + ";" + canList.get(can).getAllergies() + ";" +
                                canList.get(can).getFoodPreference() + ";" + canList.get(can).getQualification() + ";" +
                                canList.get(can).getWorkExperience() + ";" + canList.get(can).getOccupation() + ";" +
                                canList.get(can).getComputerSkill() + ";" + canList.get(can).getLanguage() + ";" +
                                canList.get(can).isHealthRecord() + ";" + canList.get(can).isCriminalRecord();
                        do {
                            System.out.println("Do you want to submit your information? ");
                            System.out.println("1. Yes.   2. No. ");
                            input = readUserIntInput();
                            if (input == 1) {
                                system.writeFile("CandidateInfo.txt", canNewInfo);
                                System.out.println("Successfully submitted. ");
                            }
                            else if (input == 2)
                                System.out.println("The information is not submitted. ");
                            else
                                System.out.println("Please enter the valid value.");
                        } while(input != 1 && input != 2 );
                        break;
                    case 3:
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
