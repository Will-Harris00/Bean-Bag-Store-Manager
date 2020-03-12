// Class containing exception handlers.

package beanbags;

public class Checks {
    // Exception handler for bean bags which have the same ID but different
    // attributes.
    public static void existingMismatch(BeanBag newBeanBag, ObjectArrayList available, ObjectArrayList reserved,
            ObjectArrayList sold) throws BeanBagMismatchException {
        // Checks the object IDs in each of these lists to ensure no mismatch occurs.
        ObjectArrayList[] objects = { available, reserved, sold };
        BeanBag item;
        Reservation held;
        int i;
        ObjectArrayList obj;

        // Iterates over the lists one by one.
        for (i = 0; i < objects.length; i++) {
            // Accesses each element of array.
            obj = objects[i];

            // Updates the IDs in the available stock, reserved and sold list.
            for (int j = 0; j < obj.size(); j++) {
                // Casts reserved bean bags separately to available/sold bean bags, as they have
                // different attributes.
                if (obj == reserved) {
                    held = (Reservation) obj.get(j);
                    item = held.getAttributes();
                } else {
                    item = (BeanBag) obj.get(j);
                }
                // Checks name, manufacturer, and additional information for bean bags with the
                // same ID.
                if (newBeanBag.getIdentifier().equalsIgnoreCase(item.getIdentifier())) {
                    // Checks whether names of the bean bags match.
                    if (!newBeanBag.getName().equalsIgnoreCase(item.getName())) {
                        throw new BeanBagMismatchException("The bean bags do not have the same name '" + item.getName()
                                + "' does not match '" + newBeanBag.getName() + "' for '" + item.getIdentifier() + "'");
                    }
                    // Checks if the manufacturers of the bean bags match.
                    if (!newBeanBag.getManufacturer().equalsIgnoreCase(item.getManufacturer())) {
                        throw new BeanBagMismatchException("The bean bags do not come from the same manufacturer '"
                                + item.getManufacturer() + "' does not match '" + newBeanBag.getManufacturer()
                                + "' for '" + item.getIdentifier() + "'");
                    }
                    // Checks if the additional information on the bean bags match.
                    if (!newBeanBag.getInformation().equalsIgnoreCase(item.getInformation())) {
                        throw new BeanBagMismatchException("The bean bags do not have the same information "
                                + "associated with them '" + item.getInformation() + "' does not match '"
                                + newBeanBag.getInformation() + "' for '" + item.getIdentifier() + "'");
                    }
                }
            }
        }
    }

    // Exception handler for the ID of a new bean bag to see if it has a valid
    // format.
    public static void validId(String id) throws IllegalIDException {
        // Checks whether the ID consists of eight characters.
        if (id.length() == 8) {
            try {
                // Throws an exception for bean bag IDs which aren't positive hexadecimals.
                if ((int) Long.parseLong(id, 16) < 0) {
                    throw new IllegalIDException(
                            "Invalid hexadecimal identifier, '" + id + "'  is not a positive number");
                }
                // Throws an exception for bean bag IDs which aren't hexadecimal numbers.
            } catch (NumberFormatException e) {
                throw new IllegalIDException(
                        "Invalid hexadecimal identifier, '" + id + "'  is not a hexadecimal number");
            }
            // Throws an exception for IDs which don't have a length of 8.
        } else {
            throw new IllegalIDException(
                    "Invalid hexadecimal identifier, '" + id + "'  is not eight characters in length");
        }
    }

    // Exception handler for reservations.
    public static void validReservation(int num, String id, int available) throws BeanBagNotInStockException,
            InsufficientStockException, IllegalNumberOfBeanBagsReservedException, IllegalIDException {
        Checks.validId(id);

        // Throws an exception if the user attempts to reserve a non-positive number of
        // bean bags.
        if (num <= 0)
            throw new IllegalNumberOfBeanBagsReservedException(
                    "The number of bean bags '" + num + "' reserved cannot be less than zero");
        // Throws an exception if there are no bean bags available for reservation.
        if (available == 0)
            throw new BeanBagNotInStockException("None of these bean bags '" + id + "' are available for reservation");
        // Throws an exception if there aren't enough bean bags available for
        // reservation.
        if (num > available)
            throw new InsufficientStockException("Insufficient stock available for reservation; only '" + available
                    + "' of '" + id + "' are in stock.");
    }

    // Exception handler for sales.
    public static void validSale(int num, String id, int available) throws BeanBagNotInStockException,
            InsufficientStockException, IllegalNumberOfBeanBagsSoldException, IllegalIDException {
        Checks.validId(id);

        // Throws an exception if the user attempts to sell a non-positive number of
        // bean bags.
        if (num <= 0)
            throw new IllegalNumberOfBeanBagsSoldException(
                    "The number of bean bags '" + num + "' sold cannot be less than zero");
        // Throws an exception if there are no bean bags available for sale.
        if (available == 0)
            throw new BeanBagNotInStockException("None of these bean bags '" + id + "' are available for sale");
        // Throws an exception if there aren't enough bean bags available for sale.
        if (num > available)
            throw new InsufficientStockException(
                    "Insufficient stock available for sale; only '" + available + "' of '" + id + "' are in stock.");
    }
}
