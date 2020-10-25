package cscie97.smartcity.controller;

import cscie97.smartcity.model.*;

public class MovieReservationCmd implements Command {

    private Event event;
    private City city;
    private Kiosk kiosk;
    private String person_id;

    public MovieReservationCmd(Event event) {
        this.event = event;
        this.city = event.getCity();
        this.kiosk = (Kiosk) event.getDevice();
        this.person_id = event.getSubject();
    }

    @Override
    public void execute() {
        Person p = city.getPersonMap().get(person_id);
        if (p instanceof Resident) {
            System.out.println("Person " + person_id + " is resident");
        }

    }


    /**
     * If the person has a positive account balance, charge the person 10 units
     *
     * @param amount:    the amount to charge
     * @param person_id: the person to be charged
     */
    public void charge(int amount, String person_id) {

    }
}
