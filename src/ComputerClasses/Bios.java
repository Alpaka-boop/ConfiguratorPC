package ComputerClasses;

import java.util.ArrayList;

public class Bios extends ComputerPart implements Validator {
    private final String type;
    private final String version;
    private final ArrayList<String> supportedProcModels = new ArrayList<>();

    public Bios(String type, String version, ArrayList<String> procModels) {
        this.type = type;
        this.version = version;
        this.supportedProcModels.addAll(procModels);
    }

    public void Validate(Computer computer) throws InvalidComponentsException {
        ValidateProc(computer.getProcessor());
        MotherboardAndProcCompatibilityChecker(computer.getProcessor(), computer.getMotherboard());
    }

    public String getType() {
        return type;
    }

    public String getVersion() {
        return version;
    }

    private void MotherboardAndProcCompatibilityChecker(Processor processor, Motherboard motherboard)
            throws InvalidComponentsException {
        if (!motherboard.getAvailableProcModels().contains(processor.getModel())) {
            throw new InvalidComponentsException("The motherboard and processor are inappropriate."
                    + " The motherboard are not able to response this processor");
        }
    }

    private void ValidateProc(Processor processor) throws InvalidComponentsException {
        if (!supportedProcModels.contains(processor.getModel())) {
            throw new InvalidComponentsException("The bios and processor are inappropriate."
                    + " The bios are not able to response this processor\n");
        }
    }
}
