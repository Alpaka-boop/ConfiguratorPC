package Configurator;

import ComputerClasses.*;
import ComputerClasses.Builders.*;
import StoreHouse.StoreHouse;

import java.util.ArrayList;

public class Configurator {
    private Computer computer;
    private final StoreHouse storeHouse;

    public Configurator(StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
        this.computer = makeBasicComputer();
    }

    public Configurator(Computer computer, StoreHouse storeHouse) {
        this.computer = computer;
        this.storeHouse = storeHouse;
    }

    public boolean ValidateComputer(Computer computer) throws InvalidComputerComponentsException
                                                            , UnsavePCComputerComponentsException {
        try {
            computer.Validate();
        } catch (InvalidComputerComponentsException cause) {
            dumpAnAnnouncement("Invalid components!\n" + cause.getMessage());
            return false;
        } catch (UnsavePCComputerComponentsException cause) {
            dumpAnAnnouncement("Unsave assembly!\n" + cause.getMessage());
        }
        return true;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void setComponent(ComputerComponent component) {
        ComputerComponent storeComputerComponent = StoreHouse.getComputerComponent(component);
        if (storeComputerComponent == null) {
            dumpAnAnnouncement("No such component in storehouse");
            return;
        }
        component.setComputerComponent(computer, storeComputerComponent);
        if (!ValidateComputer(computer)) {
            storeHouse.putComputerComponent(storeComputerComponent);
            component.setComputerComponent(computer, null);
        }
    }

    public ComputerComponent changeComputerComponent(ComputerComponent component) {
        ComputerComponent unsavedComputerComponent = StoreHouse.findSuitableComputerComponent(computer, component);
        if (unsavedComputerComponent == null) {
            dumpAnAnnouncement("No such component in storehouse");
            return null;
        }
        return unsavedComputerComponent;
    }

    public ComputerComponent setComponent(String name) throws RuntimeException {
        ComputerComponent unsafeComponent = StoreHouse.findSuitableComputerComponent(computer, name);
        if (unsafeComponent == null) {
            dumpAnAnnouncement("No such component in storehouse");
            return null;
        }
        return unsafeComponent;
    }

    private void dumpAnAnnouncement(String message) {
        System.out.println(message);
    }

    private Computer makeBasicComputer() {
        ComputerBuilder builder = new ComputerBuilder()
                .setProcessor(makeBasicProcessor())
                .setMotherboard(makeBasicMotherboard())
                .setCoolingSystem(makeBasicCoolingSystem())
                .setRam(makeBasicRAM())
                .setXMP(makeBasicXMP())
                .setHdd(makeBasicHDD())
                .setComputerCase(makeBasicComputerCase())
                .setPowerUnit(makeBasicPowerUnit());
        return builder.build();
    }

    private Processor makeBasicProcessor() {
        ProcessorBuilder builder = new ProcessorBuilder()
                .setModel("Intel")
                .setCoreNum(4)
                .setTDP(65)
                .setCoreFrequency(2.5)
                .setSocket(new Socket("AM4"))
                .setPowerConsumption(65)
                .setIsIntegratedGraphCore(true)
                .setMemoryFreq(new MemoryFreq(2.5, 3.5));
        return builder.build();
    }

    private Motherboard makeBasicMotherboard() {
        MotherboardBuilder builder = new MotherboardBuilder()
                .setModel("MSI")
                .setProcSocket(new Socket("AM4"))
                .setPCIELinesNum(16)
                .setSATAPortsNum(4)
                .setChipset(new Chipset(new MemoryFreq(2.5, 3.5), "Intel"))
                .setSupportedDERStandard(true)
                .setRAMTablesNum(4)
                .setFormFactor(new FormFactor(new Size(2, 2, 2)))
                .setBios(new Bios("Bios", "1.0", new ArrayList<>()))
                .setIsIntegratedWifiAdaptor(true)
                .setAvailableProcModels(new ArrayList<>());
        return builder.build();
    }

    private CoolingSystem makeBasicCoolingSystem() {
        CoolingSystemBuilder coolingSystemBuilder = new CoolingSystemBuilder()
                .setModel("Cooling")
                .setMaxTDP(65)
                .setSize(new Size(2, 2, 2))
                .setSocketsList(new ArrayList<>());
        return coolingSystemBuilder.build();
    }

    private RAM makeBasicRAM() {
        ArrayList<Double> helperArray = new ArrayList<>();
        helperArray.add(2.5);
        RAMBuilder builder = new RAMBuilder()
                .setStorageSize(2)
                .setJEDECFrequencies(helperArray)
                .setJEDECVoltage(helperArray)
                .setXMP(makeBasicXMP())
                .setFormFactor(new FormFactor(new Size(2, 2, 2)))
                .setDDRVersion("2.5")
                .setPowerConsumption(65);
        return builder.build();
    }

    private XMP makeBasicXMP() {
        return new XMPBuilder()
                .setVoltage(5)
                .setFrequency(2.5)
                .setTimings(new ArrayList<>())
                .setType("XMP").build();
    }

    private HDD makeBasicHDD() {
        return new HDDBuilder()
                .setStorageSize(2)
                .setPowerConsumption(65)
                .setSpindleRotationSpeed(2500)
                .setModel("HDD")
                .build();
    }

    private ComputerCase makeBasicComputerCase() {
        return new ComputerCaseBuilder()
                .setFormFactor(new FormFactor(new Size(2, 2, 2)))
                .setMaxVideoCardSize(new Size(2, 2, 2))
                .build();
    }

    private PowerUnit makeBasicPowerUnit() {
        return new PowerUnit(5000);
    }
}
