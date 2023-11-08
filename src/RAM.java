import java.util.ArrayList;

public class RAM {
    private enum ExtremeMemProf {
        XMP,
        DOCP
    };
    private enum FormFactor {

    };
    private enum DDRVersion {
        DDR1,
        DDR2,
        DDR3,
        DDR4
    };
    private int storageSize;
    // Поддерживаемые пары частот JEDEC и вольтажа
    private ExtremeMemProf extremeMemProf;
    private final ArrayList<FormFactor> availableFormFactors = new ArrayList<>();
    DDRVersion ddrVersion;
    int powerConsumption;
}
