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
        boolean is_valid = processor.Validate(this)
                && bios.Validate(this)
                && ValidateMemorySystem()
                && motherboard.Validate(this)
                && computerCase.Validate(this)
                && powerUnit.Validate(this)
                && ValidateWifiAdaptor();
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

    public int getPowerConsumption() {
        return processor.getPowerConsumption() + ram.getPowerConsumption()
            + videoCard.getPowerConsumption() + ssd.getPowerConsumption()
            + hdd.getPowerConsumption() + wifiAdaptor.getPowerConsumption();

    }

    private boolean CheckCoolingSystem() {
        return coolingSystem.getMaxTDP() > processor.getTDP();
    }

    private boolean ValidateMemorySystem() {
        return ssd != null || hdd != null;
    }

    private boolean ValidateWifiAdaptor() {
        return wifiAdaptor == null || !motherboard.isIntegratedWifiAdaptor();
    }
}
