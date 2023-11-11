package ComputerClasses;

public class SSD extends ComputerComponent {
    private final String model;
    private final String connectionType;
    private final int capacity;
    private final int maxWorkingSpeed;
    private final int powerConsumption;

    public SSD(String model, String connectionType, int capacity, int maxWorkingSpeed, int powerConsumption) {
        super("SSD");
        this.model = model;
        this.connectionType = connectionType;
        this.capacity = capacity;
        this.maxWorkingSpeed = maxWorkingSpeed;
        this.powerConsumption = powerConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SSD ssd = (SSD) o;
        return model.equals(ssd.model);
    }

    @Override
    public void setComputerComponent(Computer computer, ComputerComponent component) {
        computer.setSSD((SSD) component);
    }

    @Override
    public ComputerComponent getComponent(Computer computer) {
        return computer.getSSD();
    }
    
    @Override
    public void clearComputerComponent(Computer computer) {
        computer.setSSD(null);
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
