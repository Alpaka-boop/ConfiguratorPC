package ComputerClasses;

import java.util.ArrayList;
import java.util.Objects;

public class RAM extends ComputerComponent {
    private final int storageSize;
    private final ArrayList<Double> JEDECFrequencies;
    private final ArrayList<Double> JEDECVoltage;
    private final XMP xmp;
    private final FormFactor formFactor;
    private final String ddrVersion;
    private final int powerConsumption;
    private double currentOperatingFrequency;
    private double currentOperatingVoltage;

    public RAM(int storageSize, ArrayList<Double> JEDECFrequencies, ArrayList<Double> JEDECVoltage
            , XMP xmp, FormFactor formFactor, String ddrVersion, int powerConsumption
            , int currentOperatingFrequency, int currentOperatingVoltage) {
        super("RAM");
        this.storageSize = storageSize;
        this.JEDECFrequencies = JEDECFrequencies;
        this.JEDECVoltage = JEDECVoltage;
        this.xmp = xmp;
        this.formFactor = formFactor;
        this.ddrVersion = ddrVersion;
        this.powerConsumption = powerConsumption;
        this.currentOperatingFrequency = currentOperatingFrequency;
        this.currentOperatingVoltage = currentOperatingVoltage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RAM ram = (RAM) o;
        return Objects.equals(ddrVersion, ram.ddrVersion);
    }

    @Override
    public void setComputerComponent(Computer computer, ComputerComponent component) {
        computer.setRAM((RAM) component);
    }

    @Override
    public ComputerComponent getComponent(Computer computer) {
        return computer.getRAM();
    }
    
    @Override
    public void clearComputerComponent(Computer computer) {
        computer.setRAM(null);
    }

    public ArrayList<Double> getJEDECFrequencies() {
        return JEDECFrequencies;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public FormFactor getFormFactor() {
        return formFactor;
    }

    public String getDdrVersion() {
        return ddrVersion;
    }

    public double getCurrentOperatingFrequency() {
        return currentOperatingFrequency;
    }

    public double getCurrentOperatingVoltage() {
        return currentOperatingVoltage;
    }

    public ArrayList<Double> getJEDECVoltage() {
        return JEDECVoltage;
    }

    public void setCurrentOperatingFrequency(Double currentOperatingFrequency) {
        this.currentOperatingFrequency = currentOperatingFrequency;
    }

    public void setCurrentOperatingVoltage(Double currentOperatingVoltage) {
        this.currentOperatingVoltage = currentOperatingVoltage;
    }

    public String getXmpType() {
        if (xmp == null) {
            return null;
        }
        return xmp.getType();
    }

    public XMP getXmp() {
        return xmp;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public String getDDRVersion() {
        return ddrVersion;
    }
}
