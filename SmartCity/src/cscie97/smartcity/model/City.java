package cscie97.smartcity.model;

import java.util.HashMap;
import java.util.Map;

public class City {
    //attributes
    private String cityId;
    private String cityName;
    private String blockChainAccount;
    private float lat;
    private float longt;
    private float radius;

    //association
    private Map<String, Device> deviceMap;
    private Map<Integer, Person> personMap;

    /**
     * @param cityId
     * @param cityName
     * @param blockChainAccount
     * @param lat
     * @param longt
     * @param radius
     */
    public City(String cityId, String cityName, String blockChainAccount, float lat, float longt, float radius) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.blockChainAccount = blockChainAccount;
        this.lat = lat;
        this.longt = longt;
        this.radius = radius;

        this.deviceMap = new HashMap<>();
        this.personMap = new HashMap<>();
    }


    /* getters and setters */

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getBlockChainAccount() {
        return blockChainAccount;
    }

    public void setBlockChainAccount(String blockChainAccount) {
        this.blockChainAccount = blockChainAccount;
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

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public Map<String, Device> getDeviceMap() {
        return deviceMap;
    }

    public void setDeviceMap(Map<String, Device> deviceMap) {
        this.deviceMap = deviceMap;
    }

    public Map<Integer, Person> getPersonMap() {
        return personMap;
    }

    public void setPersonMap(Map<Integer, Person> personMap) {
        this.personMap = personMap;
    }
}
