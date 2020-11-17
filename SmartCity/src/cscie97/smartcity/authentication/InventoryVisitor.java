package cscie97.smartcity.authentication;

/**
 * This classes inherited the VisitorINF interface for using Visitor pattern.
 * This class traverses the Authentication Service objects to provide an inventory of all Users, Resources, Accesses, Roles, and Permissions.
 */

public class InventoryVisitor implements VisitorINF {
    /**
     * This method prints out the information about a user includes the ID, name, role, credentials
     *
     * @param u: the user object passed in
     */
    @Override
    public void visitUser(User u) {
        String id = u.getId();
        String name = u.getName();
        String role_id = u.getRole_id();
        System.out.println("User's id: " + id + "; name: " + name + "; role: " + role_id);

        for (String type : u.getCredentials().keySet()) {
            System.out.println("Credential - " + type + ": " + u.getCredentials().get(type));
        }

        for (String role : u.getRoles()) {
            System.out.println("role: " + role);
        }

    }

    /**
     * This method prints out the information about a role includes the ID, name, description, and permissions
     *
     * @param r: the role passed in
     */
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

    /**
     * This method prints out the information about a permission that includes the ID, name, description
     *
     * @param p: the permission object passed in
     */
    @Override
    public void visitPermission(Permission p) {
        String id = p.getId();
        String name = p.getName();
        String description = p.getDescription();
        System.out.println("Role's id: " + id + "; name: " + name + "; description: " + description);


    }

    /**
     * This method prints out the information about a permission that includes the ID, name, description, roleId and resourceId
     *
     * @param rr the resource role object passed in
     */
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
