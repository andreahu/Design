package cscie97.smartcity.controller;

import cscie97.smartcity.model.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * This cmd does the following:
 * If high CO2 level(>=1000) reported by more than 3 devices within a city, this cmd will be triggered:
 * Then: Disable all cars in the city.
 * If normal CO2 level(<1000) reported by more than 3 devices within a city, this cmd will be triggered:
 * Then: Enable all cars in the city.
 */
public class CO2Cmd implements Command {


    private Event event;
    private City city;
    private int co2level;
    private ArrayList<Vehicle> cars;

    public CO2Cmd(Event event) {
        this.event = event;
        this.city = event.getCity();
        this.co2level = Integer.parseInt(event.getValue());
    }

    @Override
    /**
     * If high CO2 level(>=1000) reported by more than 3 devices within a city, this method will be triggered:
     * Then: Disable all cars in the city.
     * If normal CO2 level(<1000) reported by more than 3 devices within a city, this method will be triggered:
     *  Then: Enable all cars in the city.
     */
    public void execute() {
        if (co2level >= 1000) {

            co2high();
        } else if (co2level < 1000) {
            co2ok();
        }
    }

    /**
     * Disable all cars in the city
     */
    public void co2high() {
        //Disable all cars in the city
        this.cars = getAllCars();
        disableAllCars(cars);
        System.out.println("All cars in the city disabled");
    }

    /**
     * Enable all cars in the city
     */
    public void co2ok() {
        //Enable all cars in the city
        this.cars = getAllCars();
        enableAllCars(cars);
        System.out.println("All cars in the city enabled");
    }

    /**
     * @return all the cars in the city
     */
    public ArrayList<Vehicle> getAllCars() {
        Map<String, Device> deviceMap = city.getDeviceMap();
        ArrayList<Vehicle> cars = new ArrayList<>();
        for (Device d : deviceMap.values()) {
            if (d instanceof Vehicle) {
                cars.add((Vehicle) d);
            }
        }
        return cars;
    }

    public void disableAllCars(ArrayList<Vehicle> cars) {
        for (Vehicle v : cars) {
            v.setEnabled("false");
        }
    }

    public void enableAllCars(ArrayList<Vehicle> cars) {
        for (Vehicle v : cars) {
            v.setEnabled("true");
        }
    }
}
