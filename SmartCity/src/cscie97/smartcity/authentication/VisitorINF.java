package cscie97.smartcity.authentication;

/**
 * This is the interface for using Visitor pattern.
 * The visitor classes that implement the interface, which changes the executing algorithm of an element class. By this way, execution algorithm of element can vary as and when visitor varies.
 */
public interface VisitorINF {

    public void visitUser(User u);

    public void visitRole(Role r);

    public void visitPermission(Permission p);

    public void visitResourceRole(ResourceRole rr);
}
