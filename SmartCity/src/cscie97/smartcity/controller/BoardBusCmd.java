package cscie97.smartcity.controller;

import cscie97.smartcity.model.*;

public class BoardBusCmd implements Command {

    private Event event;
    private City city;
    private Vehicle bus;
    private String person_id;

    public BoardBusCmd(Event event) {
        this.event = event;
        this.city = event.getCity();
        this.bus = (Vehicle) event.getDevice();
        this.person_id = event.getSubject();
    }

    @Override
    public void execute() {

        int busRate = bus.getFee();
        bus.getSpeaker().setValue("hello, good to see you " + person_id);
        System.out.println("Person " + person_id + " is boarded.");

        Person p = city.getPersonMap().get(person_id);
        if (p instanceof Resident) {
            System.out.println("Person " + person_id + " is resident and need to be charged for bus rate: $" + busRate);
        }
        
    }


    public void charge(int amount, String vehicle_id) {

    }
}
