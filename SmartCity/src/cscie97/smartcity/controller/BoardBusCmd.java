package cscie97.smartcity.controller;

import com.cscie97.ledger.Account;
import com.cscie97.ledger.Ledger;
import com.cscie97.ledger.LedgerException;
import com.cscie97.ledger.Transaction;
import cscie97.smartcity.model.*;

/**
 * When someone has board the bus
 * Bus Speaker: “hello, good to see you <person_id>”
 * If the person is a resident and has a positive account balance, charge persons account for the rate of the bus.
 */
public class BoardBusCmd implements Command {

    private Event event;
    private City city;
    private Vehicle bus;
    private String person_id;
    private Ledger ledger;

    public BoardBusCmd(Event event, Ledger l) {
        this.event = event;
        this.city = event.getCity();
        this.bus = (Vehicle) event.getDevice();
        this.person_id = event.getSubject();
        this.ledger = l;
    }

    /**
     * Bus Speaker: “hello, good to see you <person_id>”
     * If the person is a resident and has a positive account balance, charge persons account for the rate of the bus.
     */
    @Override
    public void execute() {

        int busRate = bus.getFee();
        bus.getSpeaker().setValue("hello, good to see you " + person_id);
        System.out.println("Person " + person_id + " is boarded.");

        Person p = city.getPersonMap().get(person_id);
        if (p instanceof Resident) {
            System.out.println("Person " + person_id + " is resident and need to be charged for bus rate: $" + busRate);
            charge(busRate, person_id);
        }

    }


    /**
     * @param amount:the amount to be charged
     * @param person_id: the person to be charged
     */
    public void charge(int amount, String person_id) {
        Resident resident = (Resident) city.getPersonMap().get(person_id);
        String resident_account = resident.getBlockChainAccountId();
        Account payer = ledger.getAccount(resident_account);
        Account receiver_master = ledger.getMasterAccount();
        String transaction_id = "boardBus_" + person_id;
        Transaction transaction = new Transaction(transaction_id, amount, 0, "Bus Boarding Charge", payer, receiver_master);
        try {
            ledger.processTransaction(transaction);
            System.out.println("This person is charged for littering");
        } catch (LedgerException e) {
            System.out.println("This person doesn't have enough balance");
        }
        System.out.println("transaction processed for transactionID: " + transaction_id);
    }
}
