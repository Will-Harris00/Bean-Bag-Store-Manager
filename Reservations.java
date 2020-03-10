package beanbags;

public class Reservations {
    private BeanBag item;
    // private variable initialized
    private String reference;

    // Constructor: initialise identifier, reservation status, original price, customer reference, and customer name
    public Reservations(BeanBag item, int size) {
        this.item = item;
        // elected to use negative hex values as reservation numbers to make them easily distinguishable from beanbag id
        this.reference = Long.toHexString(-(size+1));
        System.out.println(reference);
        System.out.println(item);
    }

    // public getters and setters for private instance
    // Public getters for private instances.

    public BeanBag getAttributes() {
        return item;
    }

    public String getReference() {
        return reference;
    }


    // Public setters for private instances.
    public void setReference(String manufacturer) {
        this.reference = reference;
    }


    // this method can be used to set the boolean value reserved to false
    // thereby telling the package that the beanbag selected is no longer reserved.
    // there is scope later in development to include additional setter methods for updating details relating to a
    // reservation such as the name of the customer. The current implementation will require a reservation to be
    // deleted and a new one made for any information to be changed. This is unlikely to cause significant annoyance
    // to the end user so will be one of the last things that we revisited.
    // It is however necessary to include a method removing items from the list of reservations
    // as we do not want them to be reserved indefinitely if a customer changes their mind.
}