package ComputerClasses;

public class PowerUnit extends ComputerPart implements Validator {
    private final int peakLoad;

    public PowerUnit(int peakLoad) {
        this.peakLoad = peakLoad;
    }

    public void Validate(Computer computer) throws InvalidComponentsException {
        if (peakLoad < computer.getPowerConsumption()) {
            throw new InvalidComponentsException("Power unit and computer are inappropriate. Power unit is too weak\n");
        }
    }

    public int getPeakLoad() {
        return peakLoad;
    }
}
