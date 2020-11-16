package cscie97.smartcity.authentication;

public interface VisitorINF {

    public void visitUser(User u);

    public void visitRole(Role r);

    public void visitPermission(Permission p);

    public void visitResourceRole(ResourceRole rr);
}
