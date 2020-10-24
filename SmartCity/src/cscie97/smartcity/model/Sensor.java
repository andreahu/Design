package cscie97.smartcity.model;

public class Sensor {
    private String type;//microphone|camera|thermometer|co2meter
    private String value;

    private City city;
    private Device device;
    private float lat;
    private float lon;

    public Sensor(String type, String value, City city, Device device) {
        this.type = type;
        this.value = value;
        this.city = city;
        this.device = device;
        this.lat = device.getLat();
        this.lon = device.getLon();
    }

    //getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
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
}
