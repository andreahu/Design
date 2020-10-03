package cscie97.smartcity.model;

public class Kiosk extends Device {
    private String imageLink;

    public Kiosk(String deviceId, float lat, float lon, boolean enabled, String imageLink) {
        super(deviceId, lat, lon, enabled);
        this.imageLink = imageLink;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
