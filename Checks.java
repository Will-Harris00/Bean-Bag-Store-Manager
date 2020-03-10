// Class containing exception handlers

package beanbags;

public class Checks {
    // Exception handler for the ID of a new bean bag to see if it has a valid format.
    public static void validId(String id) throws IllegalIDException {
        if (id.length() == 8) {
            try {
                int decimal = Long.valueOf(id, 16).intValue();
                if (decimal < 0) {
                    // Hexadecimal numbers must be positive, if not and exception is thrown.
                    throw new IllegalIDException("Invalid Hexadecimal Identifier - Not a positive number");
                }
            } catch (NumberFormatException e) {
                // Throws an exception for bean bag IDs which aren't hexadecimal numbers.
                throw new IllegalIDException("Invalid Hexadecimal Identifier - Not a hexadecimal number");
            }
        } else {
            // Checks for IDs and throws exception for those which don't have a length of 8.
            throw new IllegalIDException("Invalid Hexadecimal Identifier - Hex is not eight characters in length");
        }
    }


    // Exception handler for bean bags which have the same ID but different attributes.
    public static void existingMismatch(BeanBag item, ObjectArrayList stock) throws BeanBagMismatchException {
        BeanBag bb;
        for (int j = 0; j < stock.size(); j++) {
            bb = (BeanBag) stock.get(j);
            if (item.getIdentifier().equals(bb.getIdentifier())) {
                // Checks whether names of the bean bags match.
                if (!item.getName().equals(bb.getName())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Names do not match");
                }
                // Checks if the manufacturers of the bean bags match.
                if (!item.getManufacturer().equals(bb.getManufacturer())) {
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
                if (!item.getInformation().equals(bb.getInformation())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Information does not match");
                }
            }
        }
    }


    // Exception handler for sales.
    public static void validSale(int num, String id, int available) throws BeanBagNotInStockException,
            InsufficientStockException, IllegalNumberOfBeanBagsSoldException, IllegalIDException {
        if (num <= 0)
            throw new IllegalNumberOfBeanBagsSoldException("Cannot sell zero or fewer beanbags");
        Checks.validId(id);
        if (available == 0)
            throw new BeanBagNotInStockException("None of these bean bags are available for reservation");
        if (num > available)
            throw new InsufficientStockException("Insufficient stock available for reservation");
    }


    // Exception handler for reservations.
    public static void validReservation(int num, String id, int available) throws BeanBagNotInStockException,
            InsufficientStockException, IllegalNumberOfBeanBagsReservedException, IllegalIDException {
        if (num <= 0)
            throw new IllegalNumberOfBeanBagsReservedException("Cannot sell zero or fewer beanbags");
        Checks.validId(id);
        if (available == 0)
            throw new BeanBagNotInStockException("None of these bean bags are available for reservation");
        if (num > available)
            throw new InsufficientStockException("Insufficient stock available for reservation");
    }
}
