package cscie97.smartcity.model;

public class Event {
    private String type;
    private String value;
    private String subject;
    private Sensor sensor;

    private City city;
    private Device device;
    private float lat;
    private float lon;


    public Event(String type, String value, Sensor sensor) {
        this.type = type;
        this.value = value;
        this.sensor = sensor;

        this.subject = "no subject info";
        city = sensor.getCity();
        device = sensor.getDevice();
        lat = sensor.getLat();
        lon = sensor.getLon();
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
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
