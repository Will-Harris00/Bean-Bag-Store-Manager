package beanbags;

public class Reservation {
    private BeanBag item;
    // private variable initialized
    private int reference;

    // Constructor: initialise identifier, reservation status, original price, customer reference, and customer name
    public Reservation(BeanBag item, int size) {
        this.item = item;
        // elected to use negative hex values as reservation numbers to make them easily distinguishable from beanbag id
        this.reference = size+1;
    }

    // public getters and setters for private instance
    // Public getters for private instances.

    public BeanBag getAttributes() {
        return item;
    }

    public int getReference() {
        return reference;
    }


    // Public setters for private instances.
    public void setReference(int reference) {
        this.reference = reference;
    }
}