package cscie97.smartcity.model;

public class ParkingSpace extends Device {
    private int rate;

    public ParkingSpace(String deviceId, float lat, float lon, boolean enabled, int rate) {
        super(deviceId, lat, lon, enabled);
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
