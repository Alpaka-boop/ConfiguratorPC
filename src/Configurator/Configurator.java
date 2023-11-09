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

    public void ValidateComputer(Computer computer) throws InvalidComponentsException, UnsavePCComponentsException {
        try {
            computer.Validate();
        } catch (InvalidComponentsException cause) {
            System.out.println("Invalid components!\n");
            System.out.println(cause.getMessage());
        } catch (UnsavePCComponentsException cause) {
            System.out.println("Unsave assembly! No warranty!");
            System.out.println(cause.getMessage());
        }
    }

    public void setObject(ComputerPart computerPart) {

    }
}
