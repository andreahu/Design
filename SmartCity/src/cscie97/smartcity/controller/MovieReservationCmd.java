package cscie97.smartcity.controller;

import com.cscie97.ledger.Account;
import com.cscie97.ledger.Ledger;
import com.cscie97.ledger.LedgerException;
import com.cscie97.ledger.Transaction;
import cscie97.smartcity.model.*;

public class MovieReservationCmd implements Command {

    private Event event;
    private City city;
    private Kiosk kiosk;
    private String person_id;
    private Ledger ledger;

    public MovieReservationCmd(Event event, Ledger l) {
        this.event = event;
        this.city = event.getCity();
        this.kiosk = (Kiosk) event.getDevice();
        this.person_id = event.getSubject();
        this.ledger = l;
    }

    @Override
    public void execute() {
        Person p = city.getPersonMap().get(person_id);
        if (p instanceof Resident) {
            System.out.println("Person " + person_id + " is resident");
        }
        charge(10, person_id);

    }


    /**
     * If the person has a positive account balance, charge the person 10 units
     *
     * @param amount:    the amount to charge
     * @param person_id: the person to be charged
     */
    public void charge(int amount, String person_id) {
        Resident resident = (Resident) city.getPersonMap().get(person_id);
        String resident_account = resident.getBlockChainAccountId();
        Account payer = ledger.getAccount(resident_account);
        Account receiver_master = ledger.getMasterAccount();
        String transaction_id = "movieReservation_" + person_id;
        Transaction transaction = new Transaction(transaction_id, amount, 0, "Movie Reservation", payer, receiver_master);
        try {
            ledger.processTransaction(transaction);
            System.out.println("This person is charged for littering");
        } catch (LedgerException e) {
            System.out.println("This person doesn't have enough balance");
        }
        System.out.println("transaction processed for transactionID: " + transaction_id);
    }
}
