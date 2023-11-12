package ComputerClasses.Builders;

import ComputerClasses.XMP;

import java.util.ArrayList;

public class XMPBuilder {
    private String type;
    private final ArrayList<Double> timings = new ArrayList<>();
    private double voltage;
    private double frequency;

    public XMPBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public XMPBuilder setTimings(ArrayList<Double> timings) {
        this.timings.addAll(timings);
        return this;
    }

    public XMPBuilder setVoltage(int voltage) {
        this.voltage = voltage;
        return this;
    }

    public XMPBuilder setFrequency(double frequency) {
        this.frequency = frequency;
        return this;
    }

    public XMP build() {
        return new XMP(type, voltage, frequency, timings);
    }
}
