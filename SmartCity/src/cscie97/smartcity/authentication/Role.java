package cscie97.smartcity.authentication;

import java.util.ArrayList;
import java.util.List;

/**
 * Role class is a child class of Entitlement. Therefore it extends all the properties and methods from Entitlement
 */
public class Role extends Entitlement {

    private ArrayList<Permission> permissions;


    public Role(String id, String name, String description) {
        super(id, name, description);
        this.permissions = new ArrayList<>();
    }

    /**
     * Utilize visitor pattern to execute the corresponding algorithm
     *
     * @param v the visitor object
     */
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
