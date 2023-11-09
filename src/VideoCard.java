public class VideoCard {
    private final Size size;
    private final int memSize;
    private final PCIExpress PCIEVersion;
    private final int chipFreq;
    private final int powerConsumption;

    public VideoCard(Size size, int memSize, PCIExpress PCIEVersion, int chipFreq, int powerConsumption) {
        this.size = size;
        this.memSize = memSize;
        this.PCIEVersion = PCIEVersion;
        this.chipFreq = chipFreq;
        this.powerConsumption = powerConsumption;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }
}
