package cscie97.smartcity.authentication;

/**
 * Permission class is a child class of Entitlement. Therefore it extends all the properties and methods from Entitlement
 */
public class Permission extends Entitlement {


    public Permission(String id, String name, String description) {
        super(id, name, description);
    }

    /**
     * Utilize visitor pattern to execute the corresponding algorithm
     *
     * @param v the visitor object
     */
    public void accept(VisitorINF v) {
        v.visitPermission(this);
    }
}
