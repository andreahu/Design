package cscie97.smartcity.controller;

import cscie97.smartcity.model.*;

import java.util.Map;

public class BrokenGlassCmd implements Command {
    private Event event;
    private City city;
    private Device device;
    private float lat;
    private float lon;


    public BrokenGlassCmd(Event e) {
        this.event = e;
        this.city = event.getCity();
        this.device = event.getDevice();
        this.lat = event.getLat();
        this.lon = event.getLon();
    }

    @Override
    public void execute() {
        Robot robot = getOneRobot();
        robot.setActivity("clean up broken glass at lat " + lat + ", long " + lon);
        System.out.println("Robot has taken action for the broken glass");
    }


    public Robot getOneRobot() {
        Map<String, Device> deviceMap = city.getDeviceMap();
        for (Device d : deviceMap.values()) {
            if (d instanceof Robot) {
                return (Robot) d;
            }
        }
        return null;
    }
}
