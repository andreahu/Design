package cscie97.smartcity.controller;

import cscie97.smartcity.model.*;

import java.util.Map;

/**
 * The following actions are going to be taken when this cmd is called
 * update the robot to : "clean up broken glass at a location
 */
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
    /**
     * update the robot to : "clean up broken glass at a location"
     */
    public void execute() {
        Robot robot = getOneRobot();
        robot.setActivity("clean up broken glass at lat " + lat + ", long " + lon);
        System.out.println("Robot has taken action for the broken glass");
    }


    /**
     * @return A robot to do the work
     */
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
