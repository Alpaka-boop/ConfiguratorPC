import java.util.Objects;

public class Motherboard implements Validator {
    private Socket procSocket;
    private int PCIELinesNum;
    private int SATAPortsNum;
    Chipset chipset;
    private boolean isDDRSupported;
    private int RAMTablesNum;
    // form factor
    private Bios bios;

    public Socket getSocket() {
        return procSocket;
    }

    public MemoryFreq getMemoryFreq() {
        return chipset.getMemoryFreq();
    }

    public boolean Validate(Computer computer) {
        return Objects.equals(procSocket, computer.getSocket());
    }
}
