package cscie97.smartcity.model;

import java.util.HashMap;
import java.util.Map;

public class City {
    //attributes
    private String cityId;
    private String cityName;
    private String blockChainAccount;
    private Location location;
    private float radius;

    //association
    private Map<Integer, Device> deviceMap;
    private Map<Integer, Person> personMap;

    /**
     * Constructor
     * @param cityId
     * @param cityName
     * @param blockChainAccount
     * @param location
     * @param radius
     */
    public City(String cityId, String cityName, String blockChainAccount, Location location, float radius) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.blockChainAccount = blockChainAccount;
        this.location = location;
        this.radius = radius;

        this.deviceMap = new HashMap<>();
        this.personMap = new HashMap<>();
    }

    /* getters and setters */
    public String getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getBlockChainAccount() {
        return blockChainAccount;
    }

    public Location getLocation() {
        return location;
    }

    public float getRadius() {
        return radius;
    }

    public Map<Integer, Device> getDeviceMap() {
        return deviceMap;
    }

    public Map<Integer, Person> getPersonMap() {
        return personMap;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setBlockChainAccount(String blockChainAccount) {
        this.blockChainAccount = blockChainAccount;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setDeviceMap(Map<Integer, Device> deviceMap) {
        this.deviceMap = deviceMap;
    }

    public void setPersonMap(Map<Integer, Person> personMap) {
        this.personMap = personMap;
    }
}
