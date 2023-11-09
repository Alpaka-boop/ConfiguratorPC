package ComputerClasses;

public class MemoryFreq {
    private final int minMemFreq;
    private final int maxMemFreq;

    public MemoryFreq(int minMemFreq, int maxMemFreq) {
        this.minMemFreq = minMemFreq;
        this.maxMemFreq = maxMemFreq;
    }

    public MemoryFreq (int memFreq) {
        this.minMemFreq = memFreq;
        this.maxMemFreq = memFreq;
    }

    public int getMinMemFreq() {
        return minMemFreq;
    }

    public int getMaxMemFreq() {
        return maxMemFreq;
    }
}
