package cscie97.smartcity.controller;

import com.cscie97.ledger.Ledger;
import cscie97.smartcity.model.Event;

import java.util.ArrayList;

public class ControllerService implements Observer {
    private Subject subject;
    private int co2highCount;
    private int co2okCount;
    private Ledger ledger;

    public ControllerService(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
        this.co2highCount = 0;
        this.co2okCount = 0;
    }

    @Override
    public void update() {
        checkEvent(subject.getEvents());
        System.out.println("ControllerService updated.");
    }

    public void checkEvent(ArrayList<Event> events) {
        Command c = createCommand(events.get(events.size() - 1));
        if (c != null) {
            c.execute();
        }
    }


    public Command createCommand(Event event) {
        Command command = null;

        if (event.getType().equals("co2meter")) {
            int co2level = Integer.parseInt(event.getValue());
            if (co2level >= 1000) {
                this.co2highCount++;
                if (co2highCount == 3) {//If reported by more than 3 devices
                    command = new CO2Cmd(event);
                }
            }
            if (co2level < 1000) {
                co2okCount++;
                if (co2okCount == 3) {//If reported by more than 3 devices
                    command = new CO2Cmd(event);
                    this.co2highCount = 0;
                    this.co2okCount = 0;
                }
            }
        } else {
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
                case "what movies are showing tonight?":
                    command = new MovieInfoCmd(event);
                    break;
                case "reserve 3 seats for the 9 pm showing of Casablanca.":
                    command = new MovieReservationCmd(event);
                    break;
            }
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
