package Administrator;

/**
 * Class of the employment requirement of the mission in the Mission to Mars System
 */

public class EmploymentRequirement {
    private String title;
    private int requiredNum;

    public EmploymentRequirement() {
    }

    public EmploymentRequirement(String title, int requiredNum) {
        this.title = title;
        this.requiredNum = requiredNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRequiredNum() {
        return requiredNum;
    }

    public void setRequiredNum(int requiredNum) {
        this.requiredNum = requiredNum;
    }
}
