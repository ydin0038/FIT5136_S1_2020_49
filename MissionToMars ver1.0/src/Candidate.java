/**
 * Class of the user (Candidate) in the Mission to Mars System
 */

public class Candidate extends Users {
    private String canName;
    private String birthday;
    private String address;
    private String nationality;
    private String identificationNumb;
    private String gender;
    private String allergies;
    private String foodPreference;
    private String qualification;
    private String workExperience;
    private String occupation;
    private String computerSkill;
    private String language;
    private boolean healthRecord;
    private boolean criminalRecord;

    public Candidate() {
    }

    public Candidate(String canName, String birthday, String address, String nationality, String identificationNumb, String gender, String allergies, String foodPreference, String qualification, String workExperience, String occupation, String computerSkill, String language, boolean healthRecord, boolean criminalRecord) {
        this.canName = canName;
        this.birthday = birthday;
        this.address = address;
        this.nationality = nationality;
        this.identificationNumb = identificationNumb;
        this.gender = gender;
        this.allergies = allergies;
        this.foodPreference = foodPreference;
        this.qualification = qualification;
        this.workExperience = workExperience;
        this.occupation = occupation;
        this.computerSkill = computerSkill;
        this.language = language;
        this.healthRecord = healthRecord;
        this.criminalRecord = criminalRecord;
    }

    public String getCanName() {
        return canName;
    }

    public void setCanName(String canName) {
        this.canName = canName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdentificationNumb() {
        return identificationNumb;
    }

    public void setIdentificationNumb(String identificationNumb) {
        this.identificationNumb = identificationNumb;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(String foodPreference) {
        this.foodPreference = foodPreference;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getComputerSkill() {
        return computerSkill;
    }

    public void setComputerSkill(String computerSkill) {
        this.computerSkill = computerSkill;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isHealthRecord() {
        return healthRecord;
    }

    public void setHealthRecord(boolean healthRecord) {
        this.healthRecord = healthRecord;
    }

    public boolean isCriminalRecord() {
        return criminalRecord;
    }

    public void setCriminalRecord(boolean criminalRecord) {
        this.criminalRecord = criminalRecord;
    }
}

