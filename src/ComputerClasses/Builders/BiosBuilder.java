package ComputerClasses.Builders;

import java.util.ArrayList;
import ComputerClasses.Bios;

public class BiosBuilder {
    private String type;
    private String version;
    private final ArrayList<String> supportedProcModels = new ArrayList<>();

    public BiosBuilder() {}

    public BiosBuilder addType(String type) {
        this.type = type;
        return this;
    }

    public BiosBuilder addVersion(String version) {
        this.version = version;
        return this;
    }

    public BiosBuilder addSupportedProcModels(ArrayList<String> supportedProcModels) {
        this.supportedProcModels.addAll(supportedProcModels);
        return this;
    }

    public Bios build() {
        return new Bios(type, version, supportedProcModels);
    }
}
