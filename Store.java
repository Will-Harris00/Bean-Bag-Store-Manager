package beanbags;

import org.jetbrains.annotations.NotNull;

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
    private ObjectArrayList sold = new ObjectArrayList();

    // If no information parameter mentioned, adds a bean bag with no
    // additional information.
    public void addBeanBags(int num, String manufacturer, String name, String id, short year, byte month)
            throws IllegalNumberOfBeanBagsAddedException, BeanBagMismatchException, IllegalIDException,
            InvalidMonthException {
        addBeanBags(num, manufacturer, name, id, year, month, "");
    }

    // Adds a bean bag to stock list.
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
        Checks.validID(id);
        for (int i = 0; i < num; i++) {
            BeanBag item = new BeanBag(manufacturer, name, id, year, month, information, 0);
            Checks.existingMismatch(item, stock);
            stock.add(item);
        }
    }

    // Sets the price of a bean bag in the stock list.
    public void setBeanBagPrice(String id, int priceInPence)
            throws InvalidPriceException, BeanBagIDNotRecognisedException, IllegalIDException {
        BeanBag item;
        // Assumes bean bag is unrecognised until it finds the bean bag with the
        // mentioned ID.
        boolean recognised = false;

        // Checks the given ID, and sets the price to that ID if valid.
        Checks.validID(id);
        if (priceInPence < 0)
            throw new InvalidPriceException("Price cannot be below zero pence.");
        for (int j = 0; j < stock.size(); j++) {
            item = (BeanBag) stock.get(j);
            if (item.getIdentifier().equalsIgnoreCase(id)) {
                item.setPenceInPrice(priceInPence);
                System.out.println(toString(item));
                recognised = true;
            }
        }

        // Throws an exception for unrecognised bean bags.
        if (!recognised)
            throw new BeanBagIDNotRecognisedException("Bean bag identifier '" + id + "' not recognised.");
    }

    // Sells a given quantity of a bean bag based on ID.
    public void sellBeanBags(int num, String id)
            throws BeanBagNotInStockException, InsufficientStockException, IllegalNumberOfBeanBagsSoldException,
            PriceNotSetException, BeanBagIDNotRecognisedException, IllegalIDException {
        // Checks if there is enough stock of that item to sell.
        Checks.validSale(num, id, beanBagsInStock(id));
        BeanBag item;
        boolean recognised = false;

        // Iterates over the stock and removes bean bags from the stock list one by one
        // (according to quantity sold) and into the sold list.
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < stock.size(); j++) {
                item = (BeanBag) stock.get(j);
                // Searches for matching IDs to find which bean bags to remove from stock list.
                if (item.getIdentifier().equalsIgnoreCase(id)) {
                    // Throws an exception if no price has been set for the bean bag.
                    if (item.getPenceInPrice() == 0) {
                        throw new PriceNotSetException("No price set for this item");
                    }
                    sold.add(item);
                    stock.remove(item);
                    recognised = true;
                    break;
                }
            }
        }

        // Throws an exception for unrecognised bean bags.
        if (!recognised)
            throw new BeanBagIDNotRecognisedException("Bean bag identifier '" + id + "' not recognised.");
    }

    // Reserves a given quantity of bean bags based on ID.
    public int reserveBeanBags(int num, String id)
            throws BeanBagNotInStockException, InsufficientStockException, IllegalNumberOfBeanBagsReservedException,
            PriceNotSetException, BeanBagIDNotRecognisedException, IllegalIDException {
        Checks.validReservation(num, id, beanBagsInStock(id));
        boolean recognised = false;
        /*
         * if (num <= 0) throw new
         * IllegalNumberOfBeanBagsReservedException("Cannot sell zero or fewer beanbags"
         * ); BeanBag item; boolean recognised = false; Checks.validID(id); int
         * available = beanBagsInStock(id); if (available == 0) throw new
         * BeanBagNotInStockException("None of these bean bags are available for reservation"
         * ); if (num > available) throw new
         * InsufficientStockException("Insufficient stock available for reservation");
         */

        // Iterates over the stock and removes bean bags from the stock list one by one
        // (according to quantity sold) and into the reserved list.
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < stock.size(); j++) {
                BeanBag item = (BeanBag) stock.get(j);
                if (item.getIdentifier().equalsIgnoreCase(id)) {
                    // Throws an exception if no price set for this item.
                    if (item.getPenceInPrice() == 0) {
                        throw new PriceNotSetException("No price set for this item");
                    }
                    Reservation r = new Reservation(item, reserved.size());
                    reserved.add(r);
                    stock.remove(item);
                    recognised = true;
                    break;
                }
            }
        }

        // Throws an exception for unrecognised bean bags.
        if (!recognised)
            throw new BeanBagIDNotRecognisedException("Bean bag identifier '" + id + "' not recognised.");
        return reserved.size();
    }

    // Cancels a reservation of bean bags based on reservation number.
    public void unreserveBeanBags(int reservationNumber) throws ReservationNumberNotRecognisedException {
        boolean recognised = false;

        // Iterates over the reserved items for a bean bag with a matching reservation
        // number and adds it back to the stock list, removing it from the reserved
        // list.
        for (int j = 0; j < reserved.size(); j++) {
            Reservation held = (Reservation) reserved.get(j);
            if (held.getReference() == reservationNumber) {
                stock.add(held.getAttributes());
                reserved.remove(held);
                recognised = true;
                break;
            }
        }

        // Throws an exception for unrecognised bean bags.
        if (!recognised)
            throw new ReservationNumberNotRecognisedException(
                    "Reservation reference '" + reservationNumber + "' not recognised.");
    }

    // Sells a number of beans bags according to a reservation number.
    public void sellBeanBags(int reservationNumber) throws ReservationNumberNotRecognisedException {
        Reservation held;
        boolean recognised = false;

        // Iterates over the stock and removes bean bags from the reserved list one by
        // one
        // (according to quantity sold).
        for (int j = 0; j < reserved.size(); j++) {
            held = (Reservation) reserved.get(j);
            // Searches for matching reservation numbers to find which bean bags to remove
            // from reserved list.
            if (held.getReference() == reservationNumber) {
                sold.add(held.getAttributes());
                reserved.remove(held);
                recognised = true;
                break;
            }
        }

        // Throws an exception for unrecognised reservations.
        if (!recognised)
            throw new ReservationNumberNotRecognisedException("This reservation number is invalid.");
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
        // Starts the count at 0.
        int count = 0;
        BeanBag item;

        Checks.validID(id);

        // Throws an exception if no bean bag with the matching ID was found.
        if (stock.size() == 0) {
            throw new BeanBagIDNotRecognisedException("Bean bag ID not found.");
        }

        // Iterates over the stock list and increments the count for each bean bag with
        // a matching ID.
        for (int j = 0; j < stock.size(); j++) {
            item = (BeanBag) stock.get(j);
            if (item.getIdentifier().equalsIgnoreCase(id)) {
                count += 1;
            }
        }
        return count;
    }

    // Permanently saves the store contents so it can be used in other programs.
    public void saveStoreContents(String filename) throws IOException {

    }

    // Loads the store contents from a previously saved store.
    public void loadStoreContents(String filename) throws IOException, ClassNotFoundException {

    }

    // Gets the number of unique bean bags (different types) in the stock list.
    public int getNumberOfDifferentBeanBagsInStock() {

        return 0;
    }

    // Gets the total number of sold bean bags using the sold list.
    public int getNumberOfSoldBeanBags() {
        return sold.size();
    }

    // Gets the total number of sold beans bags of a particular type (using ID)
    // using the sold list.
    public int getNumberOfSoldBeanBags(String id) throws BeanBagIDNotRecognisedException, IllegalIDException {
        // Starts the count at 0.
        int count = 0;
        BeanBag item;

        Checks.validID(id);

        // Throws an exception if the ID wasn't found to have been sold yet.
        if (sold.size() == 0) {
            throw new BeanBagIDNotRecognisedException("Bean bag ID not sold yet.");
        }

        // Iterates over the sold list to find how many bean bags of a particular type
        // (using ID) have been sold.
        for (int j = 0; j < sold.size(); j++) {
            item = (BeanBag) sold.get(j);
            if (item.getIdentifier().equalsIgnoreCase(id)) {
                count += 1;
            }
        }
        return count;
    }

    // Gets the total price of sold bean bags using the sold list.
    public int getTotalPriceOfSoldBeanBags() {
        BeanBag item;
        int count = 0;
        for (int j = 0; j < sold.size(); j++) {
            item = (BeanBag) sold.get(j);
            count += item.getPenceInPrice();
        }
        return count;
    }

    // Gets the total price of sold bean bags of a particular type (using ID) using
    // the sold list.
    public int getTotalPriceOfSoldBeanBags(String id) throws BeanBagIDNotRecognisedException, IllegalIDException {
        BeanBag item;
        boolean recognised = false;
        int count = 0;

        Checks.validID(id);

        // Iterates over the sold list and counts bean bags which have a matching ID.
        for (int j = 0; j < sold.size(); j++) {
            item = (BeanBag) sold.get(j);
            if (item.getIdentifier().equalsIgnoreCase(id)) {
                count += item.getPenceInPrice();
                recognised = true;
                break;
            }
        }

        // Throws an exception for unrecognised bean bags.
        if (!recognised)
            throw new BeanBagIDNotRecognisedException("Bean bag identifier '" + id + "' not recognised.");
        return count;
    }

    // Gets the total price of reserved bean bags of a particular type (using ID)
    // using
    // the reserved list.
    public int getTotalPriceOfReservedBeanBags() {
        int count = 0;
        for (int j = 0; j < reserved.size(); j++) {
            Reservation held = (Reservation) reserved.get(j);
            count += held.getAttributes().getPenceInPrice();
        }
        return count;
    }

    // Gets the details of a particular bean bag based on ID.
    public String getBeanBagDetails(String id) throws BeanBagIDNotRecognisedException, IllegalIDException {
        BeanBag item = null;
        boolean found = false;

        Checks.validID(id);

        // Throws an exception if there is no bean bag with the given ID.
        if (stock.size() == 0) {
            throw new BeanBagIDNotRecognisedException("Bean bag ID not found.");
        }

        // Iterates over the stock list to check for a bean bag with a matching ID.
        for (int j = 0; j < stock.size(); j++) {
            item = (BeanBag) stock.get(j);
            // Breaks out of the loop if a matching bean bag was found (other matching bean
            // bags should have the same details).
            if (item.getIdentifier().equalsIgnoreCase(id)) {
                found = true;
                break;
            }
        }
        // Returns the details of the first matching bean bag in the list.
        if (found) {
            return "[id=" + item.getIdentifier() + ",name=" + item.getName() + ",manufacturer=" + item.getManufacturer()
                    + ",year=" + item.getYear() + ",month=" + item.getMonth() + ",information=" + item.getInformation()
                    + ",priceInPence=" + item.getPenceInPrice() + "]";
        }
    }

    // Empties the stock of its contents.
    public void empty() {
        stock = null;
        stock = new ObjectArrayList();
        reserved = null;
        reserved = new ObjectArrayList();
        available = null;
        available = new ObjectArrayList();
        resetSaleAndCostTracking();
    }

    // Resets the tracking of sales and costs.
    public void resetSaleAndCostTracking() {
        sold = null;
        sold = new ObjectArrayList();
    }

    // Replaces the ID of a bean bag with another given ID.
    public void replace(String oldId, String replacementId) throws BeanBagIDNotRecognisedException, IllegalIDException {
        boolean found = false;

        // Checks that both of the inputted IDs are valid.
        Checks.validID(oldId);
        Checks.validID(replacementId);

        // Replaces the object IDs in each of these lists.
        ObjectArrayList[] objects = { stock, reserved, available, sold };
        BeanBag item;
        Reservation held;
        int i;
        ObjectArrayList obj;
        // Iterates over the lists one by one.
        for (i = 0; i < objects.length; i++) {
            // Accesses each element of array.
            obj = objects[i];

            // Updates the IDs in the stock list.
            if (obj == stock) {
                for (int j = 0; j < obj.size(); j++) {
                    item = (BeanBag) obj.get(j);
                    if (item.getIdentifier().equalsIgnoreCase(oldId)) {
                        item.setIdentifier(replacementId);
                        found = true;
                    }
                }
            }
            // Updates the IDs in the reserved list.
            else if (obj == reserved) {
                for (int j = 0; j < obj.size(); j++) {
                    held = (Reservation) obj.get(j);
                    item = held.getAttributes();
                    if (item.getIdentifier().equalsIgnoreCase(oldId)) {
                        item.setIdentifier(replacementId);
                        found = true;
                    }
                }
            }

        }
        // Throws an exception if the old ID hasn't been found.
        if (!found)
            throw new BeanBagIDNotRecognisedException("Bean bag ID not found.");
    }

    public String toString(BeanBag item) {
        return "[id=" + item.getIdentifier() + ",name=" + item.getName() + ",manufacturer=" + item.getManufacturer()
                + ",year=" + item.getYear() + ",month=" + item.getMonth() + ",information=" + item.getInformation()
                + ",priceInPence=" + item.getPenceInPrice() + "]";
    }

    public void array(String type) {
        switch (type.toLowerCase()) {
            case "stock":
            case "s":
                printArray(stock, "stock");
                break;
            case "reserved":
            case "r":
                printArray(reserved, "reserved");
                break;
            case "available":
            case "a":
                printArray(available, "available");
                break;
            case "sold":
            case "ss":
                printArray(sold, "sold");
                break;
        }
    }

    // Iterates through the given list (stock/reserved/available/sold) and prints
    // the bean bags in that list.
    public void printArray(ObjectArrayList obj, String type) {
        BeanBag item;
        Reservation held;
        System.out.println(obj.size());

        // If the object size is empty, let the user know.
        if (obj.size() == 0) {
            System.out.println("Empty");

        } else {
            if (type.equalsIgnoreCase("stock") || type.equalsIgnoreCase("available")
                    || type.equalsIgnoreCase("sold")) {
                for (int j = 0; j < obj.size(); j++) {
                    item = (BeanBag) obj.get(j);
                    System.out.println("[id=" + item.getIdentifier() + ",name=" + item.getName() + ",manufacturer="
                            + item.getManufacturer() + ",year=" + item.getYear() + ",month=" + item.getMonth()
                            + ",information=" + item.getInformation() + ",priceInPence=" + item.getPenceInPrice()
                            + "]");
                }
            } else if (type.equalsIgnoreCase("reserved")) {
                for (int j = 0; j < obj.size(); j++) {
                    held = (Reservation) obj.get(j);
                    item = held.getAttributes();
                    System.out.println("[id=" + item.getIdentifier() + ",name=" + item.getName() + ",manufacturer="
                            + item.getManufacturer() + ",year=" + item.getYear() + ",month=" + item.getMonth()
                            + ",information=" + item.getInformation() + ",priceInPence=" + item.getPenceInPrice()
                            + ",reference=" + held.getReference() + "]");
                }
            }
        }
    }
}
