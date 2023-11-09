package ComputerClasses;

public class WiFiAdaptor extends ComputerPart {
    private final String model;
    private final String versionStandard;
    private final boolean bluetoothPresence;
    private final String pcieVersion;
    private final int powerConsumption;

    public WiFiAdaptor(String versionStandard, boolean bluetoothPresence
                    , String pcieVersion, int powerConsumption, String model) {
        this.versionStandard = versionStandard;
        this.bluetoothPresence = bluetoothPresence;
        this.pcieVersion = pcieVersion;
        this.powerConsumption = powerConsumption;
        this.model = model;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public String getModel() {
        return model;
    }

    public String getVersionStandard() {
        return versionStandard;
    }

    public boolean isBluetoothPresence() {
        return bluetoothPresence;
    }

    public String getPcieVersion() {
        return pcieVersion;
    }
}
