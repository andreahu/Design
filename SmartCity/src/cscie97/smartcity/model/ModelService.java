package cscie97.smartcity.model;

import java.util.Map;

public class ModelService {

    private Map<String, City> cityMap;
    private Map<String, Person> completePersonMap;

    /**
     * @param cityId
     * @param cityName
     * @param blockChainAccount
     * @param lat
     * @param longt
     * @param radius
     * @return the city object created
     */
    public City defineCity(String cityId, String cityName, String blockChainAccount, float lat, float longt, float radius) {
        City city = new City(cityId, cityName, blockChainAccount, lat, longt, radius);
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
                + " Latitude: " + city.getLat() + " Longitude: " + city.getLongt() + " radius: " + city.getRadius());
    }

    public boolean withinCity(float cityLat, float cityLo, float radius, float la, float lo) {
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
     * @param cityId
     * @param deviceId
     * @param lat
     * @param longt
     * @param enabled
     * @param brightness
     * @return the street light object created
     */
    public StreetLight defineStreetLight(String cityId, String deviceId, float lat, float longt, boolean enabled, int brightness) {
        StreetLight streetLight = new StreetLight(deviceId, lat, longt, enabled, brightness);
        City theCity = cityMap.get(cityId);
        theCity.getDeviceMap().put(deviceId, streetLight);
        return streetLight;
    }

    public void updateStreetLight(String cityId, String deviceId, boolean enabled, int brightness) {
        Device streetLight = cityMap.get(cityId).getDeviceMap().get(deviceId);
        ((StreetLight) streetLight).setBrightness(brightness);
    }


    /*Below are Person methods */
    public Resident defineResident(String personId, String name, String biometricId, String phoneNumber, String role, float lat, float longt, String blockChainAccountId) {
        Resident resident = new Resident(personId, name, biometricId, phoneNumber, role, lat, longt, blockChainAccountId);
        completePersonMap.put(personId, resident);
        //@TODO calculate the resident's location and locate a city for him, then add to city's personMap

        return resident;
    }

    public void updateResident(String personId, String name, String biometricId, String phoneNumber,
                               String role, float lat, float longt, String blockChainAccountId) {
        Resident resident = (Resident) completePersonMap.get(personId);
        if (name != null) {
            resident.setName(name);
        }
        if (biometricId != null) {

        }
        if (phoneNumber != null) {
            resident.setPhoneNumber(phoneNumber);
        }
        if (role != null) {
            resident.setRole(role);
        }

        resident.setLat(lat);
        resident.setLongt(longt);

        if (blockChainAccountId != null) {
            resident.setBlockChainAccountId(blockChainAccountId);
        }
    }


}
