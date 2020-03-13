// Driver application to test whether the backend code is working as intended.

package beanbags;

import java.io.IOException;


public class Driver {
    public static void main(String[] args) throws IllegalIDException, BeanBagMismatchException, InvalidMonthException,
            IllegalNumberOfBeanBagsAddedException, InvalidPriceException, BeanBagIDNotRecognisedException,
            PriceNotSetException, BeanBagNotInStockException, InsufficientStockException,
            IllegalNumberOfBeanBagsSoldException, IllegalNumberOfBeanBagsReservedException, ReservationNumberNotRecognisedException, IOException, ClassNotFoundException {
        Store driver = new Store();
        // Adding bean bags.

        driver.addBeanBags(2, "Manufacturer1", "BeanBagName1", "0000ffff", (short) 2001, (byte) 1);
        driver.addBeanBags(6, "Manufacturer1", "BeanBagName1", "0000bbbb", (short) 2001, (byte) 1, "information");
        driver.addBeanBags(6, "Manufacturer1", "BeanBagName1", "0000cccc", (short) 2001, (byte) 1, "information");
        driver.addBeanBags(1, "Manufacturer1", "BeanBagName1", "0000cccc", (short) 2001, (byte) 1, "information");

        // Bean bags in stock.
        System.out.println(driver.beanBagsInStock("0000bbbb"));

        // Emptying stock.
        // driver.empty();
        // driver.array("a");

        // Getting bean bag details.
        System.out.println(driver.getBeanBagDetails("0000bbbb"));

        // Getting number of unique bean bags.
        // System.out.println(driver.getNumberOfDifferentBeanBagsInStock());

        // Getting number of total sales.
        // driver.setBeanBagPrice("0000cccc", 5);
        // driver.sellBeanBags(3, "0000cccc");
        // driver.setBeanBagPrice("0000bbbb", 3);
        // driver.sellBeanBags(2, "0000bbbb");
        // System.out.println(driver.getNumberOfSoldBeanBags());
        // System.out.println(driver.getNumberOfSoldBeanBags("0000cccc"));

        // Getting total price of reserved bean bags.
        // driver.setBeanBagPrice("0000bbbb", 5);
        // driver.reserveBeanBags(3, "0000bbbb");
        // driver.setBeanBagPrice("0000cccc", 3);
        // driver.reserveBeanBags(2, "0000cccc");
        // System.out.println(driver.getTotalPriceOfReservedBeanBags());

        // Getting total price of sold bean bags.
        driver.setBeanBagPrice("0000cccc", 5);
        driver.sellBeanBags(1, "0000cccc");
        driver.setBeanBagPrice("0000bbbb", 3);
        driver.sellBeanBags(2, "0000bbbb");
        System.out.println(driver.getTotalPriceOfSoldBeanBags("0000cccc"));

        // Saving store contents.
        // driver.saveStoreContents("filename");
        // driver.array("a");
        // driver.empty();
        // driver.array("a");
        // driver.loadStoreContents("filename");
        // driver.array("a");

        // Replacing an ID.
        // driver.array("a");
        // driver.replace("0000bbbb", "0000dddd");
        // driver.array("a");

        // Reserving bean bags.
        driver.addBeanBags(10, "Manufacturer2", "Name3", "0000bcbc", (short) 2002, (byte) 2);
        System.out.println(driver.reserveBeanBags(3, "0000cccc")); 
        System.out.println(driver.reserveBeanBags(4, "0000bbbb")); 
        
        // Getting number of reserved bean bags in stock.
        // System.out.println(driver.reservedBeanBagsInStock());

        // Reset sale and cost tracking.
        // driver.resetSaleAndCostTracking();
        // driver.array("s");

        // Selling bean bags from reservations.
        // driver.sellBeanBags(2);
        // driver.array("s");

        // Setting the price of a bean bag.
        driver.setBeanBagPrice("0000cccc", 4);
        driver.array("a");
        System.out.println(driver.reserveBeanBags(1, "0000cccc")); 
        driver.setBeanBagPrice("0000cccc", 2);
        driver.array("a");
        driver.array("r");

        // Unreserve bean bags.
        driver.unreserveBeanBags(2);
        driver.array("a");
        driver.array("r");


        driver.empty();
        driver.addBeanBags(4, "Man", "Apple", "0000dfdf", (short) 2001, (byte) 2);
        driver.setBeanBagPrice("0000dfdf", 6565);
        driver.reserveBeanBags(2, "0000dfdf");
        driver.setBeanBagPrice("0000dfdf", 6000);
        driver.array("r");
        driver.array("a");
        driver.sellBeanBags(1, "0000dfdf");
        driver.sellBeanBags(0);
        driver.unreserveBeanBags(1);
        driver.reserveBeanBags(2, "0000dfdf");
        driver.array("s");
        driver.array("a");
        driver.array("r");
        driver.addBeanBags(1, "Man", "Apple", "0000dfdf", (short) 2001, (byte) 2);
        driver.setBeanBagPrice("0000dfdf",123);
        driver.reserveBeanBags(1, "0000dfdf");
        driver.array("s");
        driver.array("a");
        driver.array("r");
        driver.empty();
        System.out.println("\n\n");
        driver.addBeanBags(4, "M", "A", "0000eeee", (short) 2001, (byte) 2);
        driver.setBeanBagPrice("0000eeee", 8888);
        driver.reserveBeanBags(2, "0000eeee");
        driver.reserveBeanBags(2, "0000eeee");
        driver.array("s");
        driver.array("a");
        driver.array("r");
        System.out.println(driver.getNumberOfDifferentBeanBagsInStock());


    }
}
