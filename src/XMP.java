import java.util.ArrayList;

public class XMP {
    private int type;
    private final ArrayList<Integer> timings = new ArrayList<>();
    private int voltage;
    private int frequency;

    public XMP(int voltage, int frequency, ArrayList<Integer> timings) {
        this.voltage = voltage;
        this.frequency = frequency;
        this.timings.addAll(timings);
    }

    public int getType() {
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
