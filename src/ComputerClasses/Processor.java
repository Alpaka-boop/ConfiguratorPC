package ComputerClasses;
import java.util.Objects;

public class Processor extends ComputerComponent implements Validator {
    private final String model;
    private final double coreFrequency;
    private final int coreNum;
    private final Socket socket;
    private final boolean isIntegratedGraphCore;
    private final MemoryFreq memoryFreq;
    private final int TDP;
    private final int powerConsumption;

    public Processor(String model, double coreFrequency, int coreNum, Socket socket
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

    public void Validate(final Computer computer) throws InvalidComputerComponentsException {
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

    @Override
    public void setComputerComponent(Computer computer, ComputerComponent component) {
        computer.setProcessor((Processor) component);
    }

    @Override
    public ComputerComponent getComponent(Computer computer) {
        return computer.getProcessor();
    }
    
    @Override
    public void clearComputerComponent(Computer computer) {
        computer.setProcessor(null);
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

    public double getFrequency() {
        return coreFrequency;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    private void ValidateMotherboard(final Motherboard motherboard) throws InvalidComputerComponentsException {
        if (!Objects.equals(motherboard.getSocket(), socket)) {
            throw new InvalidComputerComponentsException("ComputerClasses.Motherboard and processor are inappropriate." +
                    " The sockets are different\n");
        }
        if (!Objects.equals(memoryFreq, motherboard.getMemoryFreq())) {
               throw new InvalidComputerComponentsException("ComputerClasses.Motherboard and processor are inappropriate." +
                       " The frequencies are different\n");
        }
    }

    private void ValidateXMP(RAM ram) {
        if (ram.getXmp().getFrequency() > memoryFreq.getMaxMemFreq()) {
            throw new InvalidComputerComponentsException("Ram and processor are inappropriate." +
                    " Memory frequency is more than maximum processor memory frequency\n");
        }
    }

    private void ValidateVideoCard(VideoCard videoCard) throws InvalidComputerComponentsException {
        if (videoCard == null) {
            throw new InvalidComputerComponentsException("No video card or integrated graphics core\n");
        }
    }
}
