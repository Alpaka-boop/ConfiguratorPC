package ComputerClasses.Builders;

import ComputerClasses.MemoryFreq;
import ComputerClasses.Processor;
import ComputerClasses.Socket;

public class ProcessorBuilder {
    private String model;
    private double coreFrequency;
    private int coreNum;
    private Socket socket;
    private boolean isIntegratedGraphCore;
    private MemoryFreq memoryFreq;
    private int TDP;
    private int powerConsumption;

    public ProcessorBuilder() {}

    public ProcessorBuilder(Processor processor) {
        this.model = processor.getModel();
        this.coreFrequency = processor.getCoreFrequency();
        this.coreNum = processor.getCoreNum();
        this.socket = processor.getSocket();
        this.isIntegratedGraphCore = processor.isIntegratedGraphCore();
        this.memoryFreq = processor.getMemoryFreq();
        this.TDP = processor.getTDP();
        this.powerConsumption = processor.getPowerConsumption();
    }

    public ProcessorBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public ProcessorBuilder setCoreFrequency(double coreFrequency) {
        this.coreFrequency = coreFrequency;
        return this;
    }

    public ProcessorBuilder setCoreNum(int coreNum) {
        this.coreNum = coreNum;
        return this;
    }

    public ProcessorBuilder setSocket(Socket socket) {
        this.socket = socket;
        return this;
    }

    public ProcessorBuilder setIsIntegratedGraphCore(boolean isIntegratedGraphCore) {
        this.isIntegratedGraphCore = isIntegratedGraphCore;
        return this;
    }

    public ProcessorBuilder setMemoryFreq(MemoryFreq memoryFreq) {
        this.memoryFreq = memoryFreq;
        return this;
    }

    public ProcessorBuilder setTDP(int TDP) {
        this.TDP = TDP;
        return this;
    }

    public ProcessorBuilder setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    public Processor build() {
        return new Processor(model, coreFrequency, coreNum, socket
                        , memoryFreq, TDP, powerConsumption, isIntegratedGraphCore);
    }
}
