package ComputerClasses;

public class Chipset {
    private final MemoryFreq memoryFreq;
    private final String supportedXMPType;

    public Chipset(MemoryFreq memoryFreq, String supportedXMPType) {
        this.memoryFreq = memoryFreq;
        this.supportedXMPType = supportedXMPType;
    }

    public MemoryFreq getMemoryFreq() {
        return memoryFreq;
    }

    public String getSupportedXMPType() {
        return supportedXMPType;
    }
}