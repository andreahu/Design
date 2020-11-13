package cscie97.smartcity.authentication;

public class ResourceRole extends Role {

    //TODO: from the script the constructor should be different

    //# create resource role
    //# create_resource_role <resource_role_name> <role_id> <resource>
    //create_resource_role city1_public_administrator_resource_role admin_role city1


    public ResourceRole(String id, String name, String description) {
        super(id, name, description);
    }
}
