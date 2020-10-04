package cscie97.smartcity.model;

public class Vehicle extends Device {
    private String type;
    private String activity;
    private int capacity;
    private int fee;

    public Vehicle(String deviceId, float lat, float lon, Boolean enabled, String type, String activity, int capacity, int fee) {
        super(deviceId, lat, lon, enabled);
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
