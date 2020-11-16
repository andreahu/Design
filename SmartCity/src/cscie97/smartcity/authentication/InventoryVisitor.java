package cscie97.smartcity.authentication;

public class InventoryVisitor implements VisitorINF {
    @Override
    public void visitUser(User u) {
        String id = u.getId();
        String name = u.getName();
        String role_id = u.getRole_id();
        System.out.println("User's id: " + id + "; name: " + name + "; role: " + role_id);

        for (String type : u.getCredentials().keySet()) {
            System.out.println("Credential - " + type + ": " + u.getCredentials().get(type));
        }

        //TODO: List<Entitlement> entitlements;

    }

    @Override
    public void visitRole(Role r) {
        String id = r.getId();
        String name = r.getName();
        String description = r.getDescription();
        System.out.println("Role's id: " + id + "; name: " + name + "; description: " + description);

        for (Permission p : r.getPermissions()) {
            System.out.println("Permission id: " + p.getId());
        }
    }

    @Override
    public void visitPermission(Permission p) {
        String id = p.getId();
        String name = p.getName();
        String description = p.getDescription();
        System.out.println("Role's id: " + id + "; name: " + name + "; description: " + description);


    }

    @Override
    public void visitResourceRole(ResourceRole rr) {
        String id = rr.getId();
        String name = rr.getName();
        String description = rr.getDescription();
        String resource_id = rr.getResource_id();
        String role_id = rr.getRole_id();
        System.out.println("Role's id: " + id + "; name: " + name + "; description: " + description + "; resource id: " + resource_id + "role id: " + role_id);
    }
}
