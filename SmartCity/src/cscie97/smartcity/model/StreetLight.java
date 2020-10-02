package cscie97.smartcity.model;

public class StreetLight extends Device {

    private int brightness;

    public StreetLight(String deviceId, float lat, float longt, boolean enabled, int brightness) {
        super(deviceId, lat, longt, enabled);
        this.brightness = brightness;
    }

    
    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
}
