package Administrator;

/**
 * Class of the cargo used in each mission in the Mission to Mars System
 */

public class CargoRequirement {
    private String cargoUsage;
    private String cargoContent;
    private int cargoRequiredNum;

    public CargoRequirement() {
    }

    public CargoRequirement(String cargoUsage, String cargoContent, int cargoRequiredNum) {
        this.cargoUsage = cargoUsage;
        this.cargoContent = cargoContent;
        this.cargoRequiredNum = cargoRequiredNum;
    }

    public String getCargoUsage() {
        return cargoUsage;
    }

    public void setCargoUsage(String cargoUsage) {
        this.cargoUsage = cargoUsage;
    }

    public String getCargoContent() {
        return cargoContent;
    }

    public void setCargoContent(String cargoContent) {
        this.cargoContent = cargoContent;
    }

    public int getCargoRequiredNum() {
        return cargoRequiredNum;
    }

    public void setCargoRequiredNum(int cargoRequiredNum) {
        this.cargoRequiredNum = cargoRequiredNum;
    }
}

