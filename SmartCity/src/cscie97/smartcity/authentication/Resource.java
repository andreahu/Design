package cscie97.smartcity.authentication;

/**
 * A Resource represents a physical and logical entity, for example, an IoT Device.
 * A Resource has a unique identifier and a description.
 */
public class Resource {
    private String id;
    private String description;

    public Resource(String id, String description) {
        this.id = id;
        this.description = description;
    }
}
