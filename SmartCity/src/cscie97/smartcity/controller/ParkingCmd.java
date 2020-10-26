package cscie97.smartcity.controller;

import cscie97.smartcity.model.*;
import com.cscie97.ledger.*;

public class ParkingCmd implements Command {

    private Event event;
    private City city;
    private String city_device;
    private Ledger ledger;

    public ParkingCmd(Event event, Ledger l) {
        this.event = event;
        this.city = event.getCity();
        this.city_device = event.getSubject();
        this.ledger = l;
    }

    @Override
    public void execute() {
        Vehicle vehicle = (Vehicle) getVehicle();
        charge(50, vehicle);
        System.out.println("Vehicle " + vehicle.getDeviceId() + " was charged for 1 hour");

    }

    public Device getVehicle() {
        String[] cityDevicePair = city_device.split(":");
        String device_id = cityDevicePair[1];
        Device d = city.getDeviceMap().get(device_id);
        return d;
    }

    //@TODO: Charge the vehicle account for parking for 1 hour.
    public void charge(int amount, Vehicle vehicle) {

        String vehicle_account = vehicle.getBlockChainAccountId();
        Account payer = ledger.getAccount(vehicle_account);
        Account receiver_master = ledger.getMasterAccount();
        String transaction_id = "ParkingRate_" + vehicle.getDeviceId();
        Transaction transaction = new Transaction(transaction_id, amount, 0, "Parking Charge", payer, receiver_master);
        try {
            ledger.processTransaction(transaction);
            System.out.println("This vehicle is charged for littering");
        } catch (LedgerException e) {
            System.out.println("This vehicle doesn't have enough balance");
        }
        System.out.println("transaction processed for transactionID: " + transaction_id);
    }
}
