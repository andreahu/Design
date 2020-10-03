package cscie97.smartcity.model;

import java.util.Map;

public class ModelService {

    private Map<String, City> cityMap;
    private Map<String, Person> completePersonMap;

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
     * calculate if the distance between a location and a city is inside the city's radius
     *
     * @param cityLat
     * @param cityLo
     * @param radius
     * @param la
     * @param lo
     * @return true or false
     */
    public boolean withinCityRadius(float cityLat, float cityLo, float radius, float la, float lo) {
        if (Math.pow((cityLat - la), 2) + Math.pow((cityLo - lo), 2) <= Math.pow(radius, 2)) {
            return true;
        } else {
            return false;
        }
    }

    /*Below are Device methods */

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
    public StreetLight defineStreetLight(String cityId, String deviceId, float lat, float lon, boolean enabled, int brightness) {
        StreetLight streetLight = new StreetLight(deviceId, lat, lon, enabled, brightness);
        City theCity = cityMap.get(cityId);
        theCity.getDeviceMap().put(deviceId, streetLight);
        return streetLight;
    }

    public void updateStreetLight(String cityId, String deviceId, boolean enabled, int brightness) {
        Device streetLight = cityMap.get(cityId).getDeviceMap().get(deviceId);
        ((StreetLight) streetLight).setBrightness(brightness);
    }


    /*Below are Person methods */

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
        completePersonMap.put(personId, resident);
        //@TODO calculate the resident's location and locate a city for him, then add to city's personMap

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
    public void updateResident(String personId, String name, String biometricId, String phoneNumber,
                               String role, float lat, float lon, String blockChainAccountId) {
        Resident resident = (Resident) completePersonMap.get(personId);
        if (name != null) {
            resident.setName(name);
        }
        if (biometricId != null) {
            resident.setBiometricId(biometricId);
        }
        if (phoneNumber != null) {
            resident.setPhoneNumber(phoneNumber);
        }
        if (role != null) {
            resident.setRole(role);
        }
        if (lat != FLOAT_EMPTY) {
            resident.setLat(lat);
        }
        if (lon != FLOAT_EMPTY) {
            resident.setLon(lon);
        }
        if (blockChainAccountId != null) {
            resident.setBlockChainAccountId(blockChainAccountId);
        }
    }
}
