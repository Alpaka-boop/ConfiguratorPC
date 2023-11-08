import javax.lang.model.type.NullType;
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

    int Validate() {
        boolean is_valid = processor.Validate(this) && bios.Validate(this);
        if (is_valid) {
            boolean is_usage_safe = CheckCoolingSystem();
            if (is_usage_safe) {
                return 1;
            }
            return 0;
        }
        return -1;
    }

    public Socket getSocket() {
        return processor.getSocket();
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    private boolean CheckCoolingSystem() {
        return coolingSystem.getMax_TDP() > processor.getTDP();
    }
}
