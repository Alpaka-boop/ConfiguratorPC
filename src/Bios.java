import java.util.ArrayList;

public class Bios implements Validator {
    private BiosType type;
    private BiosVersion version;
    ArrayList<Integer> models = new ArrayList<>();

    public Bios(BiosType type, BiosVersion version, ArrayList<Integer> models) {
        this.type = type;
        this.version = version;
        this.models = models;
    }

    public void Validate(Computer computer) throws InvalidComponentsException {
        ValidateProc(computer.getProcessor());
        MotherboardAndProcCompatibilityChecker(computer.getProcessor(), computer.getMotherboard());
    }

    private void MotherboardAndProcCompatibilityChecker(Processor processor, Motherboard motherboard)
            throws InvalidComponentsException {
        if (!motherboard.getAvailableProcModels().contains(processor.getModel())) {
            throw new InvalidComponentsException("The motherboard and processor are inappropriate."
                    + " The motherboard are not able to response this processor");
        }
    }

    private void ValidateProc(Processor processor) throws InvalidComponentsException {
        if (!models.contains(processor.getModel())) {
            throw new InvalidComponentsException("The bios and processor are inappropriate."
                    + " The bios are not able to response this processor\n");
        }
    }
}
