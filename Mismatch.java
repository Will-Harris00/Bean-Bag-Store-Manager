// Exception handler for bean bags which have the same ID but different attributes.

package beanbags;

public class Mismatch {
    public static void existingId(BeanBag o, ObjectArrayList stock) throws BeanBagMismatchException {
        BeanBag item;
        for (int j = 0; j < stock.size(); j++) {
            item = (BeanBag) stock.get(j);
            if (item.getIdentifier().equals(o.getIdentifier())) {
                // Checks whether names of the bean bags match.
                if (!item.getName().equals(o.getName())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Names do not match");
                }
                // Checks if the manufacturers of the bean bags match.
                if (!item.getManufacturer().equals(o.getManufacturer())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Manufacturers do not match");
                }
                // Checks if the years of manufacture match.
                if (!(item.getYear() == o.getYear())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Year of manufacture does not match");
                }
                // Checks if the months of manufacture match.
                if (!(item.getMonth() == o.getMonth())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Month of manufacture does not match");
                }
                // Checks if the additional information on the bean bags match.
                if (!item.getInformation().equals(o.getInformation())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Information does not match");
                }
            }
        }
    }
}