package beanbags;

public class Mismatch {
    public static void existingId(BeanBag o, ObjectArrayList stock) throws BeanBagMismatchException {
        System.out.println(o);
        BeanBag item;
        for (int j = 0; j < stock.size(); j++) {
            item = (BeanBag) stock.get(j);
            System.out.println(item);
            assert item != null;
            if (item.getIdentifier().equals(o.getIdentifier())) {
                if (!item.getName().equals(o.getName())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Names do not match");
                }
                if (!item.getManufacturer().equals(o.getManufacturer())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Manufacturers do not match");
                }
                if (!(item.getYear() == o.getYear())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Year of manufacture does not match");
                }
                if (!(item.getMonth() == o.getMonth())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Month of manufacture does not match");
                }
                if (!item.getInformation().equals(o.getInformation())) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Information does not match");
                }
            }
        }
    }
}
// hello world