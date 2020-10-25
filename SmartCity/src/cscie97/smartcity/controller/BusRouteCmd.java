package cscie97.smartcity.controller;

import cscie97.smartcity.model.Device;
import cscie97.smartcity.model.Event;

public class BusRouteCmd implements Command {
    private Device device;

    public BusRouteCmd(Event e) {
        this.device = e.getDevice();
    }

    @Override
    public void execute() {
        device.getSpeaker().setValue("Yes, this bus goes to Central Square.");

        System.out.println("Speaker answered: " + device.getSpeaker().getValue());
    }
}
