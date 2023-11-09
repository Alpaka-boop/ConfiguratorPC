package ComputerClasses;

public class Size {
    final private int width;
    final private int height;
    final private int depth;

    public Size(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getMaxMeasure() {
        return Math.max(Math.max(width, height), depth);
    }

    public int getSecondMaxMeasure() {
        return width + height + depth - getMinMeasure() - getMaxMeasure();
    }

    public int getMinMeasure() {
        return Math.min(Math.min(width, height), depth);
    }
}
