package cscie97.smartcity.authentication;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {

    private Map<String, Permission> permissionMap;
    private Map<String, Role> roleMap;

    public AuthenticationService() {
        this.permissionMap = new HashMap<>();
        this.roleMap = new HashMap<>();
    }

    public void definePermission(String id, String name, String description) {
        Permission p = new Permission(id, name, description);
        this.permissionMap.put(id, p);
        System.out.println("Permission Created");
    }

    public void defineRole(String id, String name, String description) {
        Role r = new Role(id, name, description);
        this.roleMap.put(id, r);
        System.out.println("Role Created");
    }


    public void addPermissionToRole(String role_id, String permission_id) {
        Role r = roleMap.get(role_id);
        Permission p = permissionMap.get(permission_id);
        r.getPermissions().add(p);
        System.out.println("Permission has been added to role.");
    }

    public void createUser(String user_id, String user_name) {
        User u = new User(user_id, user_name);
        System.out.println("User has been created");
    }


    //getters and setters


    public Map<String, Permission> getPermissionMap() {
        return permissionMap;
    }

    public void setPermissionMap(Map<String, Permission> permissionMap) {
        this.permissionMap = permissionMap;
    }

    public Map<String, Role> getRoleMap() {
        return roleMap;
    }

    public void setRoleMap(Map<String, Role> roleMap) {
        this.roleMap = roleMap;
    }
}
