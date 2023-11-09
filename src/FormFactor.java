public class FormFactor {
    private Size size;


    public Size getSize() {
        return size;
    }

    public int getMaxMeasure() {
        return size.getMaxMeasure();
    }

    public int getSecondMaxMeasure() {
        return size.getSecondMaxMeasure();
    }

    public int getMinMeasure() {
        return size.getMinMeasure();
    }
}
