package cscie97.smartcity.authentication;

/**
 * A Resource represents a physical and logical entity, for example, an IoT Device.
 * A Resource has a unique identifier and a description.
 */
public class Resource {
    private String id;
    private String description;

    public Resource(String id) {
        this.id = id;
        this.description = null;
    }

    public Resource(String id, String description) {
        this.id = id;
        this.description = description;
    }

    //getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
