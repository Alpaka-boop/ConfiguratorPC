package Configurator;

import ComputerClasses.Computer;
import ComputerClasses.InvalidComponentsException;
import ComputerClasses.UnsavePCComponentsException;
import StoreHouse.StoreHouse;

public class Configurator {
    StoreHouse storeHouse;
    public void Validate(Computer computer) throws InvalidComponentsException, UnsavePCComponentsException {
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
}
