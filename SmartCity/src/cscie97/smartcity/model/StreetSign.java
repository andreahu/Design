package cscie97.smartcity.model;

public class StreetSign extends Device {
    private String text;

    public StreetSign(String deviceId, float lat, float lon, boolean enabled, String text) {
        super(deviceId, lat, lon, enabled);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
