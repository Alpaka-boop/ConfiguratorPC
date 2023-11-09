package ComputerClasses;

import java.util.ArrayList;
import java.util.Objects;

public class XMP extends ComputerPart {
    private final String type;
    private final ArrayList<Integer> timings = new ArrayList<>();
    private final int voltage;
    private final int frequency;

    public XMP(String type, int voltage, int frequency, ArrayList<Integer> timings) {
        super("XMP");
        this.voltage = voltage;
        this.frequency = frequency;
        this.timings.addAll(timings);
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XMP xmp = (XMP) o;
        return Objects.equals(type, xmp.type);
    }

    public String getType() {
        return type;
    }

    public int getVoltage() {
        return voltage;
    }

    public int getFrequency() {
        return frequency;
    }

    public ArrayList<Integer> getTimings() {
        return timings;
    }
}
