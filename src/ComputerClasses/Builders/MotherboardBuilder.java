package ComputerClasses.Builders;

import ComputerClasses.*;

import java.util.ArrayList;

public class MotherboardBuilder {
    private String model;
    private Socket procSocket;
    private int PCIELinesNum;
    private int SATAPortsNum;
    private Chipset chipset;
    private boolean supportedDERStandard;
    private int RAMTablesNum;
    private FormFactor formFactor;
    private Bios bios;
    private boolean isIntegratedWifiAdaptor;
    private final ArrayList<String> availableProcModels = new ArrayList<>();

    public MotherboardBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public MotherboardBuilder setProcSocket(Socket procSocket) {
        this.procSocket = procSocket;
        return this;
    }

    public MotherboardBuilder setPCIELinesNum(int PCIELinesNum) {
        this.PCIELinesNum = PCIELinesNum;
        return this;
    }

    public MotherboardBuilder setSATAPortsNum(int SATAPortsNum) {
        this.SATAPortsNum = SATAPortsNum;
        return this;
    }

    public MotherboardBuilder setChipset(Chipset chipset) {
        this.chipset = chipset;
        return this;
    }

    public MotherboardBuilder setSupportedDERStandard(boolean supportedDERStandard) {
        this.supportedDERStandard = supportedDERStandard;
        return this;
    }

    public MotherboardBuilder setRAMTablesNum(int RAMTablesNum) {
        this.RAMTablesNum = RAMTablesNum;
        return this;
    }

    public MotherboardBuilder setFormFactor(FormFactor formFactor) {
        this.formFactor = formFactor;
        return this;
    }

    public MotherboardBuilder setBios(Bios bios) {
        this.bios = bios;
        return this;
    }

    public MotherboardBuilder setIsIntegratedWifiAdaptor(boolean isIntegratedWifiAdaptor) {
        this.isIntegratedWifiAdaptor = isIntegratedWifiAdaptor;
        return this;
    }

    public MotherboardBuilder setAvailableProcModels(ArrayList<String> availableProcModels) {
        this.availableProcModels.addAll(availableProcModels);
        return this;
    }

    public Motherboard build() {
        return new Motherboard(procSocket, PCIELinesNum, SATAPortsNum, chipset, supportedDERStandard
                        , RAMTablesNum, formFactor, bios, model, isIntegratedWifiAdaptor, availableProcModels);
    }
}
