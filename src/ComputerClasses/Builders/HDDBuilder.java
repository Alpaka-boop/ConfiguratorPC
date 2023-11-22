package ComputerClasses.Builders;

import ComputerClasses.HDD;

public class HDDBuilder {
    private String model;
    private int storageSize;
    private int spindleRotationSpeed;
    private int powerConsumption;

    public HDDBuilder() {}

    public HDDBuilder(HDD hdd) {
        this.model = hdd.getModel();
        this.storageSize = hdd.getStorageSize();
        this.spindleRotationSpeed = hdd.getSpindleRotationSpeed();
        this.powerConsumption = hdd.getPowerConsumption();
    }

    public HDDBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public HDDBuilder setStorageSize(int storageSize) {
        this.storageSize = storageSize;
        return this;
    }

    public HDDBuilder setSpindleRotationSpeed(int spindleRotationSpeed) {
        this.spindleRotationSpeed = spindleRotationSpeed;
        return this;
    }

    public HDDBuilder setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    public HDD build() {
        return new HDD(model, storageSize, spindleRotationSpeed, powerConsumption);
    }
}
