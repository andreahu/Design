package cscie97.smartcity.controller;

import cscie97.smartcity.model.City;
import cscie97.smartcity.model.Device;
import cscie97.smartcity.model.Event;
import cscie97.smartcity.model.Person;

public class PersonSeenCmd implements Command {

    private Event event;
    private City city;
    private Device device;
    private String person_id;
    private float lat;
    private float lon;

    public PersonSeenCmd(Event event) {
        this.event = event;
        this.city = event.getCity();
        this.device = event.getDevice();
        this.person_id = event.getSubject();
        this.lat = event.getLat();
        this.lon = event.getLon();
    }


    @Override
    public void execute() {
        Person person = city.getPersonMap().get(person_id);
        person.setLat(lat);
        person.setLon(lon);

        System.out.println("Location updated for this person. Lat: " + person.getLat() + ", Long: " + person.getLon());

    }
}
