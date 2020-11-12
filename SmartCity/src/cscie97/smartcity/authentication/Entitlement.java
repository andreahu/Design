package cscie97.smartcity.authentication;

public abstract class Entitlement implements Element {

    private String id;
    private String name;
    private String description;

    public Entitlement(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public void accept(VisitorINF v) {

        //TODO

    }
}
