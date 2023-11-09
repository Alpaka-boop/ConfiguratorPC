package ComputerClasses;

public record FormFactor(Size size) {

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
