package ComputerClasses.Builders;

import ComputerClasses.WiFiAdaptor;

public class WiFiAdaptorBuilder {
    private String model;
    private String versionStandard;
    private boolean bluetoothPresence;
    private String pcieVersion;
    private int powerConsumption;

    public WiFiAdaptorBuilder() {}

    public WiFiAdaptorBuilder(WiFiAdaptor wifiAdaptor) {
        this.model = wifiAdaptor.getModel();
        this.versionStandard = wifiAdaptor.getVersionStandard();
        this.bluetoothPresence = wifiAdaptor.isBluetoothPresence();
        this.pcieVersion = wifiAdaptor.getPcieVersion();
        this.powerConsumption = wifiAdaptor.getPowerConsumption();
    }

    public WiFiAdaptorBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public WiFiAdaptorBuilder setVersionStandard(String versionStandard) {
        this.versionStandard = versionStandard;
        return this;
    }

    public WiFiAdaptorBuilder setBluetoothPresence(boolean bluetoothPresence) {
        this.bluetoothPresence = bluetoothPresence;
        return this;
    }

    public WiFiAdaptorBuilder setPcieVersion(String pcieVersion) {
        this.pcieVersion = pcieVersion;
        return this;
    }

    public WiFiAdaptorBuilder setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    public WiFiAdaptor build() {
        return new WiFiAdaptor(versionStandard, bluetoothPresence, pcieVersion, powerConsumption, model);
    }
}
