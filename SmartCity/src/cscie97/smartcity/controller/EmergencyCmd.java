package cscie97.smartcity.controller;

import cscie97.smartcity.model.*;

import java.util.ArrayList;
import java.util.Map;

public class EmergencyCmd implements Command {

    private Event event;
    private City city;
    private Device device;
    private String emergency_type;
    private float lat;
    private float lon;

    public EmergencyCmd(Event event) {
        this.event = event;
        this.city = event.getCity();
        this.device = event.getDevice();
        this.emergency_type = event.getValue();
        this.lat = event.getLat();
        this.lon = event.getLon();
    }

    @Override
    public void execute() {
        if (emergency_type.equals("traffic_accident")) {
            emergency2_execute();
            System.out.println("Action taken for emergency 2");
        } else {
            emergency1_execute();
            System.out.println("Action taken for emergency 1");
        }
    }


    public void emergency1_execute() {
        city.setAnnouncement("There is a " + emergency_type + " in " + city.getCityId() + ", please find shelter immediately");

        ArrayList<Robot> robots = getAllRobots();
        int robotCount = robots.size();
        for (int i = 0; i < robotCount / 2; i++) {
            robots.get(i).setActivity("address " + emergency_type + " at lat " + lat + "long" + lon);
        }
        for (int i = (robotCount / 2); i < robotCount; i++) {
            robots.get(i).setActivity("Help people find shelter");
        }
    }

    public void emergency2_execute() {
        device.setAnnouncement("Stay calm, help is on its way");
        Robot[] nearest2Robots = findNearest2Robots();
        nearest2Robots[0].setActivity("address " + emergency_type + " at lat " + lat + "long" + lon);
        nearest2Robots[1].setActivity("address " + emergency_type + " at lat " + lat + "long" + lon);
    }

    public ArrayList<Robot> getAllRobots() {
        Map<String, Device> deviceMap = city.getDeviceMap();
        ArrayList<Robot> robots = new ArrayList<>();
        for (Device d : deviceMap.values()) {
            if (d instanceof Robot) {
                robots.add((Robot) d);
            }
        }
        return robots;
    }

    public float distance(Event e, Device d) {
        float lat1 = e.getLat();
        float lon1 = e.getLon();
        float lat2 = d.getLon();
        float lon2 = d.getLon();
        float distance = (float) Math.sqrt((Math.pow((lat1 - lat2), 2) + Math.pow((lon1 - lon2), 2)));
        return distance;
    }

    public Robot[] findNearest2Robots() {
        ArrayList<Robot> robots = getAllRobots();
        Robot[] nearest2Robots = new Robot[2];
        float closeDistance0 = -1;
        float closeDistance1 = -1;
        for (Robot r : robots) {
            float distance = distance(event, r);
            if (distance > closeDistance0) {
                nearest2Robots[0] = r;
                closeDistance0 = distance;
            } else if (distance > closeDistance1) {
                nearest2Robots[1] = r;
                closeDistance1 = distance;
            }
        }
        return nearest2Robots;
    }


}
