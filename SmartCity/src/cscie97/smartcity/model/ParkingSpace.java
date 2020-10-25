package cscie97.smartcity.model;

public class ParkingSpace extends Device {
    private int rate;

    public ParkingSpace(City city, String deviceId, float lat, float lon, String enabled, int rate) {
        super(city, deviceId, lat, lon, enabled);
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
