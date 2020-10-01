package cscie97.smartcity.model;

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


    public City(String cityId, String cityName, String blockChainAccount, Location location, float radius) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.blockChainAccount = blockChainAccount;
        this.location = location;
        this.radius = radius;


    }
}
