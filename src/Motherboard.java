import java.util.ArrayList;
import java.util.Objects;

public class Motherboard implements Validator {
    private final Socket procSocket;
    private final int PCIELinesNum;
    private final int SATAPortsNum;
    private final Chipset chipset;
    private final boolean supportedDERStandard;
    private final int RAMTablesNum;
    private final FormFactor formFactor;
    private final Bios bios;
    private final boolean isIntegratedWifiAdaptor = false;
    private final ArrayList<Integer> availableProcModels = new ArrayList<>();

    public Motherboard(Socket procSocket, int PCIELinesNum, int SATAPortsNum, Chipset chipset
            , boolean supportedDERStandard, int RAMTablesNum, FormFactor formFactor, Bios bios) {
        this.procSocket = procSocket;
        this.PCIELinesNum = PCIELinesNum;
        this.SATAPortsNum = SATAPortsNum;
        this.chipset = chipset;
        this.supportedDERStandard = supportedDERStandard;
        this.RAMTablesNum = RAMTablesNum;
        this.formFactor = formFactor;
        this.bios = bios;
    }

    public Socket getSocket() {
        return procSocket;
    }

    public MemoryFreq getMemoryFreq() {
        return chipset.getMemoryFreq();
    }

    public boolean Validate(Computer computer) {
        return Objects.equals(procSocket, computer.getSocket())
            && ValidateRAM(computer.ram, computer.processor)
            && ValidateXMP(computer.ram);
    }

    public ArrayList<Integer> getAvailableProcModels() {
        return availableProcModels;
    }

    public FormFactor getFormFactor() {
        return formFactor;
    }

    public boolean isIntegratedWifiAdaptor() {
        return isIntegratedWifiAdaptor;
    }

    private boolean ValidateRAM(RAM ram, Processor processor) {
        ArrayList<Integer> ramFreq = ram.getJEDECFrequencies();
        ArrayList<Integer> ramVolt = ram.getJEDECVoltage();
        for (int i = 0; i < ramFreq.size(); i++) {
            if (ramFreq.get(i) > processor.getFrequency()) {
                ram.setCurrentOperatingFrequency(ramFreq.get(i));
                ram.setCurrentOperatingVoltage(ramVolt.get(i));
                return true;
            }
        }
        return false;
    }

    private boolean ValidateXMP(RAM ram) {
        return ram.getXmpType() == chipset.getSupportedXMPType();
    }
}
