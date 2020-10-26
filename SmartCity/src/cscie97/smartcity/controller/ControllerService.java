package cscie97.smartcity.controller;

import com.cscie97.ledger.Ledger;
import cscie97.smartcity.model.Event;

import java.util.ArrayList;

/**
 * This class is responsible for monitoring the devices and people within the city, as well as generating actions to control the devices based on rules, in response to status updates from the devices.
 * This class also connects with the ledger service for financial purpose
 */
public class ControllerService implements Observer {
    private Subject subject;
    private int co2highCount;
    private int co2okCount;
    private Ledger ledger;

    public ControllerService(Subject subject, Ledger l) {
        this.subject = subject;
        this.subject.attach(this);
        this.co2highCount = 0;
        this.co2okCount = 0;
        this.ledger = l;
    }

    /**
     * monitors subject and update itself according to the events happen in subject
     */
    @Override
    public void update() {
        checkEvent(subject.getEvents());
        System.out.println("ControllerService updated.");
    }

    /**
     * Check the event list in this class and call create command method
     *
     * @param events: events list in this class
     *                Catch ControllerServiceException
     */
    public void checkEvent(ArrayList<Event> events) {
        try {
            Command c = createCommand(events.get(events.size() - 1));
            if (c != null) {
                c.execute();
            }
        } catch (ControllerServiceException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Create the command that process the execution of the next step
     *
     * @param event: event triggered by the sensor
     * @throws ControllerServiceException
     * @return: the command that process the execution of the next step
     */
    public Command createCommand(Event event) throws ControllerServiceException {
        Command command = null;

        if (event.getType().equals("co2meter")) {
            int co2level = Integer.parseInt(event.getValue());

            if (co2level >= 10000 || co2level <= 100) {
                throw new ControllerServiceException("co2meter broken", "impossible value");
            }

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
            if (event.getValue().equals(" ")) {
                throw new ControllerServiceException("Event Value issue", "no value for event");
            }
            switch (event.getValue()) {
                case "fire":
                case "flood":
                case "earthquake":
                case "severe weather":
                case "traffic_accident":
                    command = new EmergencyCmd(event);
                    break;
                case "littering":
                    command = new LitterCmd(event, ledger);
                    break;
                case "broken_glass_sound":
                    command = new BrokenGlassCmd(event);
                    break;
                case "person_seen":
                    command = new PersonSeenCmd(event);
                    break;
                case "can you help me find my child":
                    command = new MissingChildCmd(event);
                    break;
                case "Vehicle parked for 1 hour.":
                    command = new ParkingCmd(event, ledger);
                    break;
                case "Does this bus go to central square?":
                    command = new BusRouteCmd(event);
                    break;
                case "Person boards bus":
                    command = new BoardBusCmd(event, ledger);
                    break;
                case "what movies are showing tonight?":
                    command = new MovieInfoCmd(event);
                    break;
                case "reserve 3 seats for the 9 pm showing of Casablanca.":
                    command = new MovieReservationCmd(event, ledger);
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
