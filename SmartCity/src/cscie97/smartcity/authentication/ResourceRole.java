package cscie97.smartcity.authentication;

public class ResourceRole extends Role {

    private String resource_id;
    private String role_id;


    public ResourceRole(String id, String role_id, String resource_id) {
        super(id, id, "This is a ResourceRole");//the id and name is the same for resource role
        this.resource_id = role_id;
        this.resource_id = resource_id;
    }

    public void accept(VisitorINF v) {
        v.visitResourceRole(this);
    }
    
}
