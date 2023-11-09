public class PowerUnit implements Validator {
    private final int peakLoad;

    public PowerUnit(int peakLoad) {
        this.peakLoad = peakLoad;
    }

    public boolean Validate(Computer computer) {
        return peakLoad > computer.getPowerConsumption();
    }
}
