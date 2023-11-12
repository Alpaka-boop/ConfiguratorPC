package ComputerClasses;

public class MemoryFreq {
    private final double minMemFreq;
    private final double maxMemFreq;

    public MemoryFreq(double minMemFreq, double maxMemFreq) {
        this.minMemFreq = minMemFreq;
        this.maxMemFreq = maxMemFreq;
    }

    public MemoryFreq (double memFreq) {
        this.minMemFreq = memFreq;
        this.maxMemFreq = memFreq;
    }

    public double getMinMemFreq() {
        return minMemFreq;
    }

    public double getMaxMemFreq() {
        return maxMemFreq;
    }
}
