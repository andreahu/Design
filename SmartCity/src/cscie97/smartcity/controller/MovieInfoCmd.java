package cscie97.smartcity.controller;

import cscie97.smartcity.model.*;

/**
 * The following actions are going to be taken when this cmd is called
 * Speaker: “Casablanca is showing at 9 pm ”
 * Display: “https://en.wikipedia.org/wiki/Casabl anca_(film)#/media/File:Casablanca Poster-Gold.jpg”
 */
public class MovieInfoCmd implements Command {

    private Event event;
    private Kiosk kiosk;
    private String person_id;

    public MovieInfoCmd(Event event) {
        this.event = event;
        this.kiosk = (Kiosk) event.getDevice();
        this.person_id = event.getSubject();
    }

    @Override
    public void execute() {
        kiosk.getSpeaker().setValue("Casablanca is showing at 9 pm");
        kiosk.setImageLink("https://en.wikipedia.org/wiki/Casabl anca_(film)#/media/File:Casablanca Poster-Gold.jpg");

        System.out.println("Action took by speaker and Kiosk");
    }
}
