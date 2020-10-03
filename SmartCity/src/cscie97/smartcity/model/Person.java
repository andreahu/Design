package cscie97.smartcity.model;

public abstract class Person {

    private String personId;
    private String biometricId;
    private float lat;
    private float lon;

    public Person(String personId, String biometricId, float lat, float lon) {
        this.biometricId = biometricId;
        this.personId = personId;
        this.lat = lat;
        this.lon = lon;
    }

    public String getBiometricId() {
        return biometricId;
    }

    public void setBiometricId(String biometricId) {
        this.biometricId = biometricId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
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
