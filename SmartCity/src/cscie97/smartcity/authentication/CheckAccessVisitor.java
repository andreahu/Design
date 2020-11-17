package cscie97.smartcity.authentication;

/**
 * This class inherites the VisitorINF interface for using Visitor pattern.
 * This class check access for Users, Resources, Permissions.
 */
public class CheckAccessVisitor implements VisitorINF {

    private boolean hasAccess;
    private String permissionId;

    public CheckAccessVisitor(String permissionId) {
        this.hasAccess = false;
        this.permissionId = permissionId;
    }


    /**
     * Doesn't do anything here
     *
     * @param u The User object passed in
     */
    @Override
    public void visitUser(User u) {
    }


    /**
     * Traverse the permissions of the role and update hasAccess variable to true if the permission is found
     *
     * @param r: the Role object passed in
     */
    @Override
    public void visitRole(Role r) {
        for (Permission p : r.getPermissions()) {
            if (p.getId().equals(this.permissionId)) {
                hasAccess = true;
                return;
            }
        }
    }

    /**
     * Compare the permission passed into the contrustor vs the permission passed in and update hasAccess variable to true if the permission matches
     *
     * @param p the permission object passed in
     */
    @Override
    public void visitPermission(Permission p) {
        if (p.getId().equals(this.permissionId)) {
            hasAccess = true;
            return;
        }
    }

    /**
     * Traverse the permissions of the ResourceRole and update hasAccess variable to true if the permission is found
     *
     * @param r the Resource role object
     */
    @Override
    public void visitResourceRole(ResourceRole r) {
        //TODO: add checking resource
        for (Permission p : r.getPermissions()) {
            if (p.getId().equals(this.permissionId)) {
                hasAccess = true;
                return;
            }
        }
    }

    /**
     * Check the hasAccess variable. return true if hasAccess is true. return false if hasAccess is false
     *
     * @return: return true if hasAccess is true. return false if hasAccess is false
     */
    public boolean isHasAccess() {
        return hasAccess;
    }
}
