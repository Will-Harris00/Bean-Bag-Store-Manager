package beanbags;

import java.io.IOException;

/**
 * BeanBagStore interface. The no-argument constructor of a class implementing
 * this interface should initialise the BeanBagStore as an empty store with no
 * initial bean bags contained within it.
 *
 * @author Jonathan Fieldsend
 * @version 1.3
 */

public class Store implements BeanBagStore {
    private ObjectArrayList stock = new ObjectArrayList();
    private ObjectArrayList reserved = new ObjectArrayList();
    private ObjectArrayList available = new ObjectArrayList();

    public void addBeanBags(int num, String manufacturer, String name, String id, short year, byte month)
            throws IllegalNumberOfBeanBagsAddedException, BeanBagMismatchException, IllegalIDException,
            InvalidMonthException {
        // If no information parameter mentioned, add bean bag with no additional
        // information.
        addBeanBags(num, manufacturer, name, id, year, month, "");
    }

    public void addBeanBags(int num, String manufacturer, String name, String id, short year, byte month,
            String information) throws IllegalNumberOfBeanBagsAddedException, BeanBagMismatchException,
            IllegalIDException, InvalidMonthException {

        // Throws an exception if the user tries to add a negative number of bean bags.
        if (num <= 0)
            throw new IllegalNumberOfBeanBagsAddedException("Number of beanbags cannot be less than zero");
        // Throws an exception if the user tries to add a month of manufacture which
        // doesn't exist.
        if (month < 0 | month > 12)
            throw new InvalidMonthException("Month must be between 1 and 12");

        // Checks that if IDs match, then attributes also match for added bean bags.
        try {
            CheckID.validId(id);
            for (int i = 0; i < num; i++) {
                BeanBag o = new BeanBag(manufacturer, name, id, year, month, information, 0);
                Mismatch.existingId(o, stock);
                stock.add(o);
            }
        }

        // Throws an exception if the ID isn't a hexadecimal number.
        catch (NumberFormatException e) {
            throw new IllegalIDException("Invalid Hexadecimal Identifier - Not a hexadecimal number");
        }
    }

    public void setBeanBagPrice(String id, int priceInPence)
            throws InvalidPriceException, BeanBagIDNotRecognisedException, IllegalIDException {
        BeanBag item;
        // Assumes bean bag is unrecognised until it finds the bean bag with the
        // mentioned ID.
        boolean recognised = false;

        // Checks the given ID, and sets the price to that ID if valid.
        try {
            CheckID.validId(id);
            if (priceInPence < 0)
                throw new InvalidPriceException("Price cannot be below zero pence.");
            for (int j = 0; j < stock.size(); j++) {
                item = (BeanBag) stock.get(j);
                if (item.getIdentifier().equals(id)) {
                    item.setPenceInPrice(priceInPence);
                    System.out.println(item.toString());
                    recognised = true;
                }
            }

            // Throws an exception for unrecognised bean bags.
            if (!recognised)
                throw new BeanBagIDNotRecognisedException("Bean bag identifier '" + id + "' not recognised.");
            // Throws an exception for bean bag IDs which aren't hexadecimal numbers.
        } catch (NumberFormatException e) {
            throw new IllegalIDException("Invalid Hexadecimal Identifier - Not a hexadecimal number");
        }
    }

    public void sellBeanBags(int num, String id)
            throws BeanBagNotInStockException, InsufficientStockException, IllegalNumberOfBeanBagsSoldException,
            PriceNotSetException, BeanBagIDNotRecognisedException, IllegalIDException {

    }

    public int reserveBeanBags(int num, String id)
            throws BeanBagNotInStockException, InsufficientStockException, IllegalNumberOfBeanBagsReservedException,
            PriceNotSetException, BeanBagIDNotRecognisedException, IllegalIDException {

        return 0;
    }

    public void unreserveBeanBags(int reservationNumber) throws ReservationNumberNotRecognisedException {

    }

    public void sellBeanBags(int reservationNumber) throws ReservationNumberNotRecognisedException {

    }

    public int beanBagsInStock() {

        return 0;
    }

    public int reservedBeanBagsInStock() {

        return 0;
    }

    public int beanBagsInStock(String id) throws BeanBagIDNotRecognisedException, IllegalIDException {

        return 0;
    }

    public void saveStoreContents(String filename) throws IOException {

    }

    public void loadStoreContents(String filename) throws IOException, ClassNotFoundException {

    }

    public int getNumberOfDifferentBeanBagsInStock() {

        return 0;
    }

    public int getNumberOfSoldBeanBags() {

        return 0;
    }

    public int getNumberOfSoldBeanBags(String id) throws BeanBagIDNotRecognisedException, IllegalIDException {

        return 0;
    }

    public int getTotalPriceOfSoldBeanBags() {

        return 0;
    }

    public int getTotalPriceOfSoldBeanBags(String id) throws BeanBagIDNotRecognisedException, IllegalIDException {

        return 0;
    }

    public int getTotalPriceOfReservedBeanBags() {

        return 0;
    }

    public String getBeanBagDetails(String id) throws BeanBagIDNotRecognisedException, IllegalIDException {

        return "";
    }

    public void empty() {

    }

    public void resetSaleAndCostTracking() {

    }

    public void replace(String oldId, String replacementId) throws BeanBagIDNotRecognisedException, IllegalIDException {

    }
}