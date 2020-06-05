package Administrator;

/**
 * Class of the candidate selection criteria in the Mission to Mars System
 */

public class Criteria {
    private String ageRange;
    private String qualifications;
    private int workingYears;
    private String occupations;
    private boolean healthRecords;
    private boolean criminalRecords;
    private String computerSkills;
    private String languageSpoken;

    public Criteria() {
    }

    public Criteria(String ageRange, String qualifications, int workingYears, String occupations, boolean healthRecords, boolean criminalRecords, String computerSkills, String languageSpoken) {
        this.ageRange = ageRange;
        this.qualifications = qualifications;
        this.workingYears = workingYears;
        this.occupations = occupations;
        this.healthRecords = healthRecords;
        this.criminalRecords = criminalRecords;
        this.computerSkills = computerSkills;
        this.languageSpoken = languageSpoken;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public int getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(int workingYears) {
        this.workingYears = workingYears;
    }

    public String getOccupations() {
        return occupations;
    }

    public void setOccupations(String occupations) {
        this.occupations = occupations;
    }

    public boolean isHealthRecords() {
        return healthRecords;
    }

    public void setHealthRecords(boolean healthRecords) {
        this.healthRecords = healthRecords;
    }

    public boolean isCriminalRecords() {
        return criminalRecords;
    }

    public void setCriminalRecords(boolean criminalRecords) {
        this.criminalRecords = criminalRecords;
    }

    public String getComputerSkills() {
        return computerSkills;
    }

    public void setComputerSkills(String computerSkills) {
        this.computerSkills = computerSkills;
    }

    public String getLanguageSpoken() {
        return languageSpoken;
    }

    public void setLanguageSpoken(String languageSpoken) {
        this.languageSpoken = languageSpoken;
    }
}
