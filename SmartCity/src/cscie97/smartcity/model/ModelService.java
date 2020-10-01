package cscie97.smartcity.model;

import java.util.Map;

public class ModelService {
    private City currentCity;
    private Map<String, City> cityMap;

    public void defineCity(String cityId, String cityName, String blockChainAccount, float lat, float longt, float radius){
        Location location = new Location(lat, longt);

        City city = new City(cityId, cityName, blockChainAccount, location, radius);


    }






}
