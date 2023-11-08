public class WiFiAdaptor {
    private enum VersionStandart {b, a, g, n, ac, ad, af, ah};
    private final VersionStandart versionStandart;
    private final boolean bluetothPresence;
    private final PCIExpress pcieVersion;
    private final int powerConsumption;

    public WiFiAdaptor(VersionStandart versionStandart, boolean bluetothPresence
                    , PCIExpress pcieVersion, int powerConsumption) {
        this.versionStandart = versionStandart;
        this.bluetothPresence = bluetothPresence;
        this.pcieVersion = pcieVersion;
        this.powerConsumption = powerConsumption;
    }
}
