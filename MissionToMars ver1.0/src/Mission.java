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
    private Coordinator coordinator;
    private ArrayList<CargoRequirement> cargoRequirement;
    private ArrayList<Job> jobs;
    private ArrayList<EmploymentRequirement> employmentRequirement;
    private String launchDate;
    private String destination;
    private int duration;
    private String missionStatus;
    private Shuttle shuttle;

    public Mission() {
    }

    public Mission(int missionId, String missionName, String missionDescription, String countryOfOrigin, String countriesAllowed, Coordinator coordinator, ArrayList<CargoRequirement> cargoRequirement, ArrayList<Job> jobs, ArrayList<EmploymentRequirement> employmentRequirement, String launchDate, String destination, int duration, String missionStatus, Shuttle shuttle) {
        this.missionId = missionId;
        this.missionName = missionName;
        this.missionDescription = missionDescription;
        this.countryOfOrigin = countryOfOrigin;
        this.countriesAllowed = countriesAllowed;
        this.coordinator = coordinator;
        this.cargoRequirement = cargoRequirement;
        this.jobs = jobs;
        this.employmentRequirement = employmentRequirement;
        this.launchDate = launchDate;
        this.destination = destination;
        this.duration = duration;
        this.missionStatus = missionStatus;
        this.shuttle = shuttle;
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

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public ArrayList<CargoRequirement> getCargoRequirement() {
        return cargoRequirement;
    }

    public void setCargoRequirement(ArrayList<CargoRequirement> cargoRequirement) {
        this.cargoRequirement = cargoRequirement;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    public ArrayList<EmploymentRequirement> getEmploymentRequirement() {
        return employmentRequirement;
    }

    public void setEmploymentRequirement(ArrayList<EmploymentRequirement> employmentRequirement) {
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
    public Shuttle getShuttle(){
        return shuttle;
    }
    public void setShuttle(Shuttle shuttle){
        this.shuttle = shuttle;
    }
}
