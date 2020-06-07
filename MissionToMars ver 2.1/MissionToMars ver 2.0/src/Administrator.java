import java.util.ArrayList;

/**
 * Class of the user(Administrator) in the Mission to Mars System
 */

public class Administrator extends Users {
    private String adminName;
    private ArrayList<Integer> missionIDs;

    public Administrator() {
    }

    public Administrator(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public int getMissionID(int index){
        return missionIDs.get(index);
    }

    public void setMissionIDs(int index,int missionID){
        this.missionIDs.set(index,missionID);
    }
}
