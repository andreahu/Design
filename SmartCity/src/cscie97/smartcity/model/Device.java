package cscie97.smartcity.model;

public abstract class Device {

    private String deviceId;
    private float lat;
    private float lon;
    private boolean enabled;
    private String status;

    public Device(String deviceId, float lat, float lon, boolean enabled) {
        this.deviceId = deviceId;
        this.lat = lat;
        this.lon = lon;
        this.enabled = enabled;
//        this.status = status;
    }

    //getters and setters

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
