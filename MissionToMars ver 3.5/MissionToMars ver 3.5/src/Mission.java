import java.util.ArrayList;

/**
 * Class of the missions in the Mission to Mars System
 */

import java.util.ArrayList;

/**
 * Class of the missions in the Mission to Mars System
 */

public class Mission {
    private int missionId;
    private String missionName;
    private String missionDescription;
    private String countryOfOrigin;
    private String countriesAllowed;
    private int coordinatorId;
    private String cargoRequirement;
    private String jobs;
    private String launchDate;
    private String destination;
    private int duration;
    private String missionStatus;
    private String employmentRequirement;
    private Shuttle shuttle;
    public Mission() {
    }

    public Mission(int missionId, String missionName, String missionDescription, String countryOfOrigin, String countriesAllowed, int coordinatorId, String cargoRequirement, String jobs, String launchDate, String destination, int duration, String missionStatus, String employmentRequirement) {
        this.missionId = missionId;
        this.missionName = missionName;
        this.missionDescription = missionDescription;
        this.countryOfOrigin = countryOfOrigin;
        this.countriesAllowed = countriesAllowed;
        this.coordinatorId = coordinatorId;
        this.cargoRequirement = cargoRequirement;
        this.jobs = jobs;
        this.launchDate = launchDate;
        this.destination = destination;
        this.duration = duration;
        this.missionStatus = missionStatus;
        this.employmentRequirement = employmentRequirement;
    }

    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getMissionDescription() {
        return missionDescription;
    }

    public void setMissionDescription(String missionDescription) {
        this.missionDescription = missionDescription;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getCountriesAllowed() {
        return countriesAllowed;
    }

    public void setCountriesAllowed(String countriesAllowed) {
        this.countriesAllowed = countriesAllowed;
    }

    public int getCoordinatorId() {
        return coordinatorId;
    }

    public void setCoordinatorId(int coordinatorId) {
        this.coordinatorId = coordinatorId;
    }

    public String getCargoRequirement() {
        return cargoRequirement;
    }

    public void setCargoRequirement(String cargoRequirement) {
        this.cargoRequirement = cargoRequirement;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public String getEmploymentRequirement() {
        return employmentRequirement;
    }

    public void setEmploymentRequirement(String employmentRequirement) {
        this.employmentRequirement = employmentRequirement;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(String missionStatus) {
        this.missionStatus = missionStatus;
    }

    public Shuttle getShuttle() {
        return shuttle;
    }

    public void setShuttle(Shuttle shuttle) {
        this.shuttle = shuttle;
    }
}
