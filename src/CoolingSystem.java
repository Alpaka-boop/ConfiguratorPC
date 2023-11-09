import java.util.ArrayList;

public class CoolingSystem {
    final private Size size;
    final private ArrayList<Socket> socketsLists = new ArrayList<>();
    final private int maxTDP;

    public CoolingSystem(Size size, int maxTDP, ArrayList<Socket> socketsLists) {
        this.size = size;
        this.maxTDP = maxTDP;
        this.socketsLists.addAll(socketsLists);
    }

    public int getMaxTDP() {
        return maxTDP;
    }

    public Size getSize() {
        return size;
    }
}
