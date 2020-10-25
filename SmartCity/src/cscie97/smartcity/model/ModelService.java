package cscie97.smartcity.model;

import cscie97.smartcity.controller.Observer;
import cscie97.smartcity.controller.Subject;

import java.util.ArrayList;
import java.util.Map;

public class ModelService implements Subject {


    private ArrayList<Observer> observers;
    private ArrayList<Event> events;

    private Map<String, City> cityMap;
    private Map<String, Person> masterPersonMap;
    public static float FLOAT_EMPTY = Float.MAX_VALUE;

    public ModelService(Map<String, City> cityMap, Map<String, Person> masterPersonMap) {
        this.cityMap = cityMap;
        this.masterPersonMap = masterPersonMap;
        observers = new ArrayList<>();
        events = new ArrayList<>();
    }

    public void addEvent(Event e) {
        events.add(e);
        notifyObservers();
    }


    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }

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

    /**
     * find the city by the location
     *
     * @param lat
     * @param lon
     * @return
     */
    public City findCity(float lat, float lon) {
        for (City c : cityMap.values()) {
            if (withinCity(c.getLat(), c.getlon(), c.getRadius(), lat, lon)) {
                return c;
            }
        }
        return null;
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
    public StreetSign defineStreetSign(String cityId, String deviceId, float lat, float lon, String enabled, String text) {
        City theCity = cityMap.get(cityId);
        StreetSign streetSign = new StreetSign(theCity, deviceId, lat, lon, enabled, text);
        theCity.getDeviceMap().put(deviceId, streetSign);
        System.out.println("Street sign defined");
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
        System.out.println("Street sign updated");
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
    public Kiosk defineKiosk(String cityId, String deviceId, float lat, float lon, String enabled, String imageLink) {
        City theCity = cityMap.get(cityId);
        Kiosk kiosk = new Kiosk(theCity, deviceId, lat, lon, enabled, imageLink);
        theCity.getDeviceMap().put(deviceId, kiosk);
        System.out.println("kiosk defined");
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
    public void updateKiosk(String cityId, String deviceId, String enabled, String imageLink) {
        Device kiosk = cityMap.get(cityId).getDeviceMap().get(deviceId);
        if (enabled != null) kiosk.setEnabled(enabled);
        if (imageLink != null) ((Kiosk) kiosk).setImageLink(imageLink);
        System.out.println("kiosk updated");
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
    public StreetLight defineStreetLight(String cityId, String deviceId, float lat, float lon, String enabled, String brightness) {
        City theCity = cityMap.get(cityId);
        StreetLight streetLight = new StreetLight(theCity, deviceId, lat, lon, enabled, brightness);
        theCity.getDeviceMap().put(deviceId, streetLight);
        System.out.println("street light defined");
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
    public void updateStreetLight(String cityId, String deviceId, String enabled, String brightness) {
        Device streetLight = cityMap.get(cityId).getDeviceMap().get(deviceId);
        if (enabled != null) ((StreetLight) streetLight).setEnabled(enabled);
        if (brightness != null) ((StreetLight) streetLight).setBrightness(brightness);
        System.out.println("street light updated");
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
    public ParkingSpace defineParkingSpace(String cityId, String deviceId, float lat, float lon, String enabled, int rate) {
        City theCity = cityMap.get(cityId);
        ParkingSpace parkingSpace = new ParkingSpace(theCity, deviceId, lat, lon, enabled, rate);
        theCity.getDeviceMap().put(deviceId, parkingSpace);
        System.out.println("parking space defined");
        return parkingSpace;
    }

    /**
     * update parking space config
     *
     * @param cityId
     * @param deviceId
     * @param rate
     */
    public void updateParkingSpace(String cityId, String deviceId, int rate) {
        Device parkingSpace = cityMap.get(cityId).getDeviceMap().get(deviceId);
        ((ParkingSpace) parkingSpace).setRate(rate);
        System.out.println("parking space updated");
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
    public Robot defineRobot(String cityId, String deviceId, float lat, float lon, String enabled, String activity) {
        City theCity = cityMap.get(cityId);
        Robot robot = new Robot(theCity, deviceId, lat, lon, enabled, activity);
        theCity.getDeviceMap().put(deviceId, robot);
        System.out.println("robot defined");
        return robot;
    }

    public void updateRobot(String cityId, String deviceId, float lat, float lon, String activity) {
        Device robot = cityMap.get(cityId).getDeviceMap().get(deviceId);
        if (lat != FLOAT_EMPTY) robot.setLat(lat);
        if (lon != FLOAT_EMPTY) robot.setLon(lon);
        if (activity != null) ((Robot) robot).setActivity(activity);
        System.out.println("robot updated");
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
    public Vehicle defineVehicle(String cityId, String deviceId, float lat, float lon, String enabled, String type, String activity, String capacity, int fee) {
        City theCity = cityMap.get(cityId);
        Vehicle vehicle = new Vehicle(theCity, deviceId, lat, lon, enabled, type, activity, capacity, fee);
        theCity.getDeviceMap().put(deviceId, vehicle);
        System.out.println("vehicle defined");
        return vehicle;
    }

    public void updateVehicle(String cityId, String deviceId, float lat, float lon, String enabled, String activity) {
        Device vehicle = cityMap.get(cityId).getDeviceMap().get(deviceId);
        if (lat != FLOAT_EMPTY) vehicle.setLat(lat);
        if (lon != FLOAT_EMPTY) vehicle.setLon(lon);
        if (enabled != null) vehicle.setEnabled(enabled);
        if (activity != null) ((Vehicle) vehicle).setActivity(activity);
        System.out.println("vehicle defined");
        return;
    }

    /**
     * print device IDs in a city
     *
     * @param cityId
     */
    public void showDevice(String cityId) {
        Map<String, Device> map = cityMap.get(cityId).getDeviceMap();
        System.out.println("For City ID: " + cityId + " This is a list of the devices IDs in the city: ");
        System.out.println(map.keySet());
    }

    /**
     * print info for a device
     *
     * @param cityId
     * @param deviceId
     */
    public void showDevice(String cityId, String deviceId) {
        Device device = cityMap.get(cityId).getDeviceMap().get(deviceId);
        System.out.println("For City ID: " + cityId + " Device ID: " + device.getDeviceId() + " Lat and Lon: " + device.getLat() + device.getLon()
                + " the class of the Device is: " + device.getClass());
    }


    public void createSensorEvent(String cityId, String deviceId, String type, String value, String subject) {
        City city = cityMap.get(cityId);
        Device device = city.getDeviceMap().get(deviceId);
        Sensor sensor = device.getSensorMap().get(type);
        sensor.setValue(value);

        Event event = new Event(type, value, sensor);
        device.setLatestEvent(event);
        if (subject != null) {
            device.getLatestEvent().setSubject(subject);
        }
        System.out.println("sensor event created");
        // Notify observer.
        this.addEvent(event);
    }

    /**
     * add value into the sensor related attributes of a device and print out the information
     *
     * @param cityId
     * @param deviceId
     * @param type
     * @param value
     */
    public void createSensorOutput(String cityId, String deviceId, String type, String value) {
        Device device = cityMap.get(cityId).getDeviceMap().get(deviceId);
//        Event event = device.getLatestEvent();
        System.out.println("City: " + cityId + " DeviceID: " + deviceId + " SensorType: " + type + " Value: " + value);
    }

    /**
     * print out the information for the sensor message
     *
     * @param cityId
     * @param sensorType
     * @param sensorValue
     */
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
        //find the person's city and add him into the city's personMap
        City city = findCity(lat, lon);
        city.getPersonMap().put(personId, resident);
        System.out.println("Resident defined");
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
        System.out.println("Resident updated");
    }

    /**
     * create Visitor object and add to map
     *
     * @param personId
     * @param biometricId
     * @param lat
     * @param lon
     */
    public Visitor defineVisitor(String personId, String biometricId, float lat, float lon) {
        Visitor visitor = new Visitor(personId, biometricId, lat, lon);
        masterPersonMap.put(personId, visitor);
        City city = findCity(lat, lon);
        city.getPersonMap().put(personId, visitor);
        System.out.println("Visitor defined");
        return visitor;
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
        Visitor visitor = (Visitor) masterPersonMap.get(personId);
        if (biometricId != null) visitor.setBiometricId(biometricId);
        if (lat != FLOAT_EMPTY) visitor.setLat(lat);
        if (lon != FLOAT_EMPTY) visitor.setLon(lon);
        System.out.println("Visitor updated");
    }

    /**
     * print out the information for the person
     *
     * @param personId
     */
    public void showPerson(String personId) {
        Person p = masterPersonMap.get(personId);
        System.out.println("Person ID: " + p.getPersonId() + " Bio_Metric: " + p.getBiometricId() + " Lat and Lon: " + p.getLat() + "，" + p.getLon()
                + " the class of the Person is: " + p.getClass());
    }


    //getters and setters

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}
