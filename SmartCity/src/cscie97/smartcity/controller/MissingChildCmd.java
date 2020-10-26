package cscie97.smartcity.controller;

import cscie97.smartcity.model.*;

import java.util.Map;

/**
 * The following actions taken for this cmd
 * locate person <person_id>
 * speaker: “person <person_id> is at lat <lat> long <long>, a robot is retrieving now, stay where you are."
 * Robot: “retrieve person <person_id> and bring to lat <lat> long <long> of microphone.
 */
public class MissingChildCmd implements Command {

    private Event event;
    private City city;
    private Device device;
    private String person_id;
    private float lat;
    private float lon;

    public MissingChildCmd(Event event) {
        this.event = event;
        this.city = event.getCity();
        this.device = event.getDevice();
        this.person_id = event.getSubject();
        this.lat = event.getLat();
        this.lon = event.getLon();
    }

    @Override
    /**
     * locate person
     * speaker: “person <person_id> is at lat <lat> long <long>, a robot is retrieving now, stay where you are."
     * Robot: “retrieve person <person_id> and bring to lat <lat> long <long> of microphone.
     */
    public void execute() {

        Person person = city.getPersonMap().get(person_id);
        device.getSpeaker().setValue("Person " + person_id + " is at lat " + person.getLat()
                + " long " + person.getLon() + ", a robot is retrieving now, stay where you are.");

        Robot robot = getOneRobot();
        robot.setActivity("retrieve person " + person_id + " and bring to " + lat + " long " + lon + "  of microphone.");

        System.out.println("1. Speaker action: Person " + person_id + " is at lat " + person.getLat()
                + " long " + person.getLon() + ", a robot is retrieving now, stay where you are.");
        System.out.println("2. Robot " + robot.getDeviceId() + " activity: Person " + person_id + " is at lat " + person.getLat()
                + " long " + person.getLon() + ", a robot is retrieving now, stay where you are.");
    }

    /**
     * @return a robot in the city
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
