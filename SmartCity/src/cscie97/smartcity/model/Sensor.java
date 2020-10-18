package cscie97.smartcity.model;

public class Sensor {
    private String type;//microphone|camera|thermometer|co2meter
    private String value;

    public Sensor(String type, String sensorValue) {
        this.type = type;
        this.value = sensorValue;
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
}
