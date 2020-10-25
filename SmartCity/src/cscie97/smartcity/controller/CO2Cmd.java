package cscie97.smartcity.controller;

import cscie97.smartcity.model.*;

public class CO2Cmd implements Command {


    private Event event;
    private City city;
    private String co2level;

    public CO2Cmd(Event event) {
        this.event = event;
        this.city = event.getCity();
        this.co2level = event.getValue();
    }

    @Override
    public void execute() {
        if (co2level.equals("CO2 level over 1000")) {
            co2high();
        } else if (co2level.equals("CO2 level under 1000")) {
            co2ok();
        }
    }

    public void co2high() {

    }

    public void co2ok() {

    }
}
