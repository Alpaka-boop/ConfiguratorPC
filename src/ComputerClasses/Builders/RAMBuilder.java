package ComputerClasses.Builders;

import ComputerClasses.FormFactor;
import ComputerClasses.RAM;
import ComputerClasses.XMP;

import java.util.ArrayList;

public class RAMBuilder {
    private int storageSize;
    private final ArrayList<Integer> JEDECFrequencies = new ArrayList<>();
    private final ArrayList<Integer> JEDECVoltage = new ArrayList<>();
    private XMP xmp;
    private FormFactor formFactor;
    private String ddrVersion;
    private int powerConsumption;
    private int currentOperatingFrequency;
    private int currentOperatingVoltage;

    public RAMBuilder setStorageSize(int storageSize) {
        this.storageSize = storageSize;
        return this;
    }

    public RAMBuilder setJEDECFrequencies(ArrayList<Integer> JEDECFrequencies) {
        this.JEDECFrequencies.addAll(JEDECFrequencies);
        return this;
    }

    public RAMBuilder setJEDECVoltage(ArrayList<Integer> JEDECVoltage) {
        this.JEDECVoltage.addAll(JEDECVoltage);
        return this;
    }

    public RAMBuilder setXMP(XMP xmp) {
        this.xmp = xmp;
        return this;
    }

    public RAMBuilder setFormFactor(FormFactor formFactor) {
        this.formFactor = formFactor;
        return this;
    }

    public RAMBuilder setDDRVersion(String ddrVersion) {
        this.ddrVersion = ddrVersion;
        return this;
    }

    public RAMBuilder setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    public RAMBuilder setCurrentOperatingFrequency(int currentOperatingFrequency) {
        this.currentOperatingFrequency = currentOperatingFrequency;
        return this;
    }

    public RAMBuilder setCurrentOperatingVoltage(int currentOperatingVoltage) {
        this.currentOperatingVoltage = currentOperatingVoltage;
        return this;
    }

    public RAM build() {
        return new RAM(storageSize, JEDECFrequencies, JEDECVoltage, xmp, formFactor, ddrVersion
                        , powerConsumption, currentOperatingFrequency, currentOperatingVoltage);
    }
}
