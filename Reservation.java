// A class to manage the list of reservations.
package beanbags;

public class Reservation {
    private BeanBag item;
    // Initialising private variable for reservation number.
    private int reference;

    // Constructor: initialise reservation list.
    public Reservation(BeanBag item, int reference) {
        this.item = item;
        // Uses negative hex values as reservation numbers to make them easily
        // distinguishable from bean bag ID.
        this.reference = reference;
    }

    // Public getters for private instances.
    public BeanBag getAttributes() {
        return item;
    }

    public int getReservation() {
        return reference;
    }

    // Public setters for private instances.
    public void setReference(int reference) {
        this.reference = reference;
    }
}