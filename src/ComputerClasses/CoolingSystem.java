package ComputerClasses;

import java.util.ArrayList;

public class CoolingSystem extends ComputerPart {
    final private String model;
    final private Size size;
    final private ArrayList<Socket> socketsList = new ArrayList<>();
    final private int maxTDP;

    public CoolingSystem(String model, Size size, int maxTDP, ArrayList<Socket> socketsList) {
        this.size = size;
        this.maxTDP = maxTDP;
        this.socketsList.addAll(socketsList);
        this.model = model;
    }

    public int getMaxTDP() {
        return maxTDP;
    }

    public Size getSize() {
        return size;
    }

    public String getModel() {
        return model;
    }

    public ArrayList<Socket> getSocketsList() {
        return socketsList;
    }
}
