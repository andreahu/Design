package cscie97.smartcity.model;

import java.util.Map;

public class ModelService {
    private City currentCity;
    private Map<String, City> cityMap;

    public City defineCity(String cityId, String cityName, String blockChainAccount, float lat, float longt, float radius) {
        Location location = new Location(lat, longt);
        City city = new City(cityId, cityName, blockChainAccount, location, radius);
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
                + " Location-lat: " + city.getLocation().getLat() + " Location-longt: " + city.getLocation().getLongt() + " radius: " + city.getRadius());
    }


}
