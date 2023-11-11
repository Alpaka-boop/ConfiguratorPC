package ComputerClasses;

import java.util.Objects;

public class WiFiAdaptor extends ComputerComponent {
    private final String model;
    private final String versionStandard;
    private final boolean bluetoothPresence;
    private final String pcieVersion;
    private final int powerConsumption;

    public WiFiAdaptor(String versionStandard, boolean bluetoothPresence
                    , String pcieVersion, int powerConsumption, String model) {
        super("WiFiAdaptor");
        this.versionStandard = versionStandard;
        this.bluetoothPresence = bluetoothPresence;
        this.pcieVersion = pcieVersion;
        this.powerConsumption = powerConsumption;
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WiFiAdaptor that = (WiFiAdaptor) o;
        return Objects.equals(model, that.model);
    }

    @Override
    public void setComputerComponent(Computer computer, ComputerComponent component) {
        computer.setWiFiAdaptor((WiFiAdaptor) component);
    }

    @Override
    public ComputerComponent getComponent(Computer computer) {
        return computer.getWiFiAdaptor();
    }
    
    @Override
    public void clearComputerComponent(Computer computer) {
        computer.setWiFiAdaptor(null);
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
