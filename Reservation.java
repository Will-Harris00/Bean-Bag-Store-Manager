// A class to manage the list of reservations.
package beanbags;

public class Reservation {
    private BeanBag item;
    // Initialising private variable for reservation number.
    private int reference;

    // Constructor: initialise reservation list.
    public Reservation(BeanBag item, int size) {
        this.item = item;
        // Uses negative hex values as reservation numbers to make them easily
        // distinguishable from bean bag ID.
        this.reference = size + 1;
    }

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