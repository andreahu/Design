package cscie97.smartcity.model;

public class Kiosk extends Device {
    private String imageLink;

    public Kiosk(City city, String deviceId, float lat, float lon, String enabled, String imageLink) {
        super(city, deviceId, lat, lon, enabled);
        this.imageLink = imageLink;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
