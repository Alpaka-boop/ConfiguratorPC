package ComputerClasses;

import java.util.ArrayList;
import java.util.Objects;

public class Bios extends ComputerComponent implements Validator {
    private final String type;
    private final String version;
    private final ArrayList<String> supportedProcModels = new ArrayList<>();

    public Bios(String type, String version, ArrayList<String> procModels) {
        super("Bios");
        this.type = type;
        this.version = version;
        this.supportedProcModels.addAll(procModels);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bios bios = (Bios) o;
        return Objects.equals(type, bios.type) && Objects.equals(version, bios.version);
    }


    public void Validate(Computer computer) throws InvalidComputerComponentsException {
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
            throws InvalidComputerComponentsException {
        if (!motherboard.getAvailableProcModels().contains(processor.getModel())) {
            throw new InvalidComputerComponentsException("The motherboard and processor are inappropriate."
                    + " The motherboard are not able to response this processor");
        }
    }

    private void ValidateProc(Processor processor) throws InvalidComputerComponentsException {
        if (!supportedProcModels.contains(processor.getModel())) {
            throw new InvalidComputerComponentsException("The bios and processor are inappropriate."
                    + " The bios are not able to response this processor\n");
        }
    }
}
