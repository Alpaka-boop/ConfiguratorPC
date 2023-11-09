public class HDD {
    private final int storageSize;
    private final int spindleRotationSpeed;
    private final int powerConsumption;

    public HDD(int storageSize, int spindleRotationSpeed, int powerConsumption) {
        this.storageSize = storageSize;
        this.spindleRotationSpeed = spindleRotationSpeed;
        this.powerConsumption = powerConsumption;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }
}
