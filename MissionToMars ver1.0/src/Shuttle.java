/**
 * Class of shuttles in the Mission to Mars System
 */

public class Shuttle {
    private int shuttleID;
    private String shuttleName;
    private int manuYear;
    private int fuelCap;
    private int passengerCap;
    private int cargoCap;
    private int travelSpeed;

    public Shuttle() {
    }

    public Shuttle(int shuttleID, String shuttleName, int manuYear, int fuelCap, int passengerCap, int cargoCap, int travelSpeed) {
        this.shuttleID = shuttleID;
        this.shuttleName = shuttleName;
        this.manuYear = manuYear;
        this.fuelCap = fuelCap;
        this.passengerCap = passengerCap;
        this.cargoCap = cargoCap;
        this.travelSpeed = travelSpeed;
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

    public int getManuYear() {
        return manuYear;
    }

    public void setManuYear(int manuYear) {
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
}
