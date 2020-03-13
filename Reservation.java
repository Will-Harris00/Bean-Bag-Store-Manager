package beanbags;

import java.io.Serializable;

/**
 * Reservation class which implements Serializable. Creates a new instance of a
 * reserved bean bag object and changes/returns the bean bag or reservation
 * number.
 *
 * @author 680033128
 * @author 690065435
 * @version 1.1
 *
 *
 */

public class Reservation implements Serializable {
    private BeanBag item;
    // Initialising private variable for reservation number.
    private int reference;

    /**
     * Constructor for initialising reserved bean bag objects. Reserved objects
     * contain the following attributes.
     *
     * @param item      This is equivalent to an instance of a bean bag object.
     * @param reference This contains the reservation number associated with a given
     *                  bean bag.
     *
     */
    public Reservation(BeanBag item, int reference) {
        this.item = item;
        this.reference = reference;
    }

    /**
     * Public getter method for finding all attributes of a particular bean bag.
     *
     * @return Returns a BeanBag object containing all attributes.
     *
     */
    public BeanBag getAttributes() {
        return item;
    }

    /**
     * Public getter method for finding the reservation number of a reserved item.
     *
     * @return Returns only the reservation number of a bean bag without any of its
     *         attributes.
     *
     */
    public int getReservation() {
        return reference;
    }

    /**
     * Public setter method for editing the attributes of a bean bag. Method
     * included for future development.
     *
     * @param item This replaces the existing BeanBag object related to a
     *             reservation number.
     *
     */
    public void setAttributes(BeanBag item) {
        this.item = item;
    }

    /**
     * Public setter method for editing the reservation number of a bean bag. Method
     * included for future development.
     *
     * @param reference This replaces the reservation number without making changes
     *                  to a bean bags attributes.
     *
     */
    public void setReservation(int reference) {
        this.reference = reference;
    }
}