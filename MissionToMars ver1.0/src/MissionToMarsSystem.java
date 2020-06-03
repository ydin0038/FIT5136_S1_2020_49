import java.util.Scanner;
import java.io.*;

public class MissionToMarsSystem {

    private static Users user = new Users();

    /**
     * Method to verify the user account
     * @param userId userId is accepted from the UI
     * @param password password is accepted from the UI
     * @return boolean value represent whether the user exist
     */
    public static boolean verifyUser(String userId,String password){
        boolean success = false;
        // read the file which stores the user information
        String[] usersInfo = MissionToMarsSystem.readFile("UserInfo.txt").split("\\n");
        // check each line
        for (int i = 0; i < usersInfo.length; i++) {
            String[] userInfoArray = usersInfo[i].split(",");
            for (int n = 0; n < userInfoArray.length; n++) {
                if (userId.equals(userInfoArray[0]) && password.equals(userInfoArray[1])) {
                    user.setUserID(userId);
                    user.setPassword(userInfoArray[1]);
                    user.setCharacterType(userInfoArray[2]);
                    success = true;
                }
            }
        }
        return  success;
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

    public static Users getUser() {
        return user;
    }

    /*
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

     */

}
