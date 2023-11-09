public class Configurator {
    public void Validate(Computer computer) throws InvalidComponentsException, UnsavePCComponentsException {
        try {
            computer.Validate();
        } catch (InvalidComponentsException cause) {
            System.out.println("Invalid components!\n");
            System.out.println(cause.getMessage());
        } catch (UnsavePCComponentsException cause) {
            System.out.println("Unsave assembly! No warranty!");
            System.out.println(cause.getMessage());
        }
    }
}
