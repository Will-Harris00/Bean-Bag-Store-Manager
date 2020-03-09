package beanbags;

public class Mismatch {
    public static boolean Mismatch(BeanBag o) throws BeanBagMismatchException {
        boolean mismatch = false;
        BeanBag array = null;
        ObjectArrayList obj = Store.getObj();
        for (int j = 0; j < obj.size(); j++)
            array = (BeanBag) obj.get(j);
        assert array != null;
            if (!array.getIdentifier().equals(o.getIdentifier())) {
                mismatch = true;
                throw new BeanBagMismatchException("Beanbag Mismatch - Attributes do not match");
            }

        return mismatch;

    }

    public static boolean Alternative(String id, String name, String manufacturer, short year, byte month, String information) throws BeanBagMismatchException{
        boolean mismatch = false;
        BeanBag array = null;
        for (int j = 0; j < obj.size(); j++)
            array = (BeanBag) obj.get(j);
        assert array != null;
            if (array.getIdentifier().equals(id)) {
                if (!array.getName().equals(name)) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Names do not match");
                }
                if (!array.getManufacturer().equals(manufacturer)) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Manufacturers do not match");
                }
                if (!(array.getYear() == year)) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Year of manufacture does not match");
                }
                if (!(array.getMonth() == month)) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Month of manufacture does not match");
                }
                if (!array.getInformation().equals(information)) {
                    throw new BeanBagMismatchException("Beanbag Mismatch - Information does not match");
                }
            }
        return mismatch;
    }
}
