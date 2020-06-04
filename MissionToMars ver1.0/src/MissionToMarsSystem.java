import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MissionToMarsSystem {

    private Users user;

    /**
     * Method to verify the user account
     * @param userId userId is accepted from the UI
     * @param password password is accepted from the UI
     * @return boolean value represent whether the user exist
     */
    public static boolean verifyUser(String userId,String password,Users userinput){
        boolean success = false;
        // read the file which stores the user information
        String[] usersInfo = MissionToMarsSystem.readFile("UserInfo.txt").split("\\n");
        // check each line
        for (int i = 0; i < usersInfo.length; i++) {
            String[] userInfoArray = usersInfo[i].split(",");
            for (int n = 0; n < userInfoArray.length; n++) {
                if (userId.equals(userInfoArray[0]) && password.equals(userInfoArray[1])) {
                    userinput.setUserID(userId);
                    userinput.setPassword(userInfoArray[1]);
                    userinput.setCharacterType(userInfoArray[2]);
                    success = true;
                }
            }
        }

        return  success;
    }

    public static void logOut()
    {
        System.exit(00);
    }

    /**
     * Method to read the data file
     * @param fileName
     * @return
     */
    public static String readFile(String fileName) {
        String input = "";
        if (fileName.trim().length() != 0) {
            try {
                FileReader inputFile = new FileReader(fileName);
                Scanner parser = new Scanner(inputFile);
                while (parser.hasNextLine()) {
                    input += parser.nextLine();
                    input += "\n";
                }
                inputFile.close();

            } catch (FileNotFoundException e) {
                System.out.println(fileName + "not found");
            } catch (IOException exception) {
                System.out.println("An unexpected I/Oo error has just occured.");
            }
        }
        return input;
    }


    public void writeFile(String fileName, String input) {
        if (fileName.trim().length() != 0 && input.trim().length() != 0) {
            try {
                PrintWriter pr = new PrintWriter(fileName);
                pr.write(input);
                pr.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName + "not found");
            } catch (IOException e) {
                System.out.println("An unexpectedI/O error has just occured.");
            }
        }
    }
    public static Shuttle selectShuttle(){
        ArrayList<Shuttle> shuttleList = new ArrayList<Shuttle>();
        String[] shuttleInfo = readFile("SpaceShuttle.txt").split("\\n");
        for (int i = 0;i < shuttleInfo.length;i++){
            String[] shuttleDetails = shuttleInfo[i].split(";");
            Shuttle tempShuttle = new Shuttle(Integer.parseInt(shuttleDetails[0]),shuttleDetails[1],shuttleDetails[2], Integer.parseInt(shuttleDetails[3]),Integer.parseInt(shuttleDetails[4]),Integer.parseInt(shuttleDetails[5]),Integer.parseInt(shuttleDetails[6]),shuttleDetails[7]);
            shuttleList.add(tempShuttle);
        }
        System.out.println("Here is the shuttle details, please enter your selection.");
        while(true) {
            for (int a = 0; a < shuttleList.size(); a++) {
                System.out.println(shuttleList.get(a).showIdAndName(a + 1));
            }
            int detailSelection = UserInterface.readUserIntInput();
            System.out.print('\u000C');
            shuttleList.get(detailSelection - 1).showDetails();
            System.out.println("Input 1 to select this shuttle, input 2 to go back to selection interface.");
            int d = UserInterface.readUserIntInput();
            if (d == 1){
                int selection = detailSelection;
                Shuttle selectedShuttle = shuttleList.get(selection-1);
                System.out.println("Shuttle selected.");
                return selectedShuttle;

            }
        }
    }



}
