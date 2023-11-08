import java.util.Objects;

public class Processor implements Validator {
    private int Model;
    private int CoreFrequency;
    private int CoreNum;
    private Socket socket;
    private boolean isIntegratedGraphCore;
    private MemoryFreq memoryFreq;
    private int TDP;
    private int powerConsumption;

    public Socket getSocket() {
        return socket;
    }

    public boolean Validate(final Computer computer) {
        return ValidateMotherboard(computer.getMotherboard());
    }

    public int getModel() {
        return Model;
    }

    public int getTDP() {
        return TDP;
    }

    private boolean ValidateMotherboard(final Motherboard motherboard) {
        return Objects.equals(motherboard.getSocket(), socket)
            && Objects.equals(memoryFreq, motherboard.getMemoryFreq());
    }
}
