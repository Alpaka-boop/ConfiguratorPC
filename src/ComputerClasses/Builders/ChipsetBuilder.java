package ComputerClasses.Builders;

import ComputerClasses.MemoryFreq;
import ComputerClasses.Chipset;

public class ChipsetBuilder {
    private MemoryFreq memoryFreq;
    private String supportedXMPType;

    public ChipsetBuilder() {}

    public ChipsetBuilder(Chipset chipset) {
        this.memoryFreq = chipset.memoryFreq();
        this.supportedXMPType = chipset.supportedXMPType();
    }

    public ChipsetBuilder setMemoryFreq(MemoryFreq memoryFreq) {
        this.memoryFreq = memoryFreq;
        return this;
    }

    public ChipsetBuilder setSupportedXMPType(String supportedXMPType) {
        this.supportedXMPType = supportedXMPType;
        return this;
    }

    public Chipset build() {
        return new Chipset(memoryFreq, supportedXMPType);
    }
}
