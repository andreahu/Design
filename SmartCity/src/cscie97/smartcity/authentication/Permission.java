package cscie97.smartcity.authentication;

public class Permission extends Entitlement {


    public Permission(String id, String name, String description) {
        super(id, name, description);
    }

    public void accept(VisitorINF v) {
        v.visitPermission(this);
    }
}
