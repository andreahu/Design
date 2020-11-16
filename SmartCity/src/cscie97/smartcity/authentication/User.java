package cscie97.smartcity.authentication;

import java.util.ArrayList;
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
    private String role_id;

    private Map<String, String> credentials;
    private List<String> entitlements;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.credentials = new HashMap<>();
        this.entitlements = new ArrayList<>();
    }

    @Override
    public void accept(VisitorINF v) {
        v.visitUser(this);
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

    public List<String> getEntitlements() {
        return entitlements;
    }

    public void setEntitlements(List<String> entitlements) {
        this.entitlements = entitlements;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }
}

