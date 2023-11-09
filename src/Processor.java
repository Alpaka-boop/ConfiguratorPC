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

    public void Validate(final Computer computer) throws InvalidComponentsException {
        ValidateMotherboard(computer.getMotherboard());
        ValidateXMP(computer.getRam());
        if (!isIntegratedGraphCore) {
            ValidateVideoCard(computer.getVideoCard());
        }
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

    private void ValidateMotherboard(final Motherboard motherboard) throws InvalidComponentsException {
        if (!Objects.equals(motherboard.getSocket(), socket)) {
            throw new InvalidComponentsException("Motherboard and processor are inappropriate." +
                    " The sockets are different\n");
        }
        if (!Objects.equals(memoryFreq, motherboard.getMemoryFreq())) {
               throw new InvalidComponentsException("Motherboard and processor are inappropriate." +
                       " The frequencies are different\n");
        }
    }

    private void ValidateXMP(RAM ram) {
        if (ram.getXmp().getFrequency() > memoryFreq.getMaxMemFreq()) {
            throw new InvalidComponentsException("Ram and processor are inappropriate." +
                    " Memory frequency is more than maximum processor memory frequency\n");
        }
    }

    private void ValidateVideoCard(VideoCard videoCard) throws InvalidComponentsException {
        if (videoCard == null) {
            throw new InvalidComponentsException("No video card or integrated graphics core\n");
        }
    }
}
