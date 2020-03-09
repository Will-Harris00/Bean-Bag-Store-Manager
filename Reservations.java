package beanbags;

public class Reservations {
    // private variable initialized
    private String identifier;
    private boolean reserved;
    private double original_price;
    private String reference;
    private String customer;

    // Constructor: initialise identifier, reservation status, original price, customer reference, and customer name
    public Reservations(String identifier, boolean reserved, double original_price, String reference, String customer) {
        this.identifier = identifier;
        this.reserved = reserved;
        this.original_price = original_price;
        this.reference = reference;
        this.customer = customer;
    }

    // public getters and setters for private instance
    public String getIdentifier() {
        return identifier;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public double getOriginalPrice() {
        return original_price;
    }

    public String getReference() {
        return reference;
    }

    public String getCustomer() {
        return customer;
    }

    // this method can be used to set the boolean value reserved to false
    // thereby telling the package that the beanbag selected is no longer reserved.
    public void setReserved() {
        this.reserved = false;
    }
    // there is scope later in development to include additional setter methods for updating details relating to a
    // reservation such as the name of the customer. The current implementation will require a reservation to be
    // deleted and a new one made for any information to be changed. This is unlikely to cause significant annoyance
    // to the end user so will be one of the last things that we revisited.
    // It is however necessary to include a method removing items from the list of reservations
    // as we do not want them to be reserved indefinitely if a customer changes their mind.
}