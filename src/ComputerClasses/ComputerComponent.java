package ComputerClasses;

public class ComputerComponent implements ComputerComponentSetter, ComputerComponentGetter, ComputerComponentsClearer {
    private final String name;

    public ComputerComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setComputerComponent(Computer computer, ComputerComponent component) throws RuntimeException {
        throw new RuntimeException("No such component\n");
    }

    @Override
    public ComputerComponent getComponent(Computer computer) throws RuntimeException {
        throw new RuntimeException("No such component\n");
    }
    
    @Override
    public void clearComputerComponent(Computer computer) throws RuntimeException {
        throw new RuntimeException("No such component\n");
    }
}
