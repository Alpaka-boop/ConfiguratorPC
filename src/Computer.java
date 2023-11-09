public class Computer {
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

    void Validate() throws InvalidComponentsException, UnsavePCComponentsException {
        processor.Validate(this);
        bios.Validate(this);
        SSDandHDDValidation();
        motherboard.Validate(this);
        computerCase.Validate(this);
        powerUnit.Validate(this);
        ValidateWifiAdaptor();
        CheckCoolingSystem();
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Bios getBios() {
        return bios;
    }

    public CoolingSystem getCoolingSystem() {
        return coolingSystem;
    }

    public RAM getRam() {
        return ram;
    }

    public XMLProfile getXmlProfile() {
        return xmlProfile;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public SSD getSsd() {
        return ssd;
    }

    public HDD getHdd() {
        return hdd;
    }

    public ComputerCase getComputerCase() {
        return computerCase;
    }

    public PowerUnit getPowerUnit() {
        return powerUnit;
    }

    public WiFiAdaptor getWifiAdaptor() {
        return wifiAdaptor;
    }

    public int getPowerConsumption() {
        return processor.getPowerConsumption() + ram.getPowerConsumption()
            + videoCard.getPowerConsumption() + ssd.getPowerConsumption()
            + hdd.getPowerConsumption() + wifiAdaptor.getPowerConsumption();

    }

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

    private void CheckCoolingSystem() throws UnsavePCComponentsException {
        if (coolingSystem.getMaxTDP() <= processor.getTDP()) {
            throw new UnsavePCComponentsException("Unsafe components assembly. Cooling system is too weak");
        }
    }

    private void SSDandHDDValidation() throws InvalidComponentsException {
        if (ssd == null && hdd == null) {
            throw new InvalidComponentsException("There is no ssd or hdd memory\n");
        }
    }

    private void ValidateWifiAdaptor() throws InvalidComponentsException {
        if (wifiAdaptor != null && motherboard.isIntegratedWifiAdaptor()) {
            throw new InvalidComponentsException("Wifi adaptor and motherboard are inappropriate."
                                                + " Motherboard has integrated wifi adaptor\n");
        }
    }
}
