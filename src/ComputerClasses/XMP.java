package ComputerClasses;

import java.util.ArrayList;
import java.util.Objects;

public class XMP extends ComputerComponent {
    private final String type;
    private final ArrayList<Double> timings = new ArrayList<>();
    private final double voltage;
    private final double frequency;

    public XMP(String type, double voltage, double frequency, ArrayList<Double> timings) {
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

    @Override
    public void setComputerComponent(Computer computer, ComputerComponent component) {
        computer.setXMP((XMP) component);
    }

    @Override
    public ComputerComponent getComponent(Computer computer) {
        return computer.getXMP();
    }
    
    @Override
    public void clearComputerComponent(Computer computer) {
        computer.setXMP(null);
    } 

    public String getType() {
        return type;
    }

    public double getVoltage() {
        return voltage;
    }

    public double getFrequency() {
        return frequency;
    }

    public ArrayList<Double> getTimings() {
        return timings;
    }
}
