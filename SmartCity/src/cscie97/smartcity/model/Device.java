package cscie97.smartcity.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Device {

    private City city;
    private String deviceId;
    private float lat;
    private float lon;
    private String enabled;
    private String status; // reday|offline
    private String announcement;

    private Sensor microphone;
    private Sensor camera;
    private Sensor thermometer;
    private Sensor co2meter;
    private Sensor speaker;
    private Map<String, Sensor> sensorMap;


    private Event latestEvent;

    public Device(City city, String deviceId, float lat, float lon, String enabled) {
        this.city = city;
        this.deviceId = deviceId;
        this.lat = lat;
        this.lon = lon;
        this.enabled = enabled;

        this.microphone = new Sensor("microphone", "pending", this);
        this.camera = new Sensor("camera", "pending", this);
        this.thermometer = new Sensor("thermometer", "pending", this);
        this.co2meter = new Sensor("co2meter", "pending", this);
        this.speaker = new Sensor("speaker", "pending", this);
        this.sensorMap = new HashMap<>();
        sensorMap.put("microphone", microphone);
        sensorMap.put("camera", camera);
        sensorMap.put("thermometer", thermometer);
        sensorMap.put("co2meter", co2meter);
        sensorMap.put("speaker", speaker);
    }


    //getters and setters
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

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

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
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

    public Sensor getMicrophone() {
        return microphone;
    }

    public void setMicrophone(Sensor microphone) {
        this.microphone = microphone;
    }

    public Sensor getCamera() {
        return camera;
    }

    public void setCamera(Sensor camera) {
        this.camera = camera;
    }

    public Sensor getThermometer() {
        return thermometer;
    }

    public void setThermometer(Sensor thermometer) {
        this.thermometer = thermometer;
    }

    public Sensor getCo2meter() {
        return co2meter;
    }

    public void setCo2meter(Sensor co2meter) {
        this.co2meter = co2meter;
    }

    public Sensor getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Sensor speaker) {
        this.speaker = speaker;
    }
}
