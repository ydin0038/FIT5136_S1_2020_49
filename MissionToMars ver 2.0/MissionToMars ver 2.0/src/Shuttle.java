/**
 * Class of shuttles in the Mission to Mars System
 */

public class Shuttle {
    private int shuttleID;
    private String shuttleName;
    private String manuYear;
    private int fuelCap;
    private int passengerCap;
    private int cargoCap;
    private int travelSpeed;
    private String nationality;

    public Shuttle() {
    }

    public Shuttle(int shuttleID, String shuttleName, String manuYear, int fuelCap, int passengerCap, int cargoCap, int travelSpeed,String nationality) {
        this.shuttleID = shuttleID;
        this.shuttleName = shuttleName;
        this.manuYear = manuYear;
        this.fuelCap = fuelCap;
        this.passengerCap = passengerCap;
        this.cargoCap = cargoCap;
        this.travelSpeed = travelSpeed;
        this.nationality = nationality;
    }

    public int getShuttleID() {
        return shuttleID;
    }

    public void setShuttleID(int shuttleID) {
        this.shuttleID = shuttleID;
    }

    public String getShuttleName() {
        return shuttleName;
    }

    public void setShuttleName(String shuttleName) {
        this.shuttleName = shuttleName;
    }

    public String getManuYear() {
        return manuYear;
    }

    public void setManuYear(String manuYear) {
        this.manuYear = manuYear;
    }

    public int getFuelCap() {
        return fuelCap;
    }

    public void setFuelCap(int fuelCap) {
        this.fuelCap = fuelCap;
    }

    public int getPassengerCap() {
        return passengerCap;
    }

    public void setPassengerCap(int passengerCap) {
        this.passengerCap = passengerCap;
    }

    public int getCargoCap() {
        return cargoCap;
    }

    public void setCargoCap(int cargoCap) {
        this.cargoCap = cargoCap;
    }

    public int getTravelSpeed() {
        return travelSpeed;
    }

    public void setTravelSpeed(int travelSpeed) {
        this.travelSpeed = travelSpeed;
    }

    public String getNationality(){
        return nationality;
    }

    public void setNationality(String nationality){
        this.nationality = nationality;
    }

    public String showIdAndName(int index){
        String presentation = new String();
        presentation = Integer.toString(index) + ". Id: " + Integer.toString(shuttleID) + " Name: " + shuttleName;
        return presentation;
    }

    public void showDetails(){
        System.out.println("Id: " + shuttleID);
        System.out.println("Name: " + shuttleName);
        System.out.println("ManuYear: " + manuYear);
        System.out.println("Fuel capability: "+ fuelCap);
        System.out.println("Passagener capability: "+ passengerCap );
        System.out.println("Cargo capability: "+ cargoCap);
        System.out.println("Travel speed: "+ travelSpeed);
        System.out.println("Nationality: "+ nationality);
    }

}

