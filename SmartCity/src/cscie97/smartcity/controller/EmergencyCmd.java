package cscie97.smartcity.controller;

import cscie97.smartcity.model.*;

import java.util.ArrayList;
import java.util.Map;

public class EmergencyCmd implements Command {
    City city;
    String emergency_type; //emergency_type
    private float lat;
    private float lon;
    Event event;

    public EmergencyCmd(City city, Event event, float lat, float lon) {
        this.city = city;
        this.emergency_type = event.getValue();
        this.lat = lat;
        this.lon = lon;
        this.event = event;
    }

    @Override
    public void execute() {
        if (emergency_type == "traffic_accident") {
            emergency2_execute();
        } else {
            emergency1_execute();
        }

    }


    public void emergency1_execute() {
        city.setAnnouncement("There is a " + emergency_type + " in " + city.getCityId() + ", please find shelter immediately");

        Map<String, Device> deviceMap = city.getDeviceMap();
        ArrayList<Robot> robots = new ArrayList<>();
        for (Device d : deviceMap.values()) {
            if (d instanceof Robot) {
                robots.add((Robot) d);
            }
        }

        int robotCount = robots.size();
        for (int i = 0; i <= robotCount / 2; i++) {
            robots.get(i).setActivity("address " + emergency_type + " at lat " + lat + "long" + lon);
        }
        for (int i = (robotCount / 2) + 1; i < robotCount; i++) {
            robots.get(i).setActivity("Help people find shelter");
        }
    }

    public void emergency2_execute() {


        //TODO: add code
        System.out.println("pending implementing emergency2");
    }

}
