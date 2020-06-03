import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MissionToMarsSystem {

    //登录的方法。
    public static Users Login(){
        //设置一个无限循环，使得这个方法不能return一个存在于数据库里的的user时，回到登录和输入密码步骤。
        while(true){
            //这里不清屏是因为userinterface有个欢迎标语，如果用户名密码不对也应该有提示语。
            System.out.println("Please entering your UserId, it must be a 4-digit int.");
            Users user = new Users();
            int userId = readUserIntInput(1000,9999);
            //清屏。
            System.out.print('\u000C');
            System.out.println("Your userId is: "+userId + ". Please entering your password.");
            String password = readUserStringInput();
            //清屏
            System.out.print('\u000C');
            System.out.println("Figuring authorization...");
            String[] users = readFile("UserInfo").split("\\n");
            for(int i = 0; i < users.length;i++){
                //加载所有user数据方便比较。
                String[] userInfoArray = users[i].split(",");
                for(int n = 0;n<userInfoArray.length;n++){
                    //当数据库里存在一个userID和password都符合输入的user时将该用户return，没有找到的时候返回输入密码界面。
                    if (Integer.toString(userId).equals( userInfoArray[0]) && password.equals(userInfoArray[1])){
                        user.setUserID(userId);
                        user.setPassword(userInfoArray[1]);
                        user.setCharacterType(userInfoArray[2]);
                        return user;
                    }
                    else{
                        System.out.println("Wrong userId or Password.");
                    }
                }
            }
        }
    }

    //登出命令，要用直接call即可。
    public static void logOut()
    {
        System.exit(00);
    }

    //读取用户的string输入，对notnull进行了检测，没加notblank检测的原因是目前用不到。
    public static String readUserStringInput(){
        while(true) {
            Scanner sc = new Scanner(System.in);
            String output = sc.nextLine();
            sc.close();
            if (output != null) {
                return output;
            } else {
                System.out.println("The input cannot be null.");
            }
        }
    }

    public static int readUserIntInput(int minimum, int maximum){
        while(true) {
            Scanner sc = new Scanner(System.in);
            int output = sc.nextInt();
            sc.close();
            if(output <= maximum && output>= minimum ) {
                return output;
            }
            else{
                System.out.println("Please entering a valid input.");
            }
        }
    }

    public static Shuttle selectShuttle(){
        ArrayList<Shuttle> shuttleList = new ArrayList<Shuttle>();
        String[] shuttleInfo = readFile("SpaceShuttle").split("\\n");
        for (int i = 0;i < shuttleInfo.length;i++){
            String[] shuttleDetails = shuttleInfo[i].split(";");
            Shuttle tempShuttle = new Shuttle(Integer.valueOf(shuttleDetails[0]),shuttleDetails[1],Integer.valueOf(shuttleDetails[2]),
                    Integer.valueOf(shuttleDetails[3]),Integer.valueOf(shuttleDetails[4]),Integer.valueOf(shuttleDetails[5]),Integer.valueOf(shuttleDetails[6]),shuttleDetails[7]);
            shuttleList.add(tempShuttle);
        }
        System.out.println("Here is the shuttle details, please enter your selection.");
        while(true) {
            for (int a = 0; a < shuttleList.size(); a++) {
                System.out.println(shuttleList.get(a).showIdAndName(a + 1));
            }
            int detailSelection = readUserIntInput(1,shuttleList.size());
            System.out.print('\u000C');
            shuttleList.get(detailSelection - 1).showDetails();
            System.out.println("Input 1 to select this shuttle, input 2 to go back to selection interface.");
            int d = readUserIntInput(1,2);
            if (d == 1){
                int selection = readUserIntInput(1,shuttleList.size());
                Shuttle selectedShuttle = shuttleList.get(selection-1);
                return selectedShuttle;
            }
        }
    }



    public static String readFile(String fileName){
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
