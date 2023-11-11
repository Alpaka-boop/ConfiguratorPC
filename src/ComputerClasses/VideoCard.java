package ComputerClasses;

public class VideoCard extends ComputerComponent {
    private final String model;
    private final Size size;
    private final int memSize;
    private final String PCIEVersion;
    private final int chipFreq;
    private final int powerConsumption;

    public VideoCard(String model, Size size, int memSize, String PCIEVersion, int chipFreq, int powerConsumption) {
        super("VideoCard");
        this.model = model;
        this.size = size;
        this.memSize = memSize;
        this.PCIEVersion = PCIEVersion;
        this.chipFreq = chipFreq;
        this.powerConsumption = powerConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoCard that = (VideoCard) o;
        return model.equals(that.model);
    }

    @Override
    public void setComputerComponent(Computer computer, ComputerComponent component) {
        computer.setVideoCard((VideoCard) component);
    }

    @Override
    public ComputerComponent getComponent(Computer computer) {
        return computer.getVideoCard();
    }
    
    @Override
    public void clearComputerComponent(Computer computer) {
        computer.setVideoCard(null);
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
