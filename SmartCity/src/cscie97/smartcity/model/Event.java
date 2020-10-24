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
        this.subject = "no subject info";
        this.sensor = sensor;
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


}
