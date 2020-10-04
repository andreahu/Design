package cscie97.smartcity.model;

public class StreetLight extends Device {

    private String brightness;

    public StreetLight(String deviceId, float lat, float lon, String enabled, String brightness) {
        super(deviceId, lat, lon, enabled);
        this.brightness = brightness;
    }

    public String getBrightness() {
        return brightness;
    }

    public void setBrightness(String brightness) {
        this.brightness = brightness;
    }
}
