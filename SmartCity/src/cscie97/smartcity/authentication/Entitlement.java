package cscie97.smartcity.authentication;

/**
 * This class is the parent class that implements interface Element.
 * This class has two child classes: Role and Permission
 */

public abstract class Entitlement implements Element {

    private String id;
    private String name;
    private String description;

    public Entitlement(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Utilize visitor pattern to execute the corresponding algorithm
     *
     * @param v the visitor object
     */
    public abstract void accept(VisitorINF v);

    //getters and setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
