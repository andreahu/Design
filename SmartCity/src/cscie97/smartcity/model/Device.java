package cscie97.smartcity.model;

public abstract class Device {

    private String deviceId;
    private float lat;
    private float lon;
    private String enabled;
    private String status;

    private String sensorType;//microphone|camera|thermometer|co2meter
    private String sensorValue;
    private String sensorSubject;


    public Device(String deviceId, float lat, float lon, String enabled) {
        this.deviceId = deviceId;
        this.lat = lat;
        this.lon = lon;
        this.enabled = enabled;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }


    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(String sensorValue) {
        this.sensorValue = sensorValue;
    }

    public String getSensorSubject() {
        return sensorSubject;
    }

    public void setSensorSubject(String sensorSubject) {
        this.sensorSubject = sensorSubject;
    }
}
