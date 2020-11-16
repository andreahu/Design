package cscie97.smartcity.authentication;

import java.util.ArrayList;
import java.util.List;

public class Role extends Entitlement {

    private ArrayList<Permission> permissions;

    // TODO: Should we add sub roles here?

    public Role(String id, String name, String description) {
        super(id, name, description);
        this.permissions = new ArrayList<>();
    }

    public void accept(VisitorINF v) {
        v.visitRole(this);
    }


    //getters and setters

    public ArrayList<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<Permission> permissions) {
        this.permissions = permissions;
    }
}
