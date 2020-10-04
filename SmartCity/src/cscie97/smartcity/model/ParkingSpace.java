package cscie97.smartcity.model;

public class ParkingSpace extends Device {
    private String rate;

    public ParkingSpace(String deviceId, float lat, float lon, String enabled, String rate) {
        super(deviceId, lat, lon, enabled);
        this.rate = rate;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
