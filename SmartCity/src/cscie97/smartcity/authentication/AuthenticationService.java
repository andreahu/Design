package cscie97.smartcity.authentication;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {

    private Map<String, Permission> permissionMap;
    private Map<String, Role> roleMap;
    private Map<String, User> userMap;
    private Map<String, Resource> resourceMap;

    public AuthenticationService() {
        this.permissionMap = new HashMap<>();
        this.roleMap = new HashMap<>();
        this.userMap = new HashMap<>();
        this.resourceMap = new HashMap<>();
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
        this.userMap.put(user_id, u);
        System.out.println("User has been created");
    }

    public void addUserCredential(String user_id, String credentialType, String value) {
        User u = userMap.get(user_id);
        if (credentialType.equals("password")) {
            u.getCredentials().put("password", value);
        } else if (credentialType.equals("biometric")) {
            String[] typeValuePair = value.split(":");
            String type = typeValuePair[0];
            String typeValue = typeValuePair[1];
            u.getCredentials().put(type, typeValue);
        }
        System.out.println("Credential has been added");
    }

    public void addRoleToUser(String user_id, String role_id) {
        User u = userMap.get(user_id);
        u.setRole_id(role_id);
        u.getEntitlements().add(role_id);
        System.out.println("Role has been added to user");
    }

    public void createResourceRole(String resource_role_id, String role_id, String resource_id) {
        if (!resourceMap.containsKey(resource_id)) {
            Resource resource = new Resource(resource_id);
            resourceMap.put(resource_id, resource);
            System.out.println("New Resource created");
        }

        ResourceRole rr = new ResourceRole(resource_role_id, role_id, resource_id);
        System.out.println("ResourceRole has been added to user");
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

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Map<String, Resource> getResourceMap() {
        return resourceMap;
    }

    public void setResourceMap(Map<String, Resource> resourceMap) {
        this.resourceMap = resourceMap;
    }
}
