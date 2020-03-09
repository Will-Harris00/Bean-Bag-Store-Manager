// Driver application to test whether the backend code is working as intended.

package beanbags;

public class StoreDriverApp {
    public static void main(String[] args) throws IllegalIDException, BeanBagMismatchException, InvalidMonthException, IllegalNumberOfBeanBagsAddedException, InvalidPriceException, BeanBagIDNotRecognisedException, PriceNotSetException, BeanBagNotInStockException, InsufficientStockException, IllegalNumberOfBeanBagsSoldException {
        Store driver = new Store();
        // Tests the various methods in the backend code.
        driver.addBeanBags(2, "Argos", "Beanie", "0000ffff", (short) 2019, (byte) 11);
        driver.addBeanBags(1, "Argos", "Beanie", "0000AAAA", (short) 2019, (byte) 12, "Test");
        driver.addBeanBags(1, "Argos", "Beanie", "0000afff", (short) 2019, (byte) 11);
        driver.addBeanBags(1, "Argos", "Beanie", "0000afff", (short) 2019, (byte) 11);
        driver.setBeanBagPrice("0000afff", 9999);
        driver.setBeanBagPrice("0000ffff", 7500);
        driver.array();
        // System.out.println(driver.beanBagsInStock());
        // System.out.println(driver.getBeanBagDetails("0000afff"));
        // System.out.println(driver.getBeanBagDetails("0000abff"));
        // System.out.println(driver.getBeanBagDetails("0000afhf"));
        // System.out.println(driver.beanBagsInStock("0000ffff"));
        // driver.sellBeanBags(-1, "0000ffff");
        // driver.sellBeanBags(3, "0000ffff");
        // driver.sellBeanBags(4, "0000feff");
        // driver.sellBeanBags(0, "0000ffff");
        driver.sellBeanBags(1, "0000ffff");

        driver.array();

    }
}
