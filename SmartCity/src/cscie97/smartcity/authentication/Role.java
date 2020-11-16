package cscie97.smartcity.authentication;

import java.util.ArrayList;
import java.util.List;

public class Role extends Entitlement {

    private List<Permission> permissions;

    public Role(String id, String name, String description) {
        super(id, name, description);
        this.permissions = new ArrayList<>();
    }

    public void accept(VisitorINF v) {
        v.visitRole(this);
    }


    //getters and setters

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
