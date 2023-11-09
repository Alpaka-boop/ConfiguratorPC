import java.util.Objects;

public class Processor implements Validator {
    private final int model;
    private final int coreFrequency;
    private final int coreNum;
    private final Socket socket;
    private final boolean isIntegratedGraphCore = false;
    private final MemoryFreq memoryFreq;
    private final int TDP;
    private final int powerConsumption;

    public Processor(int model, int coreFrequency, int coreNum, Socket socket
            , MemoryFreq memoryFreq, int TDP, int powerConsumption) {
        this.model = model;
        this.coreFrequency = coreFrequency;
        this.coreNum = coreNum;
        this.socket = socket;
        this.memoryFreq = memoryFreq;
        this.TDP = TDP;
        this.powerConsumption = powerConsumption;
    }

    public Socket getSocket() {
        return socket;
    }

    public boolean Validate(final Computer computer) {
        boolean isValid = ValidateMotherboard(computer.getMotherboard())
            && ValidateXMP(computer.ram);

        if (!isIntegratedGraphCore) {
            isValid &= ValidateVideoCard(computer.videoCard);
        }

        return isValid;
    }

    public int getModel() {
        return model;
    }

    public int getTDP() {
        return TDP;
    }

    public int getFrequency() {
        return coreFrequency;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    private boolean ValidateMotherboard(final Motherboard motherboard) {
        return Objects.equals(motherboard.getSocket(), socket)
            && Objects.equals(memoryFreq, motherboard.getMemoryFreq());
    }

    private boolean ValidateXMP(RAM ram) {
        if (ram.getXmp() == null) {
            return true;
        }
        return ram.getXmp().getFrequency() <= memoryFreq.getMaxMemFreq();
    }

    private boolean ValidateVideoCard(VideoCard videoCard) {
        return videoCard != null;
    }
}
