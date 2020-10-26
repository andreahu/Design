package cscie97.smartcity.controller;

import com.cscie97.ledger.*;
import cscie97.smartcity.model.*;

import java.util.Map;

public class LittlerCmd implements Command {

    private Event event;
    private City city;
    private Device device;
    private String person_id;
    private float lat;
    private float lon;

    private Ledger ledger;

    public LittlerCmd(Event event, Ledger l) {
        this.event = event;
        this.city = event.getCity();
        this.device = event.getDevice();
        this.person_id = event.getSubject();
        this.lat = event.getLat();
        this.lon = event.getLon();
        this.ledger = l;
    }

    @Override
    public void execute() {
        device.getSpeaker().setValue("Please do not litter");
        Robot robot = getOneRobot();
        robot.setActivity("clean garbage at lat " + lat + " long " + lon);
        System.out.println("speaker and robot have taken action");

        Person person = city.getPersonMap().get(person_id);
        charge(50, person_id);
    }


    public Robot getOneRobot() {
        Map<String, Device> deviceMap = city.getDeviceMap();
        for (Device d : deviceMap.values()) {
            if (d instanceof Robot) {
                return (Robot) d;
            }
        }
        return null;
    }


    public void charge(int amount, String person_id) {
        Resident resident = (Resident) city.getPersonMap().get(person_id);
        String resident_account = resident.getBlockChainAccountId();
        Account payer = ledger.getAccount(resident_account);
        Account receiver_master = ledger.getMasterAccount();
        String transaction_id = "litterCharge_" + person_id;
        Transaction transaction = new Transaction(transaction_id, amount, 0, "Litter Charge", payer, receiver_master);
        try {
            ledger.processTransaction(transaction);
            System.out.println("This person is charged for littering");
        } catch (LedgerException e) {
            System.out.println("This person doesn't have enough balance");
        }
        System.out.println("transaction processed for transactionID: " + transaction_id);
    }

}
