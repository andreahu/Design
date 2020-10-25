package cscie97.smartcity.controller;

import cscie97.smartcity.model.Device;
import cscie97.smartcity.model.Event;
import cscie97.smartcity.model.Vehicle;

public class BusRouteCmd implements Command {
    private Vehicle bus;

    public BusRouteCmd(Event e) {
        this.bus = (Vehicle) e.getDevice();
    }

    @Override
    public void execute() {
        bus.getSpeaker().setValue("Yes, this bus goes to Central Square");
        System.out.println("Speaker answered: " + bus.getSpeaker().getValue());
    }
}
