package cscie97.smartcity.model;

public class Resident extends Person {

    private String name;
    private String phoneNumber;
    private String role;
    private String blockChainAccountId;

    public Resident(String personId, String name, String biometricId, String phoneNumber, String role, float lat, float longt, String blockChainAccountId) {
        super(personId, biometricId, lat, longt);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.blockChainAccountId = blockChainAccountId;
    }
    
}