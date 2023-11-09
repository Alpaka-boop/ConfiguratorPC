package ComputerClasses;

import java.util.ArrayList;

public class RAM extends ComputerPart {
    private final int storageSize;
    private final ArrayList<Integer> JEDECFrequencies;
    private final ArrayList<Integer> JEDECVoltage;
    private final XMP xmp;
    private final FormFactor formFactor;
    private final String ddrVersion;
    private final int powerConsumption;
    private int currentOperatingFrequency;
    private int currentOperatingVoltage;

    public RAM(int storageSize, ArrayList<Integer> JEDECFrequencies, ArrayList<Integer> JEDECVoltage
            , XMP xmp, FormFactor formFactor, String ddrVersion, int powerConsumption
            , int currentOperatingFrequency, int currentOperatingVoltage) {
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

    public ArrayList<Integer> getJEDECFrequencies() {
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

    public int getCurrentOperatingFrequency() {
        return currentOperatingFrequency;
    }

    public int getCurrentOperatingVoltage() {
        return currentOperatingVoltage;
    }

    public ArrayList<Integer> getJEDECVoltage() {
        return JEDECVoltage;
    }

    public void setCurrentOperatingFrequency(int currentOperatingFrequency) {
        this.currentOperatingFrequency = currentOperatingFrequency;
    }

    public void setCurrentOperatingVoltage(int currentOperatingVoltage) {
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

    public String getddrVersion() {
        return ddrVersion;
    }
}
