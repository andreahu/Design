package cscie97.smartcity.model;

import java.util.Map;

public class ModelService {

    private Map<String, City> cityMap;
    private Map<String, Person> masterPersonMap;

    public static float FLOAT_EMPTY = Float.MAX_VALUE;

    /**
     * create city object and save to the city map
     *
     * @param cityId
     * @param cityName
     * @param blockChainAccount
     * @param lat
     * @param lon
     * @param radius
     * @return the city object created
     */
    public City defineCity(String cityId, String cityName, String blockChainAccount, float lat, float lon, float radius) {
        City city = new City(cityId, cityName, blockChainAccount, lat, lon, radius);
        cityMap.put(cityId, city);
        return city;
    }

    /**
     * Show the details of a city. Print out the details of the city.
     *
     * @param cityId that represent the city
     */
    public void showCity(String cityId) {
        City city = cityMap.get(cityId);
        System.out.println("City ID: " + city.getCityId() + " City Name: " + city.getCityName() + " Block Chain Account: " + city.getBlockChainAccount()
                + " Latitude: " + city.getLat() + " Longitude: " + city.getlon() + " radius: " + city.getRadius());
    }

    /**
     * calculate if a location is within a city's radius
     *
     * @param cityLat
     * @param cityLo
     * @param radius
     * @param la
     * @param lo
     * @return true or false
     */
    public Boolean withinCity(float cityLat, float cityLo, float radius, float la, float lo) {
        if (Math.pow((cityLat - la), 2) + Math.pow((cityLo - lo), 2) <= Math.pow(radius, 2)) {
            return true;
        } else {
            return false;
        }
    }

    /*Below are Device methods */

    /**
     * create StreeSign object and add to the city's device map
     *
     * @param cityId
     * @param deviceId
     * @param lat
     * @param lon
     * @param enabled
     * @param text
     * @return
     */
    public StreetSign defineStreetSign(String cityId, String deviceId, float lat, float lon, Boolean enabled, String text) {
        StreetSign streetSign = new StreetSign(deviceId, lat, lon, enabled, text);
        City theCity = cityMap.get(cityId);
        theCity.getDeviceMap().put(deviceId, streetSign);
        return streetSign;
    }

    /**
     * update the streetSign config
     *
     * @param cityId
     * @param deviceId
     * @param text
     */
    public void updateStreetSign(String cityId, String deviceId, String text) {
        Device streetSign = cityMap.get(cityId).getDeviceMap().get(deviceId);
        ((StreetSign) streetSign).setText(text);
    }

    /**
     * create Kiosk object
     *
     * @param cityId
     * @param deviceId
     * @param lat
     * @param lon
     * @param enabled
     * @param imageLink
     * @return the kiosk object created
     */
    public Kiosk defineKiosk(String cityId, String deviceId, float lat, float lon, Boolean enabled, String imageLink) {
        Kiosk kiosk = new Kiosk(deviceId, lat, lon, enabled, imageLink);
        City theCity = cityMap.get(cityId);
        theCity.getDeviceMap().put(deviceId, kiosk);
        return kiosk;
    }

    /**
     * update kiosk config
     *
     * @param cityId
     * @param deviceId
     * @param enabled
     * @param imageLink
     */
    //@TODO: enabled and imagelink are both optional in script
    public void updateKiosk(String cityId, String deviceId, Boolean enabled, String imageLink) {
        Device kiosk = cityMap.get(cityId).getDeviceMap().get(deviceId);
        if (enabled != null) kiosk.setEnabled(enabled);
        if (imageLink != null) ((Kiosk) kiosk).setImageLink(imageLink);
    }

    /**
     * create the street light object and add the device to the city it belongs to
     *
     * @param cityId:    the city Id
     * @param deviceId
     * @param lat
     * @param lon
     * @param enabled
     * @param brightness
     * @return the street light object created
     */
    public StreetLight defineStreetLight(String cityId, String deviceId, float lat, float lon, Boolean enabled, int brightness) {
        StreetLight streetLight = new StreetLight(deviceId, lat, lon, enabled, brightness);
        City theCity = cityMap.get(cityId);
        theCity.getDeviceMap().put(deviceId, streetLight);
        return streetLight;
    }

