package StoreHouse;
import ComputerClasses.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class StoreHouse {
    private static final HashMap<String, ArrayList<ComputerComponent>> storage = new HashMap<>();

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

    public StoreHouse putComputerComponent(ComputerComponent object) {
        storage.get(object.getClass().getSimpleName()).add(object);
        return this;
    }

    public static ComputerComponent getComputerComponent(ComputerComponent component) {
        ArrayList<ComputerComponent> itemList = storage.get(component.getName());
        for (ComputerComponent item: itemList) {
            if (Objects.equals(item, component)) {
                itemList.remove(item);
                return item;
            }
        }
        return null;
    }

    public static boolean findSuitableComputerComponent(Computer computer, String name) throws UnsavePCComputerComponentsException {
        ArrayList<ComputerComponent> itemList = storage.get(name);
        String troubleMessage = "";
        ComputerComponent unsafeComputerComponent = null;
        for (ComputerComponent item: itemList) {
            computer.setComputerComponent(item);
            try {
                computer.Validate();
            } catch (InvalidComputerComponentsException e) {
                computer.clearComponent(name);
                continue;
            } catch (UnsavePCComputerComponentsException e) {
                unsafeComputerComponent = item;
                troubleMessage = e.getMessage();
                computer.clearComponent(name);
                continue;
            }
            computer.setComputerComponent(item);
            itemList.remove(item);
            return true;
        }

        if (unsafeComputerComponent != null) {
            computer.setComputerComponent(unsafeComputerComponent);
            itemList.remove(unsafeComputerComponent);
            throw new UnsavePCComputerComponentsException(troubleMessage);
        }
        return false;
    }
}
