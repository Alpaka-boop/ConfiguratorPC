package ComputerClasses;

public class HDD extends ComputerComponent {
    private final String model;
    private final int storageSize;
    private final int spindleRotationSpeed;
    private final int powerConsumption;

    public HDD(String model, int storageSize, int spindleRotationSpeed, int powerConsumption) {
        super("HDD");
        this.storageSize = storageSize;
        this.spindleRotationSpeed = spindleRotationSpeed;
        this.powerConsumption = powerConsumption;
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HDD hdd = (HDD) o;
        return model.equals(hdd.model);
    }

    @Override
    public void setComputerComponent(Computer computer, ComputerComponent component) {
        computer.setHDD((HDD) component);
    }

    @Override
    public ComputerComponent getComponent(Computer computer) {
        return computer.getHDD();
    }
    
    @Override
    public void clearComputerComponent(Computer computer) {
        computer.setHDD(null);
    }
    

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public String getModel() {
        return model;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public int getSpindleRotationSpeed() {
        return spindleRotationSpeed;
    }
}
