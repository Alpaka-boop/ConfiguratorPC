public class ComputerCase implements Validator {
    private final Size maxVideoCardSize;
    private final FormFactor formFactor;

    public ComputerCase(FormFactor formFactor, Size maxVideoCardSize) {
        this.formFactor = formFactor;
        this.maxVideoCardSize = maxVideoCardSize;
    }

    public void Validate(Computer computer) throws InvalidComponentsException {
        ValidateSize(computer.getMotherboard(), computer.getCoolingSystem());
    }

    private void ValidateSize(Motherboard motherboard, CoolingSystem coolingSystem) throws InvalidComponentsException {
        int a = motherboard.getFormFactor().getMinMeasure() + coolingSystem.getSize().getMinMeasure();
        int b = Math.max(motherboard.getFormFactor().getMaxMeasure(), coolingSystem.getSize().getMaxMeasure());
        int c = Math.max(motherboard.getFormFactor().getSecondMaxMeasure(), coolingSystem.getSize().getSecondMaxMeasure());

        if (a >= formFactor.getMaxMeasure() || Math.max(b, c) >= formFactor.getSecondMaxMeasure() || Math.min(b, c) >= formFactor.getMinMeasure()) {
            throw new InvalidComponentsException("Case, motherboard and cooling system are unsuitable."
                                                + " Case size is wrong\n");
        }
    }
}
