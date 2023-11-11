package ComputerClasses;

public class ComputerCase extends ComputerComponent implements Validator {
    private final Size maxVideoCardSize;
    private final FormFactor formFactor;

    public ComputerCase(FormFactor formFactor, Size maxVideoCardSize) {
        super("ComputerCase");
        this.formFactor = formFactor;
        this.maxVideoCardSize = maxVideoCardSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerCase that = (ComputerCase) o;
        return formFactor.equals(that.formFactor);
    }

    @Override
    public void setComputerComponent(Computer computer, ComputerComponent component) {
        computer.setComputerCase((ComputerCase) component);
    }

    @Override
    public ComputerComponent getComponent(Computer computer) {
        return computer.getComputerCase();
    }
    
    @Override
    public void clearComputerComponent(Computer computer) {
        computer.setComputerCase(null);
    }

    public void Validate(Computer computer) throws InvalidComputerComponentsException {
        ValidateSize(computer.getMotherboard(), computer.getCoolingSystem());
    }

    public FormFactor getFormFactor() {
        return formFactor;
    }

    public Size getMaxVideoCardSize() {
        return maxVideoCardSize;
    }

    private void ValidateSize(Motherboard motherboard, CoolingSystem coolingSystem) throws InvalidComputerComponentsException {
        int a = motherboard.getFormFactor().getMinMeasure() + coolingSystem.getSize().getMinMeasure();
        int b = Math.max(motherboard.getFormFactor().getMaxMeasure(), coolingSystem.getSize().getMaxMeasure());
        int c = Math.max(motherboard.getFormFactor().getSecondMaxMeasure(), coolingSystem.getSize().getSecondMaxMeasure());

        if (a >= formFactor.getMaxMeasure() || Math.max(b, c) >= formFactor.getSecondMaxMeasure() || Math.min(b, c) >= formFactor.getMinMeasure()) {
            throw new InvalidComputerComponentsException("Case, motherboard and cooling system are unsuitable."
                                                + " Case size is wrong\n");
        }
    }
}
