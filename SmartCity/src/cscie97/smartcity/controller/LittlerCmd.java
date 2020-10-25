package cscie97.smartcity.controller;

import cscie97.smartcity.model.*;

import java.util.ArrayList;
import java.util.Map;

public class LittlerCmd implements Command {

    private Event event;
    private City city;
    private Device device;
    private String person_id;
    private float lat;
    private float lon;

    public LittlerCmd(Event event) {
        this.event = event;
        this.city = event.getCity();
        this.device = event.getDevice();
        this.person_id = event.getSubject();
        this.lat = event.getLat();
        this.lon = event.getLon();
    }

    @Override
    public void execute() {
        device.getSpeaker().setValue("Please do not litter");
        Robot robot = getOneRobot();
        robot.setActivity("clean garbage at lat " + lat + " long " + lon);
        System.out.println("speaker and robot have taken action");

        Person person = city.getPersonMap().get(person_id);


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
