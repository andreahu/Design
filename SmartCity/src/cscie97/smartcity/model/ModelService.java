package cscie97.smartcity.model;

import java.util.Map;

public class ModelService {

    private Map<String, City> cityMap;
    private Map<String, Person> masterPersonMap;

    public static float FLOAT_EMPTY = Float.MAX_VALUE;

    public ModelService(Map<String, City> cityMap, Map<String, Person> masterPersonMap) {
        this.cityMap = cityMap;
        this.masterPersonMap = masterPersonMap;
    }

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
        System.out.println("City defined. City ID: " + city.getCityId());
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

    /**
     * create robot object
     *
     * @param cityId
     * @param deviceId
     * @param lat
     * @param lon
     * @param enabled
     * @param activity
     * @return robot
     */
    public Robot defineRobot(String cityId, String deviceId, float lat, float lon, Boolean enabled, String activity) {
        Robot robot = new Robot(deviceId, lat, lon, enabled, activity);
        City theCity = cityMap.get(cityId);
        theCity.getDeviceMap().put(deviceId, robot);
        return robot;
    }

    public void updateRobot(String cityId, String deviceId, float lat, float lon, String activity) {
        Device robot = cityMap.get(cityId).getDeviceMap().get(deviceId);
        if (lat != FLOAT_EMPTY) robot.setLat(lat);
        if (lon != FLOAT_EMPTY) robot.setLon(lon);
        if (activity != null) ((Robot) robot).setActivity(activity);
    }

    /**
     * create vehicle object
     *
     * @param cityId
     * @param deviceId
     * @param lat
     * @param lon
     * @param enabled
     * @param type
     * @param activity
     * @param capacity
     * @param fee
     * @return vehicle object
     */
    public Vehicle defineVehicle(String cityId, String deviceId, float lat, float lon, Boolean enabled, String type, String activity, int capacity, int fee) {
        Vehicle vehicle = new Vehicle(deviceId, lat, lon, enabled, type, activity, capacity, fee);
        City theCity = cityMap.get(cityId);
        theCity.getDeviceMap().put(deviceId, vehicle);
        return vehicle;
    }

    public void updateVehicle(String cityId, String deviceId, float lat, float lon, Boolean enabled, String activity) {
        Device vehicle = cityMap.get(cityId).getDeviceMap().get(deviceId);
        if (lat != FLOAT_EMPTY) vehicle.setLat(lat);
        if (lon != FLOAT_EMPTY) vehicle.setLon(lon);
        if (enabled != null) vehicle.setEnabled(enabled);
        if (activity != null) ((Vehicle) vehicle).setActivity(activity);
    }

    /**
     * print device IDs in a city
     *
     * @param cityId
     */
    public void showDevice(String cityId) {
        Map<String, Device> map = cityMap.get(cityId).getDeviceMap();
        System.out.println("For City ID: " + cityId + " This is a list of the devices IDs in the city: " + map.keySet());
    }

    /**
     * print info for a device
     *
     * @param cityId
     * @param deviceId
     */
    public void showDevice(String cityId, String deviceId) {
        Device device = cityMap.get(cityId).getDeviceMap().get(deviceId);
        System.out.println("For City ID: " + cityId + "Device ID: " + device.getDeviceId() + " Lat and Lon: " + device.getLat() + device.getLon()
                + " the class of the Device is: " + device.getClass());
    }


    public void createSensorEvent(String cityId, String deviceId, String sensorType, String sensorValue, String sensorSubject) {
        Device device = cityMap.get(cityId).getDeviceMap().get(deviceId);
        device.setSensorType(sensorType);
        device.setSensorValue(sensorValue);
        device.setSensorSubject(sensorSubject);
    }

    public void createSensorOutput(String cityId, String deviceId, String sensorType, String sensorValue) {
        Device device = cityMap.get(cityId).getDeviceMap().get(deviceId);
        device.setSensorType(sensorType);
        device.setSensorValue(sensorValue);
        System.out.println("City: " + cityId + " DeviceID: " + deviceId + " SensorType: " + sensorType + " Value: " + sensorValue);
    }

    public void createSensorOutput(String cityId, String sensorType, String sensorValue) {
        System.out.println("For all the devices in City: " + cityId + ", output for sensor type: " + sensorType + " Value: " + sensorValue);
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
    public void updateVisitor(String personId, String biometricId, float lat, float lon) {
        Resident resident = (Resident) masterPersonMap.get(personId);
        if (biometricId != null) resident.setBiometricId(biometricId);
        if (lat != FLOAT_EMPTY) resident.setLat(lat);
        if (lon != FLOAT_EMPTY) resident.setLon(lon);
    }
}
