public class SSD {
    public enum ConnectionType {
        PCI_E,
        SATA
    }

    private final ConnectionType connectionType;
    private final int capacity;
    private final int maxWorkingSpeed;
    private final int powerConsumption;

    public SSD(ConnectionType connectionType, int capacity, int maxWorkingSpeed, int powerConsumption) {
        this.connectionType = connectionType;
        this.capacity = capacity;
        this.maxWorkingSpeed = maxWorkingSpeed;
        this.powerConsumption = powerConsumption;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }
}
