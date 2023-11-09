import java.util.ArrayList;

public class RAM {
    private enum DDRVersion {
        DDR1,
        DDR2,
        DDR3,
        DDR4
    };
    private int storageSize;
    private ArrayList<Integer> JEDECFrequencies;
    private ArrayList<Integer> JEDECVoltage;
    private XMP xmp;
//    form factor
    private DDRVersion ddrVersion;
    private int powerConsumption;
    private int currentOperatingFrequency;
    private int currentOperatingVoltage;

    public ArrayList<Integer> getJEDECFrequencies() {
        return JEDECFrequencies;
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

    public Integer getXmpType() {
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
}
