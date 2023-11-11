package StoreHouse;
import ComputerClasses.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

    public void putComputerComponent(ComputerComponent object) {
        storage.get(object.getClass().getSimpleName()).add(object);
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

    public void makeShelfForNewComponent(String name) {
        storage.put(name, new ArrayList<>());
    }

    public static ComputerComponent findSuitableComputerComponent(Computer computer, String name) {
        ArrayList<ComputerComponent> itemList = storage.get(name);
        ComputerComponent[] unsafeComputerComponent = new ComputerComponent[]{null};
        ComputerComponent newComponent = findComponentHelper(unsafeComputerComponent, computer, itemList);

        if (unsafeComputerComponent[0] != null) {
            itemList.remove(unsafeComputerComponent[0]);
            return unsafeComputerComponent[0];
        }
        return null;
    }

    public static ComputerComponent findSuitableComputerComponent(Computer computer, ComputerComponent oldComponent) {
        ArrayList<ComputerComponent> itemList = storage.get(oldComponent.getName());
        ComputerComponent[] unsafeComputerComponent = new ComputerComponent[]{null};
        ComputerComponent newComponent = findComponentHelper(unsafeComputerComponent, computer, itemList);
        if (newComponent != null) {
            return newComponent;
        }
        if (unsafeComputerComponent[0] != null) {
            oldComponent.setComputerComponent(computer, oldComponent);
            itemList.remove(unsafeComputerComponent[0]);
            return unsafeComputerComponent[0];
        }
        return null;
    }

    private static ComputerComponent findComponentHelper(ComputerComponent[] unsafeComputerComponent
            , Computer computer, ArrayList<ComputerComponent> itemList) {
        Iterator<ComputerComponent> iterator = itemList.iterator();
        while (iterator.hasNext()) {
            ComputerComponent item = iterator.next();
            item.setComputerComponent(computer, item);
            try {
                computer.Validate();
            } catch (InvalidComputerComponentsException e) {
                item.clearComputerComponent(computer);
                continue;
            } catch (UnsavePCComputerComponentsException e) {
                unsafeComputerComponent[0] = item;
                item.clearComputerComponent(computer);
                continue;
            }
            item.setComputerComponent(computer, item);
            iterator.remove();
            return item;
        }
        return null;
    }
}
