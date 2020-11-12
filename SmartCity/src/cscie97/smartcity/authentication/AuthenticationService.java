package cscie97.smartcity.authentication;

public class AuthenticationService {


    public void definePermission(String id, String name, String description) {
        Permission p = new Permission(id, name, description);
        System.out.println("Permission Created");
    }

    public void defineRole(String id, String name, String description) {
        Role r = new Role(id, name, description);
        System.out.println("Role Created");
    }

}
