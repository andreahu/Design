package cscie97.smartcity.model;

import com.cscie97.ledger.Ledger;

public class Vehicle extends Device {
    private String type;
    private String activity;
    private String capacity;
    private int fee;
    private String blockChainAccountId;
    private Ledger ledger;

    public Vehicle(City city, String deviceId, float lat, float lon, String enabled, String type, String activity, String capacity, int fee, Ledger l) {
        super(city, deviceId, lat, lon, enabled);
        this.type = type;
        this.activity = activity;
        this.capacity = capacity;
        this.fee = fee;
        this.blockChainAccountId = this.getDeviceId() + "_accountId";
        this.ledger = l;
        ledger.createAccount(blockChainAccountId);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getBlockChainAccountId() {
        return blockChainAccountId;
    }

    public void setBlockChainAccountId(String blockChainAccountId) {
        this.blockChainAccountId = blockChainAccountId;
    }

    public Ledger getLedger() {
        return ledger;
    }

    public void setLedger(Ledger ledger) {
        this.ledger = ledger;
    }
}
