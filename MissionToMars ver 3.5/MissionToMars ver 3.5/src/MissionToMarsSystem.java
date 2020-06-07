import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MissionToMarsSystem {

    private static Users user = new Users();

    /**
     * Method to verify the user account
     *
     * @param userId   userId is accepted from the UI
     * @param password password is accepted from the UI
     * @return boolean value represent whether the user exist
     */
    public static boolean verifyUser(String userId, String password) {
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

        return success;
    }

    /**
     * Method to create a new mission and write its information to database
     */
    public void createMission() {
        String[] missionFile = readFile("MissionInfo.txt").split("\\n");
        int lastId = 0;
        for (int i = 1; i < missionFile.length; i++) {
            String[] item = missionFile[i].split(";");
            if (Integer.parseInt(item[0]) > lastId) {
                lastId = Integer.parseInt(item[0]);
            }
        }
        int missionId = lastId + 1;
        System.out.println(missionId);
        Mission mission = new Mission();
        mission.setMissionId(missionId);
        System.out.println("You select create a mission.");
        System.out.println("1. Mission Name: ");
        String missionName = UserInterface.readUserStringInput();
        mission.setMissionName(missionName);
        System.out.println("2. Mission Description: ");
        String missionDesc = UserInterface.readUserStringInput();
        mission.setDestination(missionDesc);
        System.out.println("3. Country Of Origin: ");
        String countryOfOrigin = UserInterface.readUserStringInput();
        mission.setCountryOfOrigin(countryOfOrigin);
        System.out.println("4. Countries Allowed (Mutiple countries should be seperated by comma): ");
        String countryAllowed = UserInterface.readUserStringInput();
        mission.setCountriesAllowed(countryAllowed);
        System.out.println("5. Coordinator Id: " + user.getUserID());

        // Multiple cargo Requirement
        System.out.println("6. Cargo Requirement: ");
        System.out.println("Please input the number of cargo types the mission need ");
        int cargoType = 0;
        while (cargoType <= 0) {
            cargoType = UserInterface.readUserIntInput();
        }
        ArrayList<CargoRequirement> cargoList = new ArrayList<>();
        for (int i = 0; i < cargoType; i++) {
            System.out.println("Select Cargo Usage: \n" +
                    "a. For the journey\n" +
                    "b. For the mission\n" +
                    "c. For other missions");
            String cargoUsage = UserInterface.readUserStringInput();
            System.out.println("Cargo Type: ");
            String cargo = UserInterface.readUserStringInput();
            System.out.println("Cargo amount: ");
            int numberRequired = UserInterface.readUserIntInput();
            CargoRequirement cargoRequired = new CargoRequirement(cargoUsage, cargo, numberRequired);
            cargoList.add(cargoRequired);
        }
        StringBuffer cargoBuffer = new StringBuffer();
        for (int i = 0; i < cargoList.size(); i++) {
            CargoRequirement item = cargoList.get(i);
            cargoBuffer.append(item.getCargoUsage()).append(": ").append(item.getCargoContent()).append(" ").append(item.getCargoRequiredNum()).append(",");
        }
        String cargoRequirement = cargoBuffer.toString();
        mission.setCargoRequirement(cargoRequirement);

        // Multiple Jobs
        System.out.println("7. Jobs: ");
        int jobNumber = 0;
        while (jobNumber <= 0) {
            System.out.println("Please input the number of jobs the mission need ");
            jobNumber = UserInterface.readUserIntInput();
        }
        ArrayList<Job> jobList = new ArrayList<>();
        for (int i = 0; i < jobNumber; i++) {
            System.out.println("Job name: ");
            String jobName = UserInterface.readUserStringInput();
            System.out.println("Job Description: ");
            String jobDesc = UserInterface.readUserStringInput();
            Job job = new Job(jobName, jobDesc);
            jobList.add(job);
        }
        StringBuffer jobBuffer = new StringBuffer();
        for (int i = 0; i < jobList.size(); i++) {
            Job job = jobList.get(i);
            jobBuffer.append(job.getJobName()).append(" ").append(job.getJobDescription()).append(",");
        }
        String job = jobBuffer.toString();
        mission.setJobs(job);

        //
        System.out.println("8. Launch Date (Format:DD-MM-YYYY): ");
        String launchDate = UserInterface.readUserStringInput();
        mission.setLaunchDate(launchDate);
        System.out.println("9. Destination: ");
        String destination = UserInterface.readUserStringInput();
        mission.setDestination(destination);
        System.out.println("10. Duration: ");
        int duration = 0;
        while (duration <= 0) {
            duration = UserInterface.readUserIntInput();
        }
        mission.setDuration(duration);
        System.out.println("11. Mission Status: Planning phase");
        mission.setMissionStatus("Planning phase");
        // Multiple Employment Requirement
        System.out.println("12. Employment Requirement");
        System.out.println("Please input the number of title required ");
        int titleRequired = 0;
        while (titleRequired <= 0) {
            titleRequired = UserInterface.readUserIntInput();
        }
        ArrayList<EmploymentRequirement> employList = new ArrayList<>();
        for (int i = 0; i < titleRequired; i++) {
            System.out.println("Title: ");
            String title = UserInterface.readUserStringInput();
            System.out.println("Number required: ");
            int number = UserInterface.readUserIntInput();
            EmploymentRequirement employmentRequirement = new EmploymentRequirement(title, number);
            employList.add(employmentRequirement);
        }
        StringBuffer employBuffer = new StringBuffer();
        for (int i = 0; i < employList.size(); i++) {
            EmploymentRequirement item = employList.get(i);
            employBuffer.append(item.getTitle()).append(": ").append(item.getRequiredNum()).append(",");
        }
        String employRequire = employBuffer.toString();
        mission.setEmploymentRequirement(employRequire);
        // mission information submit
        String missionInfo = missionId + ";" + missionName + ";" + missionDesc + ";" + countryOfOrigin + ";"
                + countryAllowed + ";" + user.getUserID() + cargoRequirement + ";" + job + ";" + launchDate + ";"
                + destination + ";" + duration + ";" + "Planning phase" + ";" + employRequire + "\n";
        int input;
        do {
            System.out.println("Do you want to submit your information? ");
            System.out.println("1. Yes.   2. No. ");
            input = UserInterface.readUserIntInput();
            if (input == 1) {
                writeFile("MissionInfo.txt", missionInfo);
                System.out.println("Mission created successfully. ");
            } else if (input == 2)
                System.out.println("The information is not submitted. ");
            else
                System.out.println("Please enter the valid value.");
        } while (input != 1 && input != 2);
    }

    /**
     * Method to edit mission information
     */
    public void editMission() {
        Mission missionEdit;
        System.out.println("Please input the ID of the mission you want to edit");
        String[] missionInfo = readFile("MissionInfo.txt").split("\\n");
        StringBuffer missionIdAndName = new StringBuffer();
        for (int i = 1; i < missionInfo.length; i++) {
            String[] item = missionInfo[i].split(";");
            missionIdAndName.append(item[0]).append(" ").append(item[1]).append("\n");
        }
        System.out.println(missionIdAndName);
        int option = UserInterface.readUserIntInput();
        int lineNumber = 0;
        boolean missionExist = false;
        for (int i = 0; i < missionInfo.length; i++) {
            String[] missionDetail = missionInfo[i].split(";");
            if (Integer.toString(option).equals(missionDetail[0])) {
                missionExist = true;
                lineNumber = i;
            }
        }
        StringBuffer loadAllRecord = new StringBuffer();
        for (int i = 0; i < missionInfo.length; i++) {
            if (i != lineNumber) {
                loadAllRecord.append(missionInfo[i]).append("\n");
            }
        }
        if (missionExist) {
            String[] detail = missionInfo[lineNumber].split(";");
            System.out.println("===Information of Mission " + option + "===");
            System.out.println("1.Mission Name: " + detail[1]);
            System.out.println("2.Mission Description: " + detail[2]);
            System.out.println("3.Country of Origin: " + detail[3]);
            System.out.println("4.Countries Allowed: " + detail[4]);
            System.out.println("5.Coordinator Id: " + detail[5]);
            System.out.println("6.Cargo Requirement: " + detail[6]);
            System.out.println("7.Jobs: " + detail[7]);
            System.out.println("8.Launch Date: " + detail[8]);
            System.out.println("9.Destination: " + detail[9]);
            System.out.println("10.Duration: " + detail[10]);
            System.out.println("11.Mission Status: " + detail[11]);
            System.out.println("12.Employment Requirement: " + detail[12]);
            missionEdit = new Mission(option, detail[1], detail[2], detail[3], detail[4], Integer.parseInt(detail[5]), detail[6], detail[7], detail[8], detail[9], Integer.parseInt(detail[10]), detail[11], detail[12]);
            boolean edit = true;
            while (edit) {
                System.out.println("Please input the number of information you want to edit");
                int option2 = UserInterface.readUserIntInput();
                switch (option2) {
                    case 1:
                        System.out.println("Please input new mission name: ");
                        missionEdit.setMissionName(UserInterface.readUserStringInput());
                        break;
                    case 2:
                        System.out.println("Please input new mission description: ");
                        missionEdit.setMissionDescription(UserInterface.readUserStringInput());
                        break;
                    case 3:
                        System.out.println("Please input new country of Origin: ");
                        missionEdit.setCountryOfOrigin(UserInterface.readUserStringInput());
                        break;
                    case 4:
                        System.out.println("Please input new countries allowed: ");
                        missionEdit.setCountriesAllowed(UserInterface.readUserStringInput());
                        break;
                    case 5:
                        System.out.println("Coordinator Id can not be changed.");
                        break;
                    case 6:
                        System.out.println("Please input the number of cargo types the mission need ");
                        int cargoType = 0;
                        while (cargoType <= 0) {
                            cargoType = UserInterface.readUserIntInput();
                        }
                        ArrayList<CargoRequirement> cargoList = new ArrayList<>();
                        for (int i = 0; i < cargoType; i++) {
                            System.out.println("Select Cargo Usage: \n" +
                                    "a. For the journey\n" +
                                    "b. For the mission\n" +
                                    "c. For other missions");
                            String cargoUsage = UserInterface.readUserStringInput();
                            System.out.println("Cargo Type: ");
                            String cargo = UserInterface.readUserStringInput();
                            System.out.println("Cargo amount: ");
                            int numberRequired = UserInterface.readUserIntInput();
                            CargoRequirement cargoRequired = new CargoRequirement(cargoUsage, cargo, numberRequired);
                            cargoList.add(cargoRequired);
                        }
                        StringBuffer cargoBuffer = new StringBuffer();
                        for (int i = 0; i < cargoList.size(); i++) {
                            CargoRequirement item = cargoList.get(i);
                            cargoBuffer.append(item.getCargoUsage()).append(": ").append(item.getCargoContent()).append(" ").append(item.getCargoRequiredNum()).append(",");
                        }
                        String cargoRequirement = cargoBuffer.toString();
                        missionEdit.setCargoRequirement(cargoRequirement);
                        break;
                    case 7:
                        int jobNumber = 0;
                        while (jobNumber <= 0) {
                            System.out.println("Please input the number of jobs the mission need ");
                            jobNumber = UserInterface.readUserIntInput();
                        }
                        ArrayList<Job> jobList = new ArrayList<>();
                        for (int i = 0; i < jobNumber; i++) {
                            System.out.println("Job name: ");
                            String jobName = UserInterface.readUserStringInput();
                            System.out.println("Job Description: ");
                            String jobDesc = UserInterface.readUserStringInput();
                            Job job = new Job(jobName, jobDesc);
                            jobList.add(job);
                        }
                        StringBuffer jobBuffer = new StringBuffer();
                        for (int i = 0; i < jobList.size(); i++) {
                            Job job = jobList.get(i);
                            jobBuffer.append(job.getJobName()).append(" ").append(job.getJobDescription()).append(",");
                        }
                        String job = jobBuffer.toString();
                        missionEdit.setJobs(job);
                        break;
                    case 8:
                        System.out.println("Please input new launch date: ");
                        missionEdit.setLaunchDate(UserInterface.readUserStringInput());
                        break;
                    case 9:
                        System.out.println("Please input new destination: ");
                        missionEdit.setDestination(UserInterface.readUserStringInput());
                        break;
                    case 10:
                        System.out.println("Please input new duration: ");
                        int duration = UserInterface.readUserIntInput();
                        while (duration <= 0) {
                            duration = UserInterface.readUserIntInput();
                        }
                        missionEdit.setDuration(duration);
                        break;
                    case 11:
                        System.out.println("a. Planning phase(selected by default)\n" +
                                "b. Departed Earth\n" +
                                "c. Landed on Mars\n" +
                                "d. Mission in progress\n" +
                                "e. Returned to Earth\n" +
                                "f. Mission completed\n");
                        System.out.println("Please input the option");
                        String statusOption = UserInterface.readUserStringInput();
                        String status = "";
                        switch (statusOption) {
                            case "a":
                                status = "Planning phase";
                                break;
                            case "b":
                                status = "Departed Earth";
                                break;
                            case "c":
                                status = "Landed on Mars";
                                break;
                            case "d":
                                status = "Mission in progress";
                                break;
                            case "e":
                                status = "Returned to Earth";
                                break;
                            case "f":
                                status = "Mission completed";
                                break;
                            default:
                                System.out.println("Invalid input, the mission is set to Planning phase");
                                status = "Planning phase";
                                break;
                        }
                        missionEdit.setMissionStatus(status);
                        break;
                    case 12:
                        System.out.println("Please input the number of title required ");
                        int titleRequired = 0;
                        while (titleRequired <= 0) {
                            titleRequired = UserInterface.readUserIntInput();
                        }
                        ArrayList<EmploymentRequirement> employList = new ArrayList<>();
                        for (int i = 0; i < titleRequired; i++) {
                            System.out.println("Title: ");
                            String title = UserInterface.readUserStringInput();
                            System.out.println("Number required: ");
                            int number = UserInterface.readUserIntInput();
                            EmploymentRequirement employmentRequirement = new EmploymentRequirement(title, number);
                            employList.add(employmentRequirement);
                        }
                        StringBuffer employBuffer = new StringBuffer();
                        for (int i = 0; i < employList.size(); i++) {
                            EmploymentRequirement item = employList.get(i);
                            employBuffer.append(item.getTitle()).append(": ").append(item.getRequiredNum()).append(",");
                        }
                        String employRequire = employBuffer.toString();
                        missionEdit.setEmploymentRequirement(employRequire);
                        break;
                    default:
                        System.out.println("Your option is invalid.");
                        break;
                }
                int input = 0;
                do {
                    System.out.println("Do you want to edit other information? ");
                    System.out.println("1. Yes.   2. No. ");
                    input = UserInterface.readUserIntInput();
                    if (input == 1) {
                        edit = true;
                    } else if (input == 2)
                        edit = false;
                    else
                        System.out.println("Please enter the valid value.");
                } while (input != 1 && input != 2);
            }
            String missionInfoEdit = missionEdit.getMissionId() + ";" + missionEdit.getMissionName() + ";" + missionEdit.getMissionDescription() +
                    ";" + missionEdit.getCountryOfOrigin() + ";" + missionEdit.getCountriesAllowed() + ";" + missionEdit.getCoordinatorId()
                    + ";" + missionEdit.getCargoRequirement() + ";" + missionEdit.getJobs() + ";" + missionEdit.getLaunchDate() + ";"
                    + missionEdit.getDestination() + ";" + missionEdit.getDuration() + ";" + missionEdit.getMissionStatus()
                    + ";" + missionEdit.getEmploymentRequirement();
            int option3 = 0;
            do {
                System.out.println("Do you want to finish your edition? ");
                System.out.println("1. Yes.   2. No. ");
                option3 = UserInterface.readUserIntInput();
                if (option3 == 1) {
                    loadAllRecord.append(missionInfoEdit).append("\n");
                    overwriteFile("MissionInfo.txt", loadAllRecord.toString());
                    System.out.println("Mission Information edited successfully. ");
                } else if (option3 == 2)
                    System.out.println("The information is not edited. ");
                else
                    System.out.println("Please enter the valid value.");
            } while (option3 != 1 && option3 != 2);

        }
    }


    /**
     * Method to select shuttle for a mission
     *
     * @return
     */
    public void selectShuttle() {
        String[] missionInfo = readFile("MissionInfo.txt").split("\\n");
        StringBuffer missionIdAndName = new StringBuffer();
        for (int i = 1; i < missionInfo.length; i++) {
            String[] item = missionInfo[i].split(";");
            missionIdAndName.append(item[0]).append(" ").append(item[1]).append("\n");
        }
        System.out.println(missionIdAndName);
        //
        boolean missionExist = false;
        System.out.println("Please input the ID of the mission you want to select shuttle for");
        int missionId = UserInterface.readUserIntInput();
        for (int i = 0; i < missionInfo.length; i++) {
            String[] missionDetail = missionInfo[i].split(";");
            if (Integer.toString(missionId).equals(missionDetail[0])) {
                missionExist = true;
            }
        }
        if (missionExist) {
            ArrayList<Shuttle> shuttleList = new ArrayList<Shuttle>();
            String[] shuttleInfo = readFile("SpaceShuttle.txt").split("\\n");
            for (int i = 0; i < shuttleInfo.length; i++) {
                String[] shuttleDetails = shuttleInfo[i].split(";");
                Shuttle tempShuttle = new Shuttle(Integer.parseInt(shuttleDetails[0]), shuttleDetails[1], shuttleDetails[2], Integer.parseInt(shuttleDetails[3]), Integer.parseInt(shuttleDetails[4]), Integer.parseInt(shuttleDetails[5]), Integer.parseInt(shuttleDetails[6]), shuttleDetails[7]);
                shuttleList.add(tempShuttle);
            }
            System.out.println("Here is the shuttle details, please enter your selection.");
            boolean display = true;
            while (display) {
                for (int a = 0; a < shuttleList.size(); a++) {
                    System.out.println(shuttleList.get(a).showIdAndName(a + 1));
                }
                int detailSelection = UserInterface.readUserIntInput();
                System.out.print('\u000C');
                shuttleList.get(detailSelection - 1).showDetails();
                System.out.println("Input 1 to select this shuttle, input 2 to go back to selection interface.");
                int d = UserInterface.readUserIntInput();
                if (d == 1) {
                    int selection = detailSelection;
                    Shuttle selectedShuttle = shuttleList.get(selection - 1);
                    System.out.println("Shuttle selected. You can check the MissionShuttle file about this record.");
                    String missionShuttle = missionId + ";" + selectedShuttle.getShuttleID()+"\n";
                    writeFile("MissionShuttle.txt",missionShuttle);
                    display = false;
                }
            }
        }
        else System.out.println("The mission you selected does not exist.");
    }

    /**
     * Method to read the data file
     *
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

    /**
     * Method to create candidate profile
     */
    public void createCandidateProfile()
    {
        System.out.println("Please entering your information.");
        System.out.println("1. Name: ");
        String name = UserInterface.readUserStringInput();
        System.out.println("Your name is: " + name);
        System.out.println("2. Date of birth: ");
        String birthDay = UserInterface.readUserStringInput();
        System.out.println("Your birthday is: " + birthDay);
        System.out.println("3. Address: ");
        String address = UserInterface.readUserStringInput();
        System.out.println("Your address is: " + address);
        System.out.println("4. Nationality: ");
        String nationality = UserInterface.readUserStringInput();
        System.out.println("Your nationality is: " + nationality);
        System.out.println("5. Identification number: ");
        int id = UserInterface.readUserIntInput();
        System.out.println("Your ID is: " + id);
        String identification = Integer.toString(id);
        System.out.println("6. Gender: ");
        String gender = UserInterface.readUserStringInput();
        System.out.println("Your gender is: " + gender);
        System.out.println("7. Allergies: ");
        String allergies = UserInterface.readUserStringInput();
        System.out.println("Your allergies are: " + allergies);
        System.out.println("8. Food preferences: ");
        String foodPre = UserInterface.readUserStringInput();
        System.out.println("Your food preferences are: " + foodPre);
        System.out.println("9. Qualification(s): ");
        String qualification = UserInterface.readUserStringInput();
        System.out.println("Your qualification(s) is/are: " + qualification);
        System.out.println("10. Work experience: ");
        String workExp = UserInterface.readUserStringInput();
        System.out.println("Your work experience is: " + workExp);
        System.out.println("11. Occupation(s): ");
        String occupation = UserInterface.readUserStringInput();
        System.out.println("Your occupation(s) is/are: " + occupation);
        System.out.println("12. Computer skills: ");
        String comSki = UserInterface.readUserStringInput();
        System.out.println("Your computer skills are: " + comSki);
        System.out.println("13. Language(s) spoken: ");
        String languageSpo = UserInterface.readUserStringInput();
        System.out.println("Your language(s) spoken is/are: " + languageSpo);
        String canInfo = user.getUserID() + ";" + name + ";" + birthDay + ";" + address + ";" + nationality + ";"
                + identification + ";" + gender + ";" + allergies + ";" + foodPre + ";"
                + qualification + ";" + workExp + ";" + occupation + ";" + comSki + ";"
                + languageSpo;
        int input = 0;
        do {
            System.out.println("Do you want to submit your information? ");
            System.out.println("1. Yes.   2. No. ");
            input = UserInterface.readUserIntInput();
            if (input == 1) {
                writeFile("CandidateInfo.txt", canInfo);
                System.out.println("Successfully submitted. ");
            } else if (input == 2)
                System.out.println("The information is not submitted. ");
            else
                System.out.println("Please enter the valid value.");
        } while (input != 1 && input != 2);
    }

    /**
     * Method to edit candidate profile
     */
    public void editCandidateProfile()
    {
        ArrayList<Candidate> canList = new ArrayList<Candidate>();
        String[] candidateInfo = readFile("CandidateInfo.txt").split("\\n");
        String[] canDetails = new String[16];
        for (int index = 0; index < candidateInfo.length; index++) {
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
            if (user.getUserID().equals(canList.get(index).getUserID())) {
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
            option = UserInterface.readUserIntInput();
            if (option == 0)
                break;
            else {
                System.out.println("Please enter your new information: ");
                String info = UserInterface.readUserStringInput();
                System.out.println("Do you want to save it?");
                System.out.println("1. Yes.   2. No. ");
                int save = UserInterface.readUserIntInput();
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
        int input =0;
        do {
            System.out.println("Do you want to submit your information? ");
            System.out.println("1. Yes.   2. No. ");
            input = UserInterface.readUserIntInput();
            if (input == 1) {
               writeFile("CandidateInfo.txt", canNewInfo);
                System.out.println("Successfully submitted. ");
            } else if (input == 2)
                System.out.println("The information is not submitted. ");
            else
                System.out.println("Please enter the valid value.");
        } while (input != 1 && input != 2);
    }

    /**
     * Method to view the list of candidates
     */
    public void viewBestCandidates() {
        Criteria criteria1 = new Criteria(15,"MIT",3,"general practitioner",true,true,"advanced","english");
        Criteria criteria2 = new Criteria(20,"BE",6,"manufacturer",true,true,"expert","english");
        Criteria criteria3 = new Criteria(25,"MBS",4,"surgeon",true,true,"advanced","english");
        ArrayList<Candidate> list = new ArrayList<>();
        String[] info = readFile("CandidateInfo.txt").split("\\n");
        String[] canDetails = new String[16];
        int j = 0;
        System.out.println("There are totally 3 criteria which respectively require different group of candidates.");
        System.out.println("These three criteria are respectively requiring MIT, BE, MBS guys");
        System.out.println("Please enter 1 to 3");
        System.out.println("1 is to view MIT guys list");
        System.out.println("2 is to view BE guys list");
        System.out.println("3 is to view MBS guys list");
        j = UserInterface.readUserIntInput();
        if (j == 1) {
            for (int i = 0; i < info.length; i++) {
                canDetails = info[i].split(";");
                String str = info[8];
                Candidate temp = new Candidate(canDetails[1], canDetails[2], canDetails[3], canDetails[4],
                        Integer.parseInt(canDetails[5]), canDetails[6], canDetails[7], canDetails[8], canDetails[9],
                        canDetails[10], canDetails[11], canDetails[12], canDetails[13], Boolean.valueOf(canDetails[14]),
                        Boolean.valueOf(canDetails[15]));
                if (temp.getQualification().equals(criteria1.getQualifications())) {
                    list.add(temp);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.print("Candidate's name: " + list.get(i).getCanName());
                System.out.print(", birthday: " + list.get(i).getBirthday());
                System.out.print(", address: " + list.get(i).getAddress());
                System.out.print(", nationality: " + list.get(i).getNationality());
                System.out.print(", identificationNumb: " + list.get(i).getIdentificationNumb());
                System.out.print(", gender: " + list.get(i).getGender());
                System.out.print(", allergies: " + list.get(i).getAllergies());
                System.out.print(", foodPreference: " + list.get(i).getFoodPreference());
                System.out.print(", qualification: " + list.get(i).getQualification());
                System.out.print(", workExperience: " + list.get(i).getWorkExperience());
                System.out.print(", occupation: " + list.get(i).getOccupation());
                System.out.print(", computerSkill: " + list.get(i).getComputerSkill());
                System.out.print(", language spoken: " + list.get(i).getLanguage());
                System.out.println("                               ");
            }
            System.out.println("Do you want to add these candidates to mission? 1 for yes, 2 for no.");
            int confirm = 0;
            confirm = UserInterface.readUserIntInput();
            if (confirm == 1) {
                System.out.println("Please enter the Mission ID which you want to add these candidates to");
                String[] missionInfo = readFile("MissionInfo.txt").split("\\n");
                StringBuffer missionIdAndName = new StringBuffer();
                for (int i = 1; i < missionInfo.length; i++) {
                    String[] item = missionInfo[i].split(";");
                    missionIdAndName.append(item[0]).append(" ").append(item[1]).append("\n");
                }
                System.out.println(missionIdAndName);
                int a = UserInterface.readUserIntInput();
                if (a == 7004 || a == 7003 || a == 7005) {
                    System.out.println("Congratulations, the candidates are successfully added to Mission");
                } else {
                    System.out.println("Sorry, there are no existing Mission that you entered");
                }
            }
        }
        if (j == 2) {
            for (int i = 0; i < info.length; i++) {
                canDetails = info[i].split(";");
                String str = info[8];
                Candidate temp = new Candidate(canDetails[1], canDetails[2], canDetails[3], canDetails[4],
                        Integer.parseInt(canDetails[5]), canDetails[6], canDetails[7], canDetails[8], canDetails[9],
                        canDetails[10], canDetails[11], canDetails[12], canDetails[13], Boolean.valueOf(canDetails[14]),
                        Boolean.valueOf(canDetails[15]));
                if (temp.getQualification().equals(criteria2.getQualifications())) {
                    list.add(temp);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.print("Candidate's name: " + list.get(i).getCanName());
                System.out.print(", birthday: " + list.get(i).getBirthday());
                System.out.print(", address: " + list.get(i).getAddress());
                System.out.print(", nationality: " + list.get(i).getNationality());
                System.out.print(", identificationNumb: " + list.get(i).getIdentificationNumb());
                System.out.print(", gender: " + list.get(i).getGender());
                System.out.print(", allergies: " + list.get(i).getAllergies());
                System.out.print(", foodPreference: " + list.get(i).getFoodPreference());
                System.out.print(", qualification: " + list.get(i).getQualification());
                System.out.print(", workExperience: " + list.get(i).getWorkExperience());
                System.out.print(", occupation: " + list.get(i).getOccupation());
                System.out.print(", computerSkill: " + list.get(i).getComputerSkill());
                System.out.print(", language spoken: " + list.get(i).getLanguage());
                System.out.println("                               ");
            }
            System.out.println("Do you want to add these candidates to mission? 1 for yes, 2 for no.");
            int confirm = 0;
            confirm = UserInterface.readUserIntInput();
            if (confirm == 1) {
                System.out.println("Please enter the Mission ID which you want to add these candidates to");
                String[] missionInfo = readFile("MissionInfo.txt").split("\\n");
                StringBuffer missionIdAndName = new StringBuffer();
                for (int i = 1; i < missionInfo.length; i++) {
                    String[] item = missionInfo[i].split(";");
                    missionIdAndName.append(item[0]).append(" ").append(item[1]).append("\n");
                }
                System.out.println(missionIdAndName);
                int a = UserInterface.readUserIntInput();
                if (a == 7004 || a == 7003 || a == 7005) {
                    System.out.println("Congratulations, the candidates are successfully added to Mission");
                } else {
                    System.out.println("Sorry, there are no existing Mission that you entered");
                }
            }
        }
        if (j == 3) {
            for (int i = 0; i < info.length; i++) {
                canDetails = info[i].split(";");
                String str = info[8];
                Candidate temp = new Candidate(canDetails[1], canDetails[2], canDetails[3], canDetails[4],
                        Integer.parseInt(canDetails[5]), canDetails[6], canDetails[7], canDetails[8], canDetails[9],
                        canDetails[10], canDetails[11], canDetails[12], canDetails[13], Boolean.valueOf(canDetails[14]),
                        Boolean.valueOf(canDetails[15]));
                if (temp.getQualification().equals(criteria3.getQualifications())) {
                    list.add(temp);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.print("Candidate's name: " + list.get(i).getCanName());
                System.out.print(", birthday: " + list.get(i).getBirthday());
                System.out.print(", address: " + list.get(i).getAddress());
                System.out.print(", nationality: " + list.get(i).getNationality());
                System.out.print(", identificationNumb: " + list.get(i).getIdentificationNumb());
                System.out.print(", gender: " + list.get(i).getGender());
                System.out.print(", allergies: " + list.get(i).getAllergies());
                System.out.print(", foodPreference: " + list.get(i).getFoodPreference());
                System.out.print(", qualification: " + list.get(i).getQualification());
                System.out.print(", workExperience: " + list.get(i).getWorkExperience());
                System.out.print(", occupation: " + list.get(i).getOccupation());
                System.out.print(", computerSkill: " + list.get(i).getComputerSkill());
                System.out.print(", language spoken: " + list.get(i).getLanguage());
                System.out.println("                               ");
            }
            System.out.println("Do you want to add these candidates to mission? 1 for yes, 2 for no.");
            int confirm = 0;
            confirm = UserInterface.readUserIntInput();
            if (confirm == 1) {
                System.out.println("Please enter the Mission ID which you want to add these candidates to");
                String[] missionInfo = readFile("MissionInfo.txt").split("\\n");
                StringBuffer missionIdAndName = new StringBuffer();
                for (int i = 1; i < missionInfo.length; i++) {
                    String[] item = missionInfo[i].split(";");
                    missionIdAndName.append(item[0]).append(" ").append(item[1]).append("\n");
                }
                System.out.println(missionIdAndName);
                int a = UserInterface.readUserIntInput();
                if (a == 7004 || a == 7003 || a == 7005) {
                    System.out.println("Congratulations, the candidates are successfully added to Mission");
                } else {
                    System.out.println("Sorry, there are no existing Mission that you entered");
                }
            }
        }


    }

    /**
     * Method to write to the file
     *
     * @param fileName
     * @param input
     */
    public void writeFile(String fileName, String input) {
        if (fileName.trim().length() != 0 && input.trim().length() != 0) {
            try {
                FileWriter fileWriter = new FileWriter(fileName, true);
                PrintWriter pr = new PrintWriter(fileWriter);
                pr.write(input);
                pr.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName + "not found");
            } catch (IOException e) {
                System.out.println("An unexpectedI/O error has just occured.");
            }
        }
    }

    /**
     * Method to write to the file
     *
     * @param fileName
     * @param input
     */
    public void overwriteFile(String fileName, String input) {
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

    public static Users getUser() {
        return user;
    }

    public static void setUser(Users user) {
        MissionToMarsSystem.user = user;
    }


}
