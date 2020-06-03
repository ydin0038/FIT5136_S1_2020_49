import java.util.Scanner;
import java.io.*;

public class MissionToMarsSystem {
    public static Users Login(){
        System.out.println("Welcome to Mission to mars.");
        while(true){
            System.out.println("Please entering your UserId.");
            Users user = new Users();
            int userId = readUserIntInput();
            System.out.println("Your userId is: "+userId + ". Please entering your password.");
            String password = readUserStringInput();
            System.out.println("Figuring authorization.");
            String[] users = ReadFile("UserInfo").split("\\n");
            for(int i = 0; i < users.length;i++){
                String[] userInfoArray = users[i].split(",");
                for(int n = 0;n<userInfoArray.length;n++){
                    if (Integer.toString(userId).equals( userInfoArray[0]) && password.equals(userInfoArray[1])){
                        user.setUserID(userId);
                        user.setPassword(userInfoArray[1]);
                        user.setCharacterType(userInfoArray[2]);
                        return user;
                    }
                    else{
                        System.out.println("Wrong userId or Password");
                    }
                }
            }
        }
    }

    public static void logOut()
    {
        System.exit(00);
    }

    public static String readUserStringInput(){
        Scanner sc = new Scanner(System.in);
        String output = sc.nextLine();
        sc.close();
        return output;
    }

    public static int readUserIntInput(){
        Scanner sc = new Scanner(System.in);
        int output = sc.nextInt();
        sc.close();
        return output;
    }

    public static String ReadFile(String fileName){
        String input = "";
        if (fileName.trim().length() != 0){
            try{
                FileReader inputFile = new FileReader(fileName);
                Scanner parser = new Scanner(inputFile);
                while(parser.hasNextLine()){
                    input += parser.nextLine();
                    input += "\n";
                }
                inputFile.close();

            }
            catch(FileNotFoundException e){
                System.out.println(fileName + "not found");
            }
            catch(IOException exception) {
                System.out.println("An unexpected I/Oo error has just occured.");
            }
        }
        return input;
    }

    public void writeFile(String fileName,String input)
    {
        if(fileName.trim().length() != 0 && input.trim().length() != 0){
            try{
                PrintWriter pr = new PrintWriter(fileName);
                pr.write(input);
                pr.close();
            }
            catch(FileNotFoundException e){
                System.out.println(fileName + "not found");
            }
            catch(IOException e){
                System.out.println("An unexpectedI/O error has just occured.");
            }
        }
    }

}
