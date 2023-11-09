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
    }

    public StoreHouse putComputerPart(ComputerPart object) {
        storage.get(object.getClass().getSimpleName()).add(object);
        return this;
    }

    public static ComputerPart getComputerPart(ComputerPart computerPart) {
        ArrayList<ComputerPart> itemList = storage.get(computerPart.getName());
        for (ComputerPart item: itemList) {
            if (Objects.equals(item, computerPart)) {
                itemList.remove(item);
                return item;
            }
        }
        return null;
    }

    public static boolean findSuitableComputerPart(Computer computer, String name) throws UnsavePCComponentsException {
        ArrayList<ComputerPart> itemList = storage.get(name);
        String troubleMessage = "";
        ComputerPart unsafeComputerPart = null;
        for (ComputerPart item: itemList) {
            computer.setComputerPart(item);
            try {
                computer.Validate();
            } catch (InvalidComponentsException e) {
                computer.setComputerPart(null);
                continue;
            } catch (UnsavePCComponentsException e) {
                unsafeComputerPart = item;
                troubleMessage = e.getMessage();
                computer.setComputerPart(null);
                continue;
            }
            computer.setComputerPart(item);
            itemList.remove(item);
            return true;
        }

        if (unsafeComputerPart != null) {
            computer.setComputerPart(unsafeComputerPart);
            itemList.remove(unsafeComputerPart);
            throw new UnsavePCComponentsException(troubleMessage);
        }
        return false;
    }
}
