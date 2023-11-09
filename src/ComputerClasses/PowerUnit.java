package ComputerClasses;

public class PowerUnit extends ComputerPart implements Validator {
    private final int peakLoad;

    public PowerUnit(int peakLoad) {
        super("PowerUnit");
        this.peakLoad = peakLoad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PowerUnit that = (PowerUnit) o;
        return peakLoad == that.peakLoad;
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