    /**
     * update StreetLight config
     *
     * @param cityId
     * @param deviceId
     * @param enabled
     * @param brightness
     */
    public void updateStreetLight(String cityId, String deviceId, Boolean enabled, int brightness) {
        Device streetLight = cityMap.get(cityId).getDeviceMap().get(deviceId);
        ((StreetLight) streetLight).setBrightness(brightness);
    }

    /**
     * create parking space object
     *
     * @param cityId
     * @param deviceId
     * @param lat
     * @param lon
     * @param enabled
     * @param rate
     * @return the created object
     */
    public ParkingSpace defineParkingSpace(String cityId, String deviceId, float lat, float lon, Boolean enabled, int rate) {
        ParkingSpace parkingSpace = new ParkingSpace(deviceId, lat, lon, enabled, rate);
        City theCity = cityMap.get(cityId);
        theCity.getDeviceMap().put(deviceId, parkingSpace);
        return parkingSpace;
    }

    /**
     * update parking space config
     *
     * @param cityId
     * @param deviceId
     * @param enabled
     * @param rate
     */
    public void updateParkingSpace(String cityId, String deviceId, Boolean enabled, int rate) {
        Device parkingSpace = cityMap.get(cityId).getDeviceMap().get(deviceId);
        ((ParkingSpace) parkingSpace).setRate(rate);
    }

    //Below are Person methods

    /**
     * create resident object and save to the person maps in different classes
     *
     * @param personId
     * @param name
     * @param biometricId
     * @param phoneNumber
     * @param role
     * @param lat
     * @param lon
     * @param blockChainAccountId
     * @return the resident object created
     */
    public Resident defineResident(String personId, String name, String biometricId, String phoneNumber, String role, float lat, float lon, String blockChainAccountId) {
        Resident resident = new Resident(personId, name, biometricId, phoneNumber, role, lat, lon, blockChainAccountId);
        masterPersonMap.put(personId, resident);
        //@TODO:find the city by the lat and lon, and add resident to the city's personMap
        return resident;
    }

    /**
     * update resident info
     *
     * @param personId
     * @param name
     * @param biometricId
     * @param phoneNumber
     * @param role
     * @param lat
     * @param lon
     * @param blockChainAccountId
     */
    //@TODO all parameters except for personID are optional in script
    public void updateResident(String personId, String name, String biometricId, String phoneNumber,
                               String role, float lat, float lon, String blockChainAccountId) {
        Resident resident = (Resident) masterPersonMap.get(personId);
        if (name != null) resident.setName(name);
        if (biometricId != null) resident.setBiometricId(biometricId);
        if (phoneNumber != null) resident.setPhoneNumber(phoneNumber);
        if (role != null) resident.setRole(role);
        if (lat != FLOAT_EMPTY) resident.setLat(lat);
        if (lon != FLOAT_EMPTY) resident.setLon(lon);
        if (blockChainAccountId != null) resident.setBlockChainAccountId(blockChainAccountId);
    }

    /**
     * create Visitor object and add to map
     *
     * @param personId
     * @param biometricId
     * @param lat
     * @param lon
     */
    public void defineVisitor(String personId, String biometricId, float lat, float lon) {
        Visitor visitor = new Visitor(personId, biometricId, lat, lon);
        masterPersonMap.put(personId, visitor);
        //@TODO:find the city by the lat and lon, and add visitor to the city's personMap
    }

    /**
     * update the visitor info
     *
     * @param personId
     * @param biometricId
     * @param lat
     * @param lon
     */
    //@TODO all parameters except for personID are optional in script
    public void updateVisitor(String personId, String biometricId, float lat, float lon) {
        Resident resident = (Resident) masterPersonMap.get(personId);
        if (biometricId != null) resident.setBiometricId(biometricId);
        if (lat != FLOAT_EMPTY) resident.setLat(lat);
        if (lon != FLOAT_EMPTY) resident.setLon(lon);
    }
}
