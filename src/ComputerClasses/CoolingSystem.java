package ComputerClasses;

import java.util.ArrayList;

public class CoolingSystem extends ComputerComponent {
    final private String model;
    final private Size size;
    final private ArrayList<Socket> socketsList = new ArrayList<>();
    final private int maxTDP;

    public CoolingSystem(String model, Size size, int maxTDP, ArrayList<Socket> socketsList) {
        super("CoolingSystem");
        this.size = size;
        this.maxTDP = maxTDP;
        this.socketsList.addAll(socketsList);
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoolingSystem that = (CoolingSystem) o;
        return model.equals(that.model);
    }

    @Override
    public void setComputerComponent(Computer computer, ComputerComponent component) {
        computer.setCoolingSystem((CoolingSystem) component);
    }

    @Override
    public ComputerComponent getComponent(Computer computer) {
        return computer.getCoolingSystem();
    }
    
    @Override
    public void clearComputerComponent(Computer computer) {
        computer.setCoolingSystem(null);
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
