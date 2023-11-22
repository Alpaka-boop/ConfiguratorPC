package ComputerClasses.Builders;

import ComputerClasses.*;

public class ComputerBuilder {
    private Motherboard motherboard;
    private Processor processor;
    private CoolingSystem coolingSystem;
    private RAM ram;
    private XMP xmp;
    private VideoCard videoCard;
    private SSD ssd;
    private HDD hdd;
    private ComputerCase computerCase;
    private PowerUnit powerUnit;
    private WiFiAdaptor wifiAdaptor;


    public ComputerBuilder() {}

    public ComputerBuilder(Computer computer) {
        this.motherboard = computer.getMotherboard();
        this.processor = computer.getProcessor();
        this.coolingSystem = computer.getCoolingSystem();
        this.ram = computer.getRAM();
        this.xmp = computer.getXMP();
        this.videoCard = computer.getVideoCard();
        this.ssd = computer.getSSD();
        this.hdd = computer.getHDD();
        this.computerCase = computer.getComputerCase();
        this.powerUnit = computer.getPowerUnit();
        this.wifiAdaptor = computer.getWiFiAdaptor();
    }

    public ComputerBuilder setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
        return this;
    }

    public ComputerBuilder setProcessor(Processor processor) {
        this.processor = processor;
        return this;
    }

    public ComputerBuilder setCoolingSystem(CoolingSystem coolingSystem) {
        this.coolingSystem = coolingSystem;
        return this;
    }

    public ComputerBuilder setRam(RAM ram) {
        this.ram = ram;
        return this;
    }

    public ComputerBuilder setXMP(XMP xmp) {
        this.xmp = xmp;
        return this;
    }

    public ComputerBuilder setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
        return this;
    }

    public ComputerBuilder setSsd(SSD ssd) {
        this.ssd = ssd;
        return this;
    }

    public ComputerBuilder setHdd(HDD hdd) {
        this.hdd = hdd;
        return this;
    }

    public ComputerBuilder setComputerCase(ComputerCase computerCase) {
        this.computerCase = computerCase;
        return this;
    }

    public ComputerBuilder setPowerUnit(PowerUnit powerUnit) {
        this.powerUnit = powerUnit;
        return this;
    }

    public ComputerBuilder setWifiAdaptor(WiFiAdaptor wifiAdaptor) {
        this.wifiAdaptor = wifiAdaptor;
        return this;
    }

    public void Clear() {
        motherboard = null;
        processor = null;
        coolingSystem = null;
        ram = null;
        xmp = null;
        videoCard = null;
        ssd = null;
        hdd = null;
        computerCase = null;
        powerUnit = null;
        wifiAdaptor = null;
    }

    public Computer build() {
        return new Computer(motherboard, processor, coolingSystem, ram, xmp
                        , videoCard, ssd, hdd, computerCase, powerUnit, wifiAdaptor);
    }
}
