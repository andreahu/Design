package cscie97.smartcity.authentication;

/**
 * ResourceRole class is a child class of Entitlement. Therefore it extends all the properties and methods from Roles
 */
public class ResourceRole extends Role {

    private String resource_id;
    private String role_id;


    public ResourceRole(String id, String role_id, String resource_id) {
        super(id, id, "This is a ResourceRole");//the id and name is the same for resource role
        this.role_id = role_id;
        this.resource_id = resource_id;
    }

    public void accept(VisitorINF v) {
        v.visitResourceRole(this);
    }

    //getters and setter
    
    public String getResource_id() {
        return resource_id;
    }

    public void setResource_id(String resource_id) {
        this.resource_id = resource_id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }
}
