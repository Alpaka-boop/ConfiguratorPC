public class ComputerBuilder {
    private Motherboard motherboard;
    private Processor processor;
    private Bios bios;
    private CoolingSystem coolingSystem;
    private RAM ram;
    private XMLProfile xmlProfile;
    private VideoCard videoCard;
    private SSD ssd;
    private HDD hdd;
    private ComputerCase computerCase;
    private PowerUnit powerUnit;
    private WiFiAdaptor wifiAdaptor;

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setBios(Bios bios) {
        this.bios = bios;
    }

    public void setCoolingSystem(CoolingSystem coolingSystem) {
        this.coolingSystem = coolingSystem;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public void setXmlProfile(XMLProfile xmlProfile) {
        this.xmlProfile = xmlProfile;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public void setSsd(SSD ssd) {
        this.ssd = ssd;
    }

    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    public void setComputerCase(ComputerCase computerCase) {
        this.computerCase = computerCase;
    }

    public void setPowerUnit(PowerUnit powerUnit) {
        this.powerUnit = powerUnit;
    }

    public void setWifiAdaptor(WiFiAdaptor wifiAdaptor) {
        this.wifiAdaptor = wifiAdaptor;
    }

    public Computer Build() {
        return new Computer(motherboard, processor, bios, coolingSystem, ram, xmlProfile
                        , videoCard, ssd, hdd, computerCase, powerUnit, wifiAdaptor);
    }
}
