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

    public boolean Validate(Computer computer) {
        return ValidateProc(computer.processor)
            && MotherboardAndProcCompatibilityChecker(computer.processor, computer.getMotherboard());
    }

    private boolean MotherboardAndProcCompatibilityChecker(Processor processor, Motherboard motherboard) {
        return motherboard.getAvailableProcModels().contains(processor.getModel());
    }

    private boolean ValidateProc(Processor processor) {
        return models.contains(processor.getModel());
    }
}
