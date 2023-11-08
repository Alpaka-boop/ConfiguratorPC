import java.util.ArrayList;

public class XMP {
    private final ArrayList<Integer> timings = new ArrayList<>();
    int voltage;
    int frequency;

    public XMP(int voltage, int frequency, ArrayList<Integer> timings) {
        this.voltage = voltage;
        this.frequency = frequency;
        timings.addAll(timings);
    }
}
