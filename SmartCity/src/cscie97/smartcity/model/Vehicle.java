package cscie97.smartcity.model;

public class Vehicle extends Device {
    private String type;
    private String activity;
    private String capacity;
    private String fee;

    public Vehicle(City city, String deviceId, float lat, float lon, String enabled, String type, String activity, String capacity, String fee) {
        super(city, deviceId, lat, lon, enabled);
        this.type = type;
        this.activity = activity;
        this.capacity = capacity;
        this.fee = fee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
