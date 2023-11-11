package ComputerClasses;

public class PowerUnit extends ComputerComponent implements Validator {
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

    @Override
    public void setComputerComponent(Computer computer, ComputerComponent component) {
        computer.setPowerUnit((PowerUnit) component);
    }

    @Override
    public ComputerComponent getComponent(Computer computer) {
        return computer.getPowerUnit();
    }
    
    @Override
    public void clearComputerComponent(Computer computer) {
        computer.setPowerUnit(null);
    }

    public void Validate(Computer computer) throws InvalidComputerComponentsException {
        if (peakLoad < computer.getPowerConsumption()) {
            throw new InvalidComputerComponentsException("Power unit and computer are inappropriate. Power unit is too weak\n");
        }
    }

    public int getPeakLoad() {
        return peakLoad;
    }
}
