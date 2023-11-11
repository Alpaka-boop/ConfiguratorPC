package ComputerClasses.Builders;

import ComputerClasses.Size;
import ComputerClasses.VideoCard;

public class VideoCardBuilder {
    private String model;
    private Size size;
    private int memSize;
    private String PCIEVersion;
    private int chipFreq;
    private int powerConsumption;

    public VideoCardBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public VideoCardBuilder setSize(Size size) {
        this.size = size;
        return this;
    }

    public VideoCardBuilder setMemSize(int memSize) {
        this.memSize = memSize;
        return this;
    }

    public VideoCardBuilder setPCIEVersion(String PCIEVersion) {
        this.PCIEVersion = PCIEVersion;
        return this;
    }

    public VideoCardBuilder setChipFreq(int chipFreq) {
        this.chipFreq = chipFreq;
        return this;
    }

    public VideoCardBuilder setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    public VideoCard build() {
        return new VideoCard(model, size, memSize, PCIEVersion, chipFreq, powerConsumption);
    }
}
