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

    // If no information parameter mentioned, adds a bean bag with no
    // additional information.
    public void addBeanBags(int num, String manufacturer, String name, String id, short year, byte month)
            throws IllegalNumberOfBeanBagsAddedException, BeanBagMismatchException, IllegalIDException,
            InvalidMonthException {
        addBeanBags(num, manufacturer, name, id, year, month, "");
    }

    // Adds a bean bag to stock.
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

    // Sets the price of a bean bag in stock.
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

    // Sells a given quantity of a bean bag based on ID.
    public void sellBeanBags(int num, String id)
            throws BeanBagNotInStockException, InsufficientStockException, IllegalNumberOfBeanBagsSoldException,
            PriceNotSetException, BeanBagIDNotRecognisedException, IllegalIDException {
        if (num <= 0)
            throw new IllegalNumberOfBeanBagsSoldException("Cannot sell zero or fewer beanbags");
        BeanBag item;
        boolean recognised = false;
        try {
            CheckID.validId(id);
            int available = beanBagsInStock(id);
            System.out.println(available);
            if (num > available)
                throw new InsufficientStockException("Insufficient stock available for sale");
            else if (available == 0) {
                throw new BeanBagNotInStockException("None of these bean bags are available");
            } else {
                for (int i = 0; i < num; i++) {
                    for (int j = 0; j < stock.size(); j++) {
                        item = (BeanBag) stock.get(j);
                        if (item.getIdentifier().equals(id)) {
                            if (item.getPenceInPrice() == 0) {
                                throw new PriceNotSetException("No price set for this item");
                            } else {
                                stock.remove(item);
                                recognised = true;
                                break;
                            }
                        }
                    }
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

    // Reserves a given quantity of bean bags based on ID.
    public int reserveBeanBags(int num, String id)
            throws BeanBagNotInStockException, InsufficientStockException, IllegalNumberOfBeanBagsReservedException,
            PriceNotSetException, BeanBagIDNotRecognisedException, IllegalIDException {

        return 0;
    }

    // Cancels a reservation of bean bags based on reservation number.
    public void unreserveBeanBags(int reservationNumber) throws ReservationNumberNotRecognisedException {

    }

    // Sells a number of beans bags according to a reservation.
    public void sellBeanBags(int reservationNumber) throws ReservationNumberNotRecognisedException {

    }

    // Returns the total number of bean bags in stock.
    public int beanBagsInStock() {
        return stock.size();
    }

    // Returns the total number of reserved bean bags in stock.
    public int reservedBeanBagsInStock() {
        return reserved.size();
    }


    // Returns the number of a type of bean bag in stock.
    public int beanBagsInStock(String id) throws BeanBagIDNotRecognisedException, IllegalIDException {
        // Starts the count to 0.
        int count = 0;
        BeanBag item;

        // Checks the given ID, and counts the number of those bean bags in stock.
        try {
            CheckID.validId(id);
            if (stock.size() == 0) {
                throw new BeanBagIDNotRecognisedException("Bean bag ID not found.");
            }
            for (int j = 0; j < stock.size(); j++) {
                item = (BeanBag) stock.get(j);
                if (item.getIdentifier().equals(id)) {
                    count += 1;
                }
            }
            return count;
        }
        // Throws an exception if the ID isn't a hexadecimal number.
        catch (NumberFormatException e) {
            throw new IllegalIDException("Invalid Hexadecimal Identifier - Not a hexadecimal number");
        }
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

    // Gets the details of a particular bean bag based on ID.
    public String getBeanBagDetails(String id) throws BeanBagIDNotRecognisedException, IllegalIDException {
        BeanBag item = null;
        boolean found = false;

        // Checks the given ID, and counts the number of those bean bags in stock.
        try {
            CheckID.validId(id);
            if (stock.size() == 0) {
                throw new BeanBagIDNotRecognisedException("Bean bag ID not found.");
            }
            for (int j = 0; j < stock.size(); j++) {
                item = (BeanBag) stock.get(j);
                if (item.getIdentifier().equals(id)) {
                    found = true;
                    break;
                }
            }
            if (found)  {
                return "[id=" + item.getIdentifier() + ",name=" + item.getName() +
                        ",manufacturer=" + item.getManufacturer() + ",year=" +
                        item.getYear() + ",month=" + item.getMonth() + ",information=" +
                        item.getInformation() + ",priceInPence=" + item.getPenceInPrice() +
                        "]";
            }
            throw new BeanBagIDNotRecognisedException("Bean bag ID not found.");
        }

        // Throws an exception if the ID isn't a hexadecimal number.
        catch (NumberFormatException e) {
            throw new IllegalIDException("Invalid Hexadecimal Identifier - Not a hexadecimal number");
        }
    }


    // Empties the stock of its contents.
    public void empty() {

    }

    // Resets the tracking of sales and costs.
    public void resetSaleAndCostTracking() {

    }

    // Replaces the ID of a bean bag with another given ID.
    public void replace(String oldId, String replacementId) throws BeanBagIDNotRecognisedException, IllegalIDException {

    }
}