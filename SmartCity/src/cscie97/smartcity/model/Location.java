package cscie97.smartcity.model;

public class Location {
    private float lat;
    private float longt;

    public Location(float la, float lo) {
        this.lat = lat;
        this.longt = lo;
    }

    //getters and setters
    public float getLat() {
        return lat;
    }

    public float getLongt() {
        return longt;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLongt(float longt) {
        this.longt = longt;
    }
}
