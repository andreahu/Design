package cscie97.smartcity.authentication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Users represent persons of the Smart City system.
 * Users have an id, a name, and a set of Credentials. Credentials may include a
 * username/password, voiceprint, faceprint, and other biometric identities.
 * Users are associated with 0 or more entitlements (i.e., Roles or Permissions).
 */

public class User implements Element {

    private String id;
    private String name;

    private Map<String, String> credentials;
    private List<Entitlement> entitlements;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.credentials = new HashMap<>();
    }

    @Override
    public void accept(VisitorINF v) {
        //TODO
    }


    //getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getCredentials() {
        return credentials;
    }

    public void setCredentials(Map<String, String> credentials) {
        this.credentials = credentials;
    }

    public List<Entitlement> getEntitlements() {
        return entitlements;
    }

    public void setEntitlements(List<Entitlement> entitlements) {
        this.entitlements = entitlements;
    }
}
