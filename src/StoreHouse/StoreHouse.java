package StoreHouse;
import ComputerClasses.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class StoreHouse {
    private static final HashMap<String, ArrayList<ComputerPart>> storage = new HashMap<>();

    public StoreHouse() {
        storage.put("Processor", new ArrayList<>());
        storage.put("Motherboard", new ArrayList<>());
        storage.put("Bios", new ArrayList<>());
        storage.put("RAM", new ArrayList<>());
        storage.put("CoolingSystem", new ArrayList<>());
        storage.put("XMP", new ArrayList<>());
        storage.put("SSD", new ArrayList<>());
        storage.put("VideoCard", new ArrayList<>());
        storage.put("ComputerCase", new ArrayList<>());
        storage.put("WiFiAdaptor", new ArrayList<>());
        storage.put("PowerUnit", new ArrayList<>());
        storage.put("HDD", new ArrayList<>());
        storage.put("Computer", new ArrayList<>());
    }

    public StoreHouse putProcessor(Processor processor) {
        storage.get("Processor").add(processor);
        return this;
    }
    
    public StoreHouse putMotherboard(Motherboard motherboard) {
        storage.get("Motherboard").add(motherboard);
        return this;
    }
    
    public StoreHouse putBios(Bios bios) {
        storage.get("Bios").add(bios);
        return this;
    }
    
    public StoreHouse putCoolingSystem(CoolingSystem coolingSystem) {
        storage.get("CoolingSystem").add(coolingSystem);
        return this;
    }
    
    public StoreHouse putXMP(XMP xmp) {
        storage.get("XMP").add(xmp);
        return this;
    }
    
    public StoreHouse putSSD(SSD ssd) {
        storage.get("SSD").add(ssd);
        return this;
    }
    
    public StoreHouse putHDD(HDD hdd) {
        storage.get("HDD").add(hdd);
        return this;
    }
    
    public StoreHouse putComputerCase(ComputerCase computerCase) {
        storage.get("ComputerCase").add(computerCase);
        return this;
    }
    
    public StoreHouse putPowerUnit(PowerUnit powerUnit) {
        storage.get("PowerUnit").add(powerUnit);
        return this;
    }
    
    public StoreHouse putWiFiAdaptor(WiFiAdaptor wifiAdaptor) {
        storage.get("WiFiAdaptor").add(wifiAdaptor);
        return this;
    }
    
    public StoreHouse putVideoCard(VideoCard videoCard) {
        storage.get("VideoCard").add(videoCard);
        return this;
    }
    
    public StoreHouse putRAM(RAM ram) {
        storage.get("RAM").add(ram);
        return this;
    }
    
    public StoreHouse putComputer(Computer computer) {
        storage.get("Computer").add(computer);
        return this;
    }

    public static Processor getProcessor(String model) {
        ArrayList<ComputerPart> itemList = storage.get("Processor");
        for (ComputerPart item: itemList) {
            if (Objects.equals(((Processor) item).getModel(), model)) {
                itemList.remove(item);
                return (Processor) item;
            }
        }
        return null;
    }

    public static Motherboard getMotherboard(String model) {
        ArrayList<ComputerPart> itemList = storage.get("Motherboard");
        for (ComputerPart item: itemList) {
            if (Objects.equals(((Motherboard) item).getModel(), model)) {
                itemList.remove(item);
                return (Motherboard) item;
            }
        }
        return null;
    }

    public static Bios getBios(String biosType, String biosVersion) {
        ArrayList<ComputerPart> itemList = storage.get("Bios");
        for (ComputerPart item: itemList) {
            if (Objects.equals(((Bios) item).getType(), biosType)
                    && Objects.equals(((Bios) item).getVersion(), biosVersion)) {
                itemList.remove(item);
                return (Bios) item;
            }
        }
        return null;
    }

    public static RAM getRAM(String ddrVersion) {
        ArrayList<ComputerPart> itemList = storage.get("RAM");
        for (ComputerPart item: itemList) {
            if (Objects.equals(((RAM) item).getddrVersion(), ddrVersion)) {
                itemList.remove(item);
                return (RAM) item;
            }
        }
        return null;
    }

    public static CoolingSystem getCoolingSystem(String model) {
        ArrayList<ComputerPart> itemList = storage.get("CoolingSystem");
        for (ComputerPart item: itemList) {
            if (Objects.equals(((CoolingSystem) item).getModel(), model)) {
                itemList.remove(item);
                return (CoolingSystem) item;
            }
        }
        return null;
    }

    public static XMP getXMP(int type) {
        ArrayList<ComputerPart> itemList = storage.get("XMP");
        for (ComputerPart item: itemList) {
            if (Objects.equals(((XMP) item).getType(), type)) {
                itemList.remove(item);
                return (XMP) item;
            }
        }
        return null;
    }

    public static VideoCard getVideoCard(String model) {
        ArrayList<ComputerPart> itemList = storage.get("VideoCard");
        for (ComputerPart item: itemList) {
            if (Objects.equals(((VideoCard) item).getModel(), model)) {
                itemList.remove(item);
                return (VideoCard) item;
            }
        }
        return null;
    }

    public static SSD getSSD(String model) {
        ArrayList<ComputerPart> itemList = storage.get("SSD");
        for (ComputerPart item: itemList) {
            if (Objects.equals(((SSD) item).getModel(), model)) {
                itemList.remove(item);
                return (SSD) item;
            }
        }
        return null;
    }

    public static HDD getHDD(String model) {
        ArrayList<ComputerPart> itemList = storage.get("HDD");
        for (ComputerPart item: itemList) {
            if (Objects.equals(((HDD) item).getModel(), model)) {
                itemList.remove(item);
                return (HDD) item;
            }
        }
        return null;
    }

    public static ComputerCase getComputerCase(FormFactor formFactor) {
        ArrayList<ComputerPart> itemList = storage.get("ComputerCase");
        for (ComputerPart item: itemList) {
            if (Objects.equals(((ComputerCase) item).getFormFactor(), formFactor)) {
                itemList.remove(item);
                return (ComputerCase) item;
            }
        }
        return null;
    }

    public static PowerUnit getPowerUnit(int peakLoad) {
        ArrayList<ComputerPart> itemList = storage.get("PowerUnit");
        for (ComputerPart item: itemList) {
            if (Objects.equals(((PowerUnit) item).getPeakLoad(), peakLoad)) {
                itemList.remove(item);
                return (PowerUnit) item;
            }
        }
        return null;
    }

    public static WiFiAdaptor getWiFiAdaptor(String model) {
        ArrayList<ComputerPart> itemList = storage.get("WiFiAdaptor");
        for (ComputerPart item: itemList) {
            if (Objects.equals(((WiFiAdaptor) item).getModel(), model)) {
                itemList.remove(item);
                return (WiFiAdaptor) item;
            }
        }
        return null;
    }

    public static Computer getComputer(Computer computer) {
        ArrayList<ComputerPart> itemList = storage.get("Computer");
        for (ComputerPart item: itemList) {
            if (Objects.equals(item, computer)) {
                itemList.remove(item);
                return (Computer) item;
            }
        }
        return null;
    }

    public static boolean findProcessor(Computer computer) throws UnsavePCComponentsException {
        ArrayList<ComputerPart> itemList = storage.get("Processor");
        String troubleMessage = "";
        Processor unsafeProcessor = null;
        for (ComputerPart item: itemList) {
            computer.setProcessor((Processor) item);
            try {
                computer.Validate();
            } catch (InvalidComponentsException e) {
                computer.setProcessor(null);
                continue;
            } catch (UnsavePCComponentsException e) {
                unsafeProcessor = (Processor) item;
                troubleMessage = e.getMessage();
                computer.setProcessor(null);
                continue;
            }
            computer.setProcessor((Processor) item);
            itemList.remove(item);
            return true;
        }

        if (unsafeProcessor != null) {
            computer.setProcessor(unsafeProcessor);
            itemList.remove(unsafeProcessor);
            throw new UnsavePCComponentsException(troubleMessage);
        }
        return false;
    }

    public static boolean findMotherboard(Computer computer) throws UnsavePCComponentsException {
        ArrayList<ComputerPart> itemList = storage.get("Motherboard");
        String troubleMessage = "";
        Motherboard unsafeMotherboard = null;
        for (ComputerPart item: itemList) {
            computer.setMotherboard((Motherboard) item);
            try {
                computer.Validate();
            } catch (InvalidComponentsException e) {
                computer.setMotherboard(null);
                continue;
            } catch (UnsavePCComponentsException e) {
                unsafeMotherboard = (Motherboard) item;
                troubleMessage = e.getMessage();
                computer.setMotherboard(null);
                continue;
            }
            computer.setMotherboard((Motherboard) item);
            itemList.remove(item);
            return true;
        }

        if (unsafeMotherboard != null) {
            computer.setMotherboard(unsafeMotherboard);
            itemList.remove(unsafeMotherboard);
            throw new UnsavePCComponentsException(troubleMessage);
        }
        return false;
    }

    public static boolean findCoolingSystem(Computer computer) throws UnsavePCComponentsException {
        ArrayList<ComputerPart> itemList = storage.get("CoolingSystem");
        String troubleMessage = "";
        CoolingSystem unsafeCoolingSystem = null;
        for (ComputerPart item : itemList) {
            computer.setCoolingSystem((CoolingSystem) item);
            try {
                computer.Validate();
            } catch (InvalidComponentsException e) {
                computer.setCoolingSystem(null);
                continue;
            } catch (UnsavePCComponentsException e) {
                unsafeCoolingSystem = (CoolingSystem) item;
                troubleMessage = e.getMessage();
                computer.setCoolingSystem(null);
                continue;
            }
            computer.setCoolingSystem((CoolingSystem) item);
            itemList.remove(item);
            return true;
        }

        if (unsafeCoolingSystem != null) {
            computer.setCoolingSystem(unsafeCoolingSystem);
            itemList.remove(unsafeCoolingSystem);
            throw new UnsavePCComponentsException(troubleMessage);
        }
        return false;
    }

    public static boolean findXMP(Computer computer) throws UnsavePCComponentsException {
        ArrayList<ComputerPart> itemList = storage.get("XMP");
        String troubleMessage = "";
        XMP unsafeXMP = null;
        for (ComputerPart item : itemList) {
            computer.setXMP((XMP) item);
            try {
                computer.Validate();
            } catch (InvalidComponentsException e) {
                computer.setXMP(null);
                continue;
            } catch (UnsavePCComponentsException e) {
                unsafeXMP = (XMP) item;
                troubleMessage = e.getMessage();
                computer.setXMP(null);
                continue;
            }
            computer.setXMP((XMP) item);
            itemList.remove(item);
            return true;
        }

        if (unsafeXMP != null) {
            computer.setXMP(unsafeXMP);
            itemList.remove(unsafeXMP);
            throw new UnsavePCComponentsException(troubleMessage);
        }
        return false;
    }

    public static boolean findVideoCard(Computer computer) throws UnsavePCComponentsException {
        ArrayList<ComputerPart> itemList = storage.get("VideoCard");
        String troubleMessage = "";
        VideoCard unsafeVideoCard = null;
        for (ComputerPart item : itemList) {
            computer.setVideoCard((VideoCard) item);
            try {
                computer.Validate();
            } catch (InvalidComponentsException e) {
                computer.setVideoCard(null);
                continue;
            } catch (UnsavePCComponentsException e) {
                unsafeVideoCard = (VideoCard) item;
                troubleMessage = e.getMessage();
                computer.setVideoCard(null);
                continue;
            }
            computer.setVideoCard((VideoCard) item);
            itemList.remove(item);
            return true;
        }

        if (unsafeVideoCard != null) {
            computer.setVideoCard(unsafeVideoCard);
            itemList.remove(unsafeVideoCard);
            throw new UnsavePCComponentsException(troubleMessage);
        }
        return false;
    }

    public static boolean findSSD(Computer computer) throws UnsavePCComponentsException {
        ArrayList<ComputerPart> itemList = storage.get("SSD");
        String troubleMessage = "";
        SSD unsafeSSD = null;
        for (ComputerPart item : itemList) {
            computer.setSSD((SSD) item);
            try {
                computer.Validate();
            } catch (InvalidComponentsException e) {
                computer.setSSD(null);
                continue;
            } catch (UnsavePCComponentsException e) {
                unsafeSSD = (SSD) item;
                troubleMessage = e.getMessage();
                computer.setSSD(null);
                continue;
            }
            computer.setSSD((SSD) item);
            itemList.remove(item);
            return true;
        }

        if (unsafeSSD != null) {
            computer.setSSD(unsafeSSD);
            itemList.remove(unsafeSSD);
            throw new UnsavePCComponentsException(troubleMessage);
        }
        return false;
    }

    public static boolean findHDD(Computer computer) throws UnsavePCComponentsException {
        ArrayList<ComputerPart> itemList = storage.get("HDD");
        String troubleMessage = "";
        HDD unsafeHDD = null;
        for (ComputerPart item : itemList) {
            computer.setHDD((HDD) item);
            try {
                computer.Validate();
            } catch (InvalidComponentsException e) {
                computer.setHDD(null);
                continue;
            } catch (UnsavePCComponentsException e) {
                unsafeHDD = (HDD) item;
                troubleMessage = e.getMessage();
                computer.setHDD(null);
                continue;
            }
            computer.setHDD((HDD) item);
            itemList.remove(item);
            return true;
        }

        if (unsafeHDD != null) {
            computer.setHDD(unsafeHDD);
            itemList.remove(unsafeHDD);
            throw new UnsavePCComponentsException(troubleMessage);
        }
        return false;
    }

    public static boolean findComputerCase(Computer computer) throws UnsavePCComponentsException {
        ArrayList<ComputerPart> itemList = storage.get("ComputerCase");
        String troubleMessage = "";
        ComputerCase unsafeComputerCase = null;
        for (ComputerPart item : itemList) {
            computer.setComputerCase((ComputerCase) item);
            try {
                computer.Validate();
            } catch (InvalidComponentsException e) {
                computer.setComputerCase(null);
                continue;
            } catch (UnsavePCComponentsException e) {
                unsafeComputerCase = (ComputerCase) item;
                troubleMessage = e.getMessage();
                computer.setComputerCase(null);
                continue;
            }
            computer.setComputerCase((ComputerCase) item);
            itemList.remove(item);
            return true;
        }

        if (unsafeComputerCase != null) {
            computer.setComputerCase(unsafeComputerCase);
            itemList.remove(unsafeComputerCase);
            throw new UnsavePCComponentsException(troubleMessage);
        }
        return false;
    }

    public static boolean findPowerUnit(Computer computer) throws UnsavePCComponentsException {
        ArrayList<ComputerPart> itemList = storage.get("PowerUnit");
        String troubleMessage = "";
        PowerUnit unsafePowerUnit = null;
        for (ComputerPart item : itemList) {
            computer.setPowerUnit((PowerUnit) item);
            try {
                computer.Validate();
            } catch (InvalidComponentsException e) {
                computer.setPowerUnit(null);
                continue;
            } catch (UnsavePCComponentsException e) {
                unsafePowerUnit = (PowerUnit) item;
                troubleMessage = e.getMessage();
                computer.setPowerUnit(null);
                continue;
            }
            computer.setPowerUnit((PowerUnit) item);
            itemList.remove(item);
            return true;
        }

        if (unsafePowerUnit != null) {
            computer.setPowerUnit(unsafePowerUnit);
            itemList.remove(unsafePowerUnit);
            throw new UnsavePCComponentsException(troubleMessage);
        }
        return false;
    }

    public static boolean findWiFiAdaptor(Computer computer) throws UnsavePCComponentsException {
        ArrayList<ComputerPart> itemList = storage.get("WiFiAdaptor");
        String troubleMessage = "";
        WiFiAdaptor unsafeWiFiAdaptor = null;
        for (ComputerPart item : itemList) {
            computer.setWiFiAdaptor((WiFiAdaptor) item);
            try {
                computer.Validate();
            } catch (InvalidComponentsException e) {
                computer.setWiFiAdaptor(null);
                continue;
            } catch (UnsavePCComponentsException e) {
                unsafeWiFiAdaptor = (WiFiAdaptor) item;
                troubleMessage = e.getMessage();
                computer.setWiFiAdaptor(null);
                continue;
            }
            computer.setWiFiAdaptor((WiFiAdaptor) item);
            itemList.remove(item);
            return true;
        }

        if (unsafeWiFiAdaptor != null) {
            computer.setWiFiAdaptor(unsafeWiFiAdaptor);
            itemList.remove(unsafeWiFiAdaptor);
            throw new UnsavePCComponentsException(troubleMessage);
        }
        return false;
    }

    public static boolean findRAM(Computer computer) throws UnsavePCComponentsException {
        ArrayList<ComputerPart> itemList = storage.get("RAM");
        String troubleMessage = "";
        RAM unsafeRAM = null;
        for (ComputerPart item : itemList) {
            computer.setRAM((RAM) item);
            try {
                computer.Validate();
            } catch (InvalidComponentsException e) {
                computer.setRAM(null);
                continue;
            } catch (UnsavePCComponentsException e) {
                unsafeRAM = (RAM) item;
                troubleMessage = e.getMessage();
                computer.setRAM(null);
                continue;
            }
            computer.setRAM((RAM) item);
            itemList.remove(item);
            return true;
        }

        if (unsafeRAM != null) {
            computer.setRAM(unsafeRAM);
            itemList.remove(unsafeRAM);
            throw new UnsavePCComponentsException(troubleMessage);
        }
        return false;
    }

    public static boolean findBios(Computer computer) throws UnsavePCComponentsException {
        ArrayList<ComputerPart> itemList = storage.get("Bios");
        String troubleMessage = "";
        Bios unsafeBios = null;
        for (ComputerPart item : itemList) {
            computer.getMotherboard().setBios((Bios) item);
            try {
                computer.Validate();
            } catch (InvalidComponentsException e) {
                computer.getMotherboard().setBios(null);
                continue;
            } catch (UnsavePCComponentsException e) {
                unsafeBios = (Bios) item;
                troubleMessage = e.getMessage();
                computer.getMotherboard().setBios(null);
                continue;
            }
            computer.getMotherboard().setBios((Bios) item);
            itemList.remove(item);
            return true;
        }

        if (unsafeBios != null) {
            computer.getMotherboard().setBios(unsafeBios);
            itemList.remove(unsafeBios);
            throw new UnsavePCComponentsException(troubleMessage);
        }
        return false;
    }
}
