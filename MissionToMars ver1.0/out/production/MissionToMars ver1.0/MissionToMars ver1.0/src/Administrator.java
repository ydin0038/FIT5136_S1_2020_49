/**
 * Class of the user(Administrator) in the Mission to Mars System
 */

public class Administrator extends Users {
    private int userID;
    private String adminName;

    public Administrator() {
    }

    public Administrator(String adminName) {
        this.adminName = adminName;
    }
    public int getUserID(){
        return userID;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
