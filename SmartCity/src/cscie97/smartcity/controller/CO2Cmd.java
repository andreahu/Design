package cscie97.smartcity.controller;

import cscie97.smartcity.model.*;

import java.util.ArrayList;
import java.util.Map;

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
    public void execute() {
        if (co2level >= 1000) {

            co2high();
        } else if (co2level >= 1000) {
            co2ok();
        }
    }

    public void co2high() {
        //Disable all cars in the city
        this.cars = getAllCars();
        disableAllCars(cars);
        System.out.println("All cars in the city disabled");
    }

    public void co2ok() {
        //Enable all cars in the city
        this.cars = getAllCars();
        enableAllCars(cars);
        System.out.println("All cars in the city enabled");
    }

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
