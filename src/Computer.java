import java.util.Objects;

public class Computer {
    public Motherboard motherboard;
    public Processor processor;
    public Bios bios;
    public CoolingSystem coolingSystem;
    public RAM ram;
    public XMLProfile xmlProfile;
    public VideoCard videoCard;
    public SSD ssd;
    public HDD hdd;
    public ComputerCase computerCase;
    public PowerUnit powerUnit;
    public WiFiAdaptor wifiAdaptor;

    public Computer(Motherboard motherboard, Processor processor, Bios bios, CoolingSystem coolingSystem
                , RAM ram, XMLProfile xmlProfile, VideoCard videoCard, SSD ssd, HDD hdd, ComputerCase computerCase
                , PowerUnit powerUnit, WiFiAdaptor wifiAdaptor) {
        this.motherboard = motherboard;
        this.processor = processor;
        this.bios = bios;
        this.coolingSystem = coolingSystem;
        this.ram = ram;
        this.xmlProfile = xmlProfile;
        this.videoCard = videoCard;
        this.ssd = ssd;
        this.hdd = hdd;
        this.computerCase = computerCase;
        this.powerUnit = powerUnit;
        this.wifiAdaptor = wifiAdaptor;
    }

    boolean Validate() {
        Motherboard.Validate(this);
    }

    public Socket getSocket() {
        return processor.getSocket();
    }
}
