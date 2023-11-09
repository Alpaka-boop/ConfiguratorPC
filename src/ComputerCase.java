public class ComputerCase implements Validator {
    private final Size maxVideoCardSize;
    private final FormFactor formFactor;

    public ComputerCase(FormFactor formFactor, Size maxVideoCardSize) {
        this.formFactor = formFactor;
        this.maxVideoCardSize = maxVideoCardSize;
    }

    public boolean Validate(Computer computer) {
        return ValidateSize(computer.motherboard, computer.coolingSystem);
    }

    private boolean ValidateSize(Motherboard motherboard, CoolingSystem coolingSystem) {
        if (motherboard.getFormFactor().getMaxMeasure() > formFactor.getMaxMeasure()) {
            return false;
        }
        if (coolingSystem.getSize().getMaxMeasure() > formFactor.getMaxMeasure()) {
            return false;
        }
        return coolingSystem.getSize().getMinMeasure() + motherboard.getFormFactor().getMinMeasure()
                < formFactor.getMaxMeasure();
    }
}
