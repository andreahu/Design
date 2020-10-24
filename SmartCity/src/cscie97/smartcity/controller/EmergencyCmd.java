package cscie97.smartcity.controller;

import cscie97.smartcity.model.*;

import java.util.ArrayList;
import java.util.Map;

public class EmergencyCmd implements Command {
    City city;
    Event event; //emergency_type
    private float lat;
    private float lon;


    @Override
    public void execute() {
        city.setAnnouncement("There is a " + event.getValue() + " in " + city.getCityId() + ", please find shelter immediately");

        Map<String, Device> deviceMap = city.getDeviceMap();
        ArrayList<Robot> robots = new ArrayList<>();
        for (Device d : deviceMap.values()) {
            if (d instanceof Robot) {
                robots.add((Robot) d);
            }
        }

        int robotCount = robots.size();
        for (int i = 0; i <= robotCount / 2; i++) {
            robots.get(i).setActivity("address " + event.getValue() + " at lat " + lat + "long" + lon);
        }
        for (int i = (robotCount / 2) + 1; i < robotCount; i++) {
            robots.get(i).setActivity("Help people find shelter");
        }

    }
}
