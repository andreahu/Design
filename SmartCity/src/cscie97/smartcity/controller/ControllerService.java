package cscie97.smartcity.controller;

import cscie97.smartcity.model.Event;

import java.util.ArrayList;

public class ControllerService implements Observer {
    private Subject subject;


    public ControllerService(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        checkEvent(subject.getEvents());
        System.out.println("ControllerService updated.");
    }

    public void checkEvent(ArrayList<Event> events) {
        Command c = createCommand(events.get(events.size() - 1));
        c.execute();
    }


    public Command createCommand(Event event) {
        Command command = null;

        switch (event.getValue()) {
            case "fire":
            case "flood":
            case "earthquake":
            case "severe weather":
            case "traffic_accident":
                command = new EmergencyCmd(event);
                break;
            case "littering":
                command = new LittlerCmd(event);
                break;
            case "broken_glass_sound":
                command = new BrokenGlassCmd(event);
                break;
            case "person_seen":
                command = new PersonSeenCmd(event);
                break;
            case "can you help me find my child":
                command = new MissingChild(event);
                break;
            case "Vehicle parked for 1 hour.":
                command = new ParkingCmd(event);
                break;
            case "Does this bus go to central square?":
                command = new BusRouteCmd(event);
                break;
            case "Person boards bus":
                command = new BoardBusCmd(event);
                break;


        }

        return command;

    }


    //getters and setters

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
