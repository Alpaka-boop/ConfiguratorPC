package ComputerClasses;

public class VideoCard extends ComputerPart {
    private final String model;
    private final Size size;
    private final int memSize;
    private final String PCIEVersion;
    private final int chipFreq;
    private final int powerConsumption;

    public VideoCard(String model, Size size, int memSize, String PCIEVersion, int chipFreq, int powerConsumption) {
        this.model = model;
        this.size = size;
        this.memSize = memSize;
        this.PCIEVersion = PCIEVersion;
        this.chipFreq = chipFreq;
        this.powerConsumption = powerConsumption;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public String getModel() {
        return model;
    }

    public Size getSize() {
        return size;
    }

    public int getMemSize() {
        return memSize;
    }

    public String getPCIEVersion() {
        return PCIEVersion;
    }

    public int getChipFreq() {
        return chipFreq;
    }
}
