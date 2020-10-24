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
        //@TODO
    }


    public Command createCommand(Event e) {
        Command c;

        switch (e.getValue()) {
            case "fire":
            case "flood":
            case "earthquake":
            case "severe weather":
            case "traffic_accident":
//                c = new EmergencyCmd()
                break;


        }

        return c;

    }


    //getters and setters

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
