package ComputerClasses.Builders;

import ComputerClasses.XMP;

import java.util.ArrayList;

public class XMPBuilder {
    private String type;
    private ArrayList<Integer> timings = new ArrayList<>();
    private int voltage;
    private int frequency;

    public XMPBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public XMPBuilder setTimings(ArrayList<Integer> timings) {
        this.timings.addAll(timings);
        return this;
    }

    public XMPBuilder setVoltage(int voltage) {
        this.voltage = voltage;
        return this;
    }

    public XMPBuilder setFrequency(int frequency) {
        this.frequency = frequency;
        return this;
    }

    public XMP build() {
        return new XMP(type, voltage, frequency, timings);
    }
}
