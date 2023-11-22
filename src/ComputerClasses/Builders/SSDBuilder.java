package ComputerClasses.Builders;

import ComputerClasses.SSD;

public class SSDBuilder {
    private String model;
    private String connectionType;
    private int capacity;
    private int maxWorkingSpeed;
    private int powerConsumption;

    public SSDBuilder() {}

    public SSDBuilder(SSD ssd) {
        this.model = ssd.getModel();
        this.connectionType = ssd.getConnectionType();
        this.capacity = ssd.getCapacity();
        this.maxWorkingSpeed = ssd.getMaxWorkingSpeed();
        this.powerConsumption = ssd.getPowerConsumption();
    }

    public SSDBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public SSDBuilder setConnectionType(String connectionType) {
        this.connectionType = connectionType;
        return this;
    }

    public SSDBuilder setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public SSDBuilder setMaxWorkingSpeed(int maxWorkingSpeed) {
        this.maxWorkingSpeed = maxWorkingSpeed;
        return this;
    }

    public SSDBuilder setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    public SSD build() {
        return new SSD(model, connectionType, capacity, maxWorkingSpeed, powerConsumption);
    }
}
