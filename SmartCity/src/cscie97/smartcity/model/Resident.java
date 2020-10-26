package cscie97.smartcity.model;

import com.cscie97.ledger.*;

public class Resident extends Person {

    private String name;
    private String phoneNumber;
    private String role;
    private String blockChainAccountId;
    private Ledger ledger;

    public Resident(String personId, String name, String biometricId, String phoneNumber,
                    String role, float lat, float lon, String blockChainAccountId, Ledger l) {
        super(personId, biometricId, lat, lon);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.blockChainAccountId = blockChainAccountId;
        this.ledger = l;
        ledger.createAccount(blockChainAccountId);
    }


    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBlockChainAccountId() {
        return blockChainAccountId;
    }

    public void setBlockChainAccountId(String blockChainAccountId) {
        this.blockChainAccountId = blockChainAccountId;
    }
}