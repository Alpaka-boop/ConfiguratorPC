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

    public void Validate(Computer computer) throws InvalidComponentsException {
        if (!Objects.equals(procSocket, computer.getProcessor().getSocket())) {
            throw new InvalidComponentsException("The processor and the motherboard are inappropriate."
                    + " The sockets are different\n");
        }
        ValidateRAM(computer.getRam(), computer.getProcessor());
        ValidateXMP(computer.getRam());
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

    private void ValidateRAM(RAM ram, Processor processor) throws InvalidComponentsException {
        ArrayList<Integer> ramFreq = ram.getJEDECFrequencies();
        ArrayList<Integer> ramVolt = ram.getJEDECVoltage();
        for (int i = 0; i < ramFreq.size(); i++) {
            if (ramFreq.get(i) > processor.getFrequency()) {
                ram.setCurrentOperatingFrequency(ramFreq.get(i));
                ram.setCurrentOperatingVoltage(ramVolt.get(i));
                return;
            }
        }
        throw new InvalidComponentsException("RAM and processor are inappropriate."
                                            + "The RAM are not able to support processor frequency\n");
    }

    private void ValidateXMP(RAM ram) throws InvalidComponentsException {
        if (ram.getXmpType() != chipset.getSupportedXMPType()) {
           throw new InvalidComponentsException("Ram and motherboard are inappropriate."
                                            + " RAM and motherboard chipset are different XMP types\n");
        }
    }
}
