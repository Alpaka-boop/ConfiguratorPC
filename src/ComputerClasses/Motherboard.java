package ComputerClasses;

import java.util.ArrayList;
import java.util.Objects;

public class Motherboard extends ComputerComponent implements Validator {
    private final String model;
    private final Socket procSocket;
    private final int PCIELinesNum;
    private final int SATAPortsNum;
    private final Chipset chipset;
    private final boolean supportedDERStandard;
    private final int RAMTablesNum;
    private final FormFactor formFactor;
    private Bios bios;
    private final boolean isIntegratedWifiAdaptor;
    private final ArrayList<String> availableProcModels = new ArrayList<>();

    public Motherboard(Socket procSocket, int PCIELinesNum, int SATAPortsNum, Chipset chipset
            , boolean supportedDERStandard, int RAMTablesNum, FormFactor formFactor, Bios bios, String model, boolean isIntegratedWifiAdaptor) {
        super("Motherboard");
        this.procSocket = procSocket;
        this.PCIELinesNum = PCIELinesNum;
        this.SATAPortsNum = SATAPortsNum;
        this.chipset = chipset;
        this.supportedDERStandard = supportedDERStandard;
        this.RAMTablesNum = RAMTablesNum;
        this.formFactor = formFactor;
        this.bios = bios;
        this.model = model;
        this.isIntegratedWifiAdaptor = isIntegratedWifiAdaptor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motherboard motherboard = (Motherboard) o;
        return model.equals(motherboard.model);
    }

    @Override
    public void setComputerComponent(Computer computer, ComputerComponent component) {
        computer.setMotherboard((Motherboard) component);
    }

    @Override
    public ComputerComponent getComponent(Computer computer) {
        return computer.getMotherboard();
    }
    
    @Override
    public void clearComputerComponent(Computer computer) {
        computer.setMotherboard(null);
    }

    public Socket getSocket() {
        return procSocket;
    }

    public String getModel() {return model;}

    public MemoryFreq getMemoryFreq() {
        return chipset.getMemoryFreq();
    }

    public void Validate(Computer computer) throws InvalidComputerComponentsException {
        if (!Objects.equals(procSocket, computer.getProcessor().getSocket())) {
            throw new InvalidComputerComponentsException("The processor and the motherboard are inappropriate."
                    + " The sockets are different\n");
        }
        ValidateRAM(computer.getRAM(), computer.getProcessor());
        ValidateXMP(computer.getRAM());
        bios.Validate(computer);
    }

    public ArrayList<String> getAvailableProcModels() {
        return availableProcModels;
    }

    public FormFactor getFormFactor() {
        return formFactor;
    }

    public boolean isIntegratedWifiAdaptor() {
        return isIntegratedWifiAdaptor;
    }

    public Bios getBios() {
        return bios;
    }

    public void setBios(Bios bios) {
        this.bios = bios;
    }

    public int getPCIELinesNum() {
        return PCIELinesNum;
    }

    public int getSATAPortsNum() {
        return SATAPortsNum;
    }

    public boolean isSupportedDERStandard() {
        return supportedDERStandard;
    }

    public int getRAMTablesNum() {
        return RAMTablesNum;
    }

    private void ValidateRAM(RAM ram, Processor processor) throws InvalidComputerComponentsException {
        ArrayList<Integer> ramFreq = ram.getJEDECFrequencies();
        ArrayList<Integer> ramVolt = ram.getJEDECVoltage();
        for (int i = 0; i < ramFreq.size(); i++) {
            if (ramFreq.get(i) > processor.getFrequency()) {
                ram.setCurrentOperatingFrequency(ramFreq.get(i));
                ram.setCurrentOperatingVoltage(ramVolt.get(i));
                return;
            }
        }
        throw new InvalidComputerComponentsException("ComputerClasses.RAM and processor are inappropriate."
                                            + "The ComputerClasses.RAM are not able to support processor frequency\n");
    }

    private void ValidateXMP(RAM ram) throws InvalidComputerComponentsException {
        if (ram.getXmpType() != chipset.getSupportedXMPType()) {
           throw new InvalidComputerComponentsException("Ram and motherboard are inappropriate."
                                            + " ComputerClasses.RAM and motherboard chipset are different ComputerClasses.XMP types\n");
        }
    }
}
