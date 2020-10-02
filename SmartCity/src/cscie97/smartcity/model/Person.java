package cscie97.smartcity.model;

public abstract class Person {

    private String personId;
    private String biometricId;
    private float lat;
    private float longt;

    public Person(String personId, String biometricId, float lat, float longt) {
        this.biometricId = biometricId;
        this.personId = personId;
        this.lat = lat;
        this.longt = longt;
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

    public float getLongt() {
        return longt;
    }

    public void setLongt(float longt) {
        this.longt = longt;
    }
}
