package cscie97.smartcity.model;

public class Resident extends Person {

    private String name;
    private String phoneNumber;
    private String role;
    private String blockChainAccountId;

    public Resident(String personId, String name, String biometricId, String phoneNumber,
                    String role, float lat, float longt, String blockChainAccountId) {
        super(personId, biometricId, lat, longt);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.blockChainAccountId = blockChainAccountId;
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