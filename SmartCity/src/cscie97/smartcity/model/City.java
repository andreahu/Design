package cscie97.smartcity.model;

import java.util.Map;

public class City {
    //attributes
    private int cityId;
    private int cityName;
    private int blockChainAccount;
    private Location location;
    private float radius;

    //association
    private Map<Integer, Device> deviceMap;
    private Map<Integer, Person> personMap;


}
