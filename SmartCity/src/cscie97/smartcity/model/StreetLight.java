package cscie97.smartcity.model;

public class StreetLight extends Device {

    private int brightness;

    public StreetLight(String deviceId, float lat, float lon, String enabled, int brightness) {
        super(deviceId, lat, lon, enabled);
        this.brightness = brightness;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
}
