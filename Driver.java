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
        // System.out.println(driver.beanBagsInStock("0000bbbb"));

        // Emptying stock.
        // driver.empty();
        // driver.array("a");

        // Getting bean bag details.
        // System.out.println(driver.getBeanBagDetails("0000bbbb"));

        // Getting number of unique bean bags.
        System.out.println(driver.getNumberOfDifferentBeanBagsInStock());
    }
}
