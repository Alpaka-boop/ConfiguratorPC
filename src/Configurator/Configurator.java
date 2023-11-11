package Configurator;

import ComputerClasses.*;
import StoreHouse.StoreHouse;

public class Configurator {
    private Computer computer;
    private final StoreHouse storeHouse;

    public Configurator(Computer computer, StoreHouse storeHouse) {
        this.computer = computer;
        this.storeHouse = storeHouse;
    }

    public boolean ValidateComputer(Computer computer) throws InvalidComputerComponentsException
                                                            , UnsavePCComputerComponentsException {
        try {
            computer.Validate();
        } catch (InvalidComputerComponentsException cause) {
            System.out.println("Invalid components!\n");
            System.out.println(cause.getMessage());
            return false;
        } catch (UnsavePCComputerComponentsException cause) {
            System.out.println("Unsave assembly! No warranty!");
            System.out.println(cause.getMessage());
        }
        return true;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void setComponent(ComputerComponent component) throws RuntimeException {
        ComputerComponent storeComputerComponent = StoreHouse.getComputerComponent(component);
        if (storeComputerComponent == null) {
            throw new RuntimeException("No such component in storehouse");
        }
        component.setComputerComponent(computer, storeComputerComponent);
        if (!ValidateComputer(computer)) {
            storeHouse.putComputerComponent(storeComputerComponent);
            computer.clearComponent(component.getName());
        }
    }

    public ComputerComponent changeComputerComponent(ComputerComponent component) {
        ComputerComponent unsavedComputerComponent = StoreHouse.findSuitableComputerComponent(computer, component);
        if (unsavedComputerComponent == null) {
            throw new RuntimeException("No such component in storehouse");
        } else {
            return unsavedComputerComponent;
        }
    }

    public ComputerComponent setComponent(String name) throws RuntimeException {
        ComputerComponent unsafeComponent = StoreHouse.findSuitableComputerComponent(computer, name);
        if (unsafeComponent == null) {
            throw new RuntimeException("No such component in storehouse");
        } else {
            return unsafeComponent;
        }
    }
}
