package ComputerClasses;
import java.util.Objects;

public class Processor extends ComputerPart implements Validator {
    private final String model;
    private final int coreFrequency;
    private final int coreNum;
    private final Socket socket;
    private final boolean isIntegratedGraphCore;
    private final MemoryFreq memoryFreq;
    private final int TDP;
    private final int powerConsumption;

    public Processor(String model, int coreFrequency, int coreNum, Socket socket
            , MemoryFreq memoryFreq, int TDP, int powerConsumption, boolean isIntegratedGraphCore) {
        super("Processor");
        this.model = model;
        this.coreFrequency = coreFrequency;
        this.coreNum = coreNum;
        this.socket = socket;
        this.memoryFreq = memoryFreq;
        this.TDP = TDP;
        this.powerConsumption = powerConsumption;
        this.isIntegratedGraphCore = isIntegratedGraphCore;
    }

    public Socket getSocket() {
        return socket;
    }

    public void Validate(final Computer computer) throws InvalidComponentsException {
        ValidateMotherboard(computer.getMotherboard());
        ValidateXMP(computer.getRAM());
        if (!isIntegratedGraphCore) {
            ValidateVideoCard(computer.getVideoCard());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Processor processor = (Processor) o;
        return Objects.equals(model, processor.model);
    }

    public String getModel() {
        return model;
    }

    public int getCoreNum() {
        return coreNum;
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
            throw new InvalidComponentsException("ComputerClasses.Motherboard and processor are inappropriate." +
                    " The sockets are different\n");
        }
        if (!Objects.equals(memoryFreq, motherboard.getMemoryFreq())) {
               throw new InvalidComponentsException("ComputerClasses.Motherboard and processor are inappropriate." +
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
