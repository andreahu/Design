package cscie97.smartcity.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Device {

    private String deviceId;
    private float lat;
    private float lon;
    private String enabled;
    private String status; // reday|offline

    private Sensor microphone;
    private Sensor camera;
    private Sensor thermometer;
    private Sensor co2meter;
    private Map<String, Sensor> sensorMap;

    private Event latestEvent;

    public Device(String deviceId, float lat, float lon, String enabled) {
        this.deviceId = deviceId;
        this.lat = lat;
        this.lon = lon;
        this.enabled = enabled;

        this.microphone = new Sensor("microphone", "pending");
        this.camera = new Sensor("camera", "pending");
        this.thermometer = new Sensor("thermometer", "pending");
        this.co2meter = new Sensor("co2meter", "pending");
        this.sensorMap = new HashMap<>();
        sensorMap.put("microphone", microphone);
        sensorMap.put("camera", camera);
        sensorMap.put("thermometer", thermometer);
        sensorMap.put("co2meter", co2meter);
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

    public Map<String, Sensor> getSensorMap() {
        return sensorMap;
    }

    public void setSensorMap(Map<String, Sensor> sensorMap) {
        this.sensorMap = sensorMap;
    }

    public Event getLatestEvent() {
        return latestEvent;
    }

    public void setLatestEvent(Event latestEvent) {
        this.latestEvent = latestEvent;
    }
}
