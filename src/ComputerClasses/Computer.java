package ComputerClasses;

public class Computer extends ComputerPart {
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

    public Computer(Motherboard motherboard, Processor processor, CoolingSystem coolingSystem
                , RAM ram, XMP xmp, VideoCard videoCard, SSD ssd, HDD hdd, ComputerCase computerCase
                , PowerUnit powerUnit, WiFiAdaptor wifiAdaptor) {
        this.motherboard = motherboard;
        this.processor = processor;
        this.coolingSystem = coolingSystem;
        this.ram = ram;
        this.xmp = xmp;
        this.videoCard = videoCard;
        this.ssd = ssd;
        this.hdd = hdd;
        this.computerCase = computerCase;
        this.powerUnit = powerUnit;
        this.wifiAdaptor = wifiAdaptor;
    }

    public void Validate() throws InvalidComponentsException, UnsavePCComponentsException {
        processor.Validate(this);
        SSDandHDDValidation();
        motherboard.Validate(this);
        computerCase.Validate(this);
        powerUnit.Validate(this);
        ValidateWifiAdaptor();
        CheckCoolingSystem();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return motherboard.equals(computer.motherboard) && processor.equals(computer.processor)
                && coolingSystem.equals(computer.coolingSystem)
                && ram.equals(computer.ram) && xmp.equals(computer.xmp)
                && videoCard.equals(computer.videoCard) && ssd.equals(computer.ssd)
                && hdd.equals(computer.hdd) && computerCase.equals(computer.computerCase)
                && powerUnit.equals(computer.powerUnit) && wifiAdaptor.equals(computer.wifiAdaptor);
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public Processor getProcessor() {
        return processor;
    }

    public CoolingSystem getCoolingSystem() {
        return coolingSystem;
    }

    public RAM getRAM() {
        return ram;
    }

    public XMP getXMP() {
        return xmp;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public SSD getSSD() {
        return ssd;
    }

    public HDD getHDD() {
        return hdd;
    }

    public ComputerCase getComputerCase() {
        return computerCase;
    }

    public PowerUnit getPowerUnit() {
        return powerUnit;
    }

    public WiFiAdaptor getWiFiAdaptor() {
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

    public void setCoolingSystem(CoolingSystem coolingSystem) {
        this.coolingSystem = coolingSystem;
    }

    public void setRAM(RAM ram) {
        this.ram = ram;
    }

    public void setXMP(XMP xmp) {
        this.xmp = xmp;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public void setSSD(SSD ssd) {
        this.ssd = ssd;
    }

    public void setHDD(HDD hdd) {
        this.hdd = hdd;
    }

    public void setComputerCase(ComputerCase computerCase) {
        this.computerCase = computerCase;
    }

    public void setPowerUnit(PowerUnit powerUnit) {
        this.powerUnit = powerUnit;
    }

    public void setWiFiAdaptor(WiFiAdaptor wifiAdaptor) {
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
                                                + " ComputerClasses.Motherboard has integrated wifi adaptor\n");
        }
    }
}
