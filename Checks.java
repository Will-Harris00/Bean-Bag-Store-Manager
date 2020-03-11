// Class containing exception handlers.

package beanbags;

public class Checks {
    // Exception handler for the ID of a new bean bag to see if it has a valid
    // format.
    public static void validID(String id) throws IllegalIDException {
        if (id.length() == 8) {
            try {
                int decimal = Long.valueOf(id, 16).intValue();
                if (decimal < 0) {
                    // Throws an exception for bean bag IDs which aren't positive hexadecimals.
                    throw new IllegalIDException("Invalid Hexadecimal Identifier - Not a positive number");
                }
            } catch (NumberFormatException e) {
                // Throws an exception for bean bag IDs which aren't hexadecimal numbers.
                throw new IllegalIDException("Invalid Hexadecimal Identifier - Not a hexadecimal number");
            }
        } else {
            // Throws an exception for IDs which don't have a length of 8.
            throw new IllegalIDException("Invalid Hexadecimal Identifier - Hex is not eight characters in length");
        }
    }

    // Exception handler for bean bags which have the same ID but different
    // attributes.
    public static void existingMismatch(BeanBag item, ObjectArrayList stock) throws BeanBagMismatchException {
        BeanBag bb;
        for (int j = 0; j < stock.size(); j++) {
            bb = (BeanBag) stock.get(j);
            if (item.getIdentifier().equalsIgnoreCase(bb.getIdentifier())) {
                // Checks whether names of the bean bags match.
                if (!item.getName().equalsIgnoreCase(bb.getName())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Names do not match");
                }
                // Checks if the manufacturers of the bean bags match.
                if (!item.getManufacturer().equalsIgnoreCase(bb.getManufacturer())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Manufacturers do not match");
                }
                // Checks if the years of manufacture match.
                if (!(item.getYear() == bb.getYear())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Year of manufacture does not match");
                }
                // Checks if the months of manufacture match.
                if (!(item.getMonth() == bb.getMonth())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Month of manufacture does not match");
                }
                // Checks if the additional information on the bean bags match.
                if (!item.getInformation().equalsIgnoreCase(bb.getInformation())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Information does not match");
                }
            }
        }
    }

    // Exception handler for sales.
    public static void validSale(int num, String id, int available) throws BeanBagNotInStockException,
            InsufficientStockException, IllegalNumberOfBeanBagsSoldException, IllegalIDException {
        // Throws an exception if the user attempts to sell a non-positive number of
        // bean bags.
        if (num <= 0)
            throw new IllegalNumberOfBeanBagsSoldException("Cannot sell zero or fewer beanbags");
        Checks.validID(id);
        // Throws an exception if there are no bean bags available for sale.
        if (available == 0)
            throw new BeanBagNotInStockException("None of these bean bags are available for sale");
        // Throws an exception if there aren't enough bean bags available for sale.
        if (num > available)
            throw new InsufficientStockException(
                    "Insufficient stock available for sale; only " + available + " are in stock.");
    }

    // Exception handler for reservations.
    public static void validReservation(int num, String id, int available) throws BeanBagNotInStockException,
            InsufficientStockException, IllegalNumberOfBeanBagsReservedException, IllegalIDException {
        // Throws an exception if the user attempts to reserve a non-positive number of
        // bean bags.
        if (num <= 0)
            throw new IllegalNumberOfBeanBagsReservedException("Cannot sell zero or fewer beanbags");
        Checks.validID(id);
        // Throws an exception if there are no bean bags available for reservation.
        if (available == 0)
            throw new BeanBagNotInStockException("None of these bean bags are available for reservation");
        // Throws an exception if there aren't enough bean bags available for
        // reservation.
        if (num > available)
            throw new InsufficientStockException(
                    "Insufficient stock available for reservation; only " + available + " are in stock.");
    }
}
