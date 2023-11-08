import java.util.Objects;

public class Processor {
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

    public boolean ValidateMotherboard(final Motherboard motherboard) {
        return Objects.equals(motherboard.getSocket(), socket)
                && Objects.equals(memoryFreq, motherboard.getMemoryFreq());
    }


}
