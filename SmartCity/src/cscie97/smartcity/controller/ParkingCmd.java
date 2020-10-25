package cscie97.smartcity.controller;

import cscie97.smartcity.model.*;
import com.cscie97.ledger.*;

public class ParkingCmd implements Command {

    private Event event;
    private City city;
    private String city_device;

    public ParkingCmd(Event event) {
        this.event = event;
        this.city = event.getCity();
        this.city_device = event.getSubject();
    }

    @Override
    public void execute() {
        Device vehicle = getVehicle();
        charge(50, vehicle.getDeviceId());
        System.out.println("Vehicle " + vehicle.getDeviceId() + " was charged for 1 hour");

    }

    public Device getVehicle() {
        String[] cityDevicePair = city_device.split(":");
        String device_id = cityDevicePair[1];
        Device d = city.getDeviceMap().get(device_id);
        return d;
    }

    //@TODO: Charge the vehicle account for parking for 1 hour.
    public void charge(int amount, String vehicle_id) {
//        Account payer = ledger.getAccount(vehicle_id);
//        Account receiver_master = ledger.getMasterAccount();
//        String transaction_id = "litterCharge_1";
//        Transaction transaction = new Transaction(transaction_id, amount, 0, "Parking Charge", payer, receiver_master);
//        String transactionId = ledger.processTransaction(transaction);
//        System.out.println("transaction processed for transactionID: " + transactionId);
    }

}
