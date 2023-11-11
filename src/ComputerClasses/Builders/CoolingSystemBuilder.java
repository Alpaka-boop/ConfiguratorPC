package ComputerClasses.Builders;

import ComputerClasses.CoolingSystem;
import ComputerClasses.Size;
import ComputerClasses.Socket;

import java.util.ArrayList;

public class CoolingSystemBuilder {
    private String model;
    private Size size;
    private ArrayList<Socket> socketsList = new ArrayList<>();
    private int maxTDP;

    public CoolingSystemBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public CoolingSystemBuilder setSize(Size size) {
        this.size = size;
        return this;
    }

    public CoolingSystemBuilder setSocketsList(ArrayList<Socket> socketsList) {
        this.socketsList = socketsList;
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
