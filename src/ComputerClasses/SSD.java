package ComputerClasses;

public class SSD extends ComputerPart {
    private final String model;
    private final String connectionType;
    private final int capacity;
    private final int maxWorkingSpeed;
    private final int powerConsumption;

    public SSD(String model, String connectionType, int capacity, int maxWorkingSpeed, int powerConsumption) {
        this.model = model;
        this.connectionType = connectionType;
        this.capacity = capacity;
        this.maxWorkingSpeed = maxWorkingSpeed;
        this.powerConsumption = powerConsumption;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public String getModel() {
        return model;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMaxWorkingSpeed() {
        return maxWorkingSpeed;
    }
}
