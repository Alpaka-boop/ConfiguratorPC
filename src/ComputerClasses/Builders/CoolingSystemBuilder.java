package ComputerClasses.Builders;

import ComputerClasses.CoolingSystem;
import ComputerClasses.Size;
import ComputerClasses.Socket;

import java.util.ArrayList;

public class CoolingSystemBuilder {
    private String model;
    private Size size;
    private final ArrayList<Socket> socketsList = new ArrayList<>();
    private int maxTDP;

    public CoolingSystemBuilder() {}

    public CoolingSystemBuilder(CoolingSystem coolingSystem) {
        this.model = coolingSystem.getModel();
        this.size = coolingSystem.getSize();
        this.socketsList.addAll(coolingSystem.getSocketsList());
        this.maxTDP = coolingSystem.getMaxTDP();
    }

    public CoolingSystemBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public CoolingSystemBuilder setSize(Size size) {
        this.size = size;
        return this;
    }

    public CoolingSystemBuilder setSocketsList(ArrayList<Socket> socketsList) {
        this.socketsList.addAll(socketsList);
        return this;
    }

    public CoolingSystemBuilder setMaxTDP(int maxTDP) {
        this.maxTDP = maxTDP;
        return this;
    }

    public CoolingSystem build() {
        return new CoolingSystem(model, size, maxTDP, socketsList);
    }
}
