package cscie97.smartcity.authentication;

public class CheckAccessVisitor implements VisitorINF {

    private boolean hasAccess;
    private String permissionId;

    public CheckAccessVisitor(String permissionId) {
        this.hasAccess = false;
        this.permissionId = permissionId;
    }
    
    @Override
    public void visitUser(User u) {
    }

    @Override
    public void visitRole(Role r) {
        for (Permission p : r.getPermissions()) {
            if (p.getId().equals(this.permissionId)) {
                hasAccess = true;
                return;
            }
        }
    }

    @Override
    public void visitPermission(Permission p) {
        if (p.getId().equals(this.permissionId)) {
            hasAccess = true;
            return;
        }
    }

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

    public boolean isHasAccess() {
        return hasAccess;
    }
}
