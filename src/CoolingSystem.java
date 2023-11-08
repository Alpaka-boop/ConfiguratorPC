import java.util.ArrayList;

public class CoolingSystem {
    final private Size size;
    final private ArrayList<Socket> socketsLists = new ArrayList<>();
    final private int max_TDP;

    public CoolingSystem(Size size, int max_TDP, ArrayList<Socket> socketsLists) {
        this.size = size;
        this.max_TDP = max_TDP;
        this.socketsLists.addAll(socketsLists);
    }
}
