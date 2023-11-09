public class FormFactor {
    private Size size;


    public Size getSize() {
        return size;
    }

    public int getMaxMeasure() {
        return size.getMaxMeasure();
    }

    public int getMinMeasure() {
        return size.getMinMeasure();
    }
}
