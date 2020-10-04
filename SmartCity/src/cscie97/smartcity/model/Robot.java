package cscie97.smartcity.model;

public class Robot extends Device {
    private String activity;

    public Robot(String deviceId, float lat, float lon, String enabled, String activity) {
        super(deviceId, lat, lon, enabled);
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
