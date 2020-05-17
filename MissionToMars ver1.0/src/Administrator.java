/**
 * Class of the user(Administrator) in the Mission to Mars System
 */

public class Administrator extends Users {
    private String adminName;

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
}
