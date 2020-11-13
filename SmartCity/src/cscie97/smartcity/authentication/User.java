package cscie97.smartcity.authentication;

import java.util.List;

public class User implements Element {

    private String id;
    private String name;

    private List<Entitlement> entitlements;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void accept(VisitorINF v) {
        //TODO
    }
}
