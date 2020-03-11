// Driver application to test whether the backend code is working as intended.

package beanbags;

public class StoreDriverApp {
    public static void main(String[] args) throws IllegalIDException, BeanBagMismatchException, InvalidMonthException,
            IllegalNumberOfBeanBagsAddedException, InvalidPriceException, BeanBagIDNotRecognisedException,
            PriceNotSetException, BeanBagNotInStockException, InsufficientStockException,
            IllegalNumberOfBeanBagsSoldException, IllegalNumberOfBeanBagsReservedException, ReservationNumberNotRecognisedException {
        Store driver = new Store();
        // Tests the various methods in the backend code.
        driver.addBeanBags(2, "Argos", "Beanie", "0000ffff", (short) 2019, (byte) 11);
        driver.addBeanBags(1, "Argos", "Beanie", "0000AAAA", (short) 2019, (byte) 12, "Test");
        driver.addBeanBags(1, "Argos", "Beanie", "0000afff", (short) 2019, (byte) 11);
        driver.addBeanBags(1, "Argos", "Beanie", "0000afff", (short) 2019, (byte) 11);
        driver.addBeanBags(3, "Argos", "Beanie", "0000bbbb", (short) 2019, (byte) 11);
        driver.setBeanBagPrice("0000afff", 9999);
        driver.setBeanBagPrice("0000ffff", 7500);
        driver.setBeanBagPrice("0000bbbb", 6666);

        driver.array("a");

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
        driver.array("a");
        driver.array("r");
        System.out.println("marker");
        driver.reserveBeanBags(1, "0000bbbb");
        driver.array("r");
        System.out.println("Reservation reference number: " + (driver.reserveBeanBags(1, "0000bbbb")));
        System.out.println("Reservation reference number: " + (driver.reserveBeanBags(1, "0000bbbb")));
        // System.out.println("Reservation reference number: " + (driver.reserveBeanBags(1, "0000bbbb")));
        // driver.reserveBeanBags(3, "0000afff");
        // driver.array("r");
        System.out.println("\n\n");

        // driver.unreserveBeanBags(2);
        driver.array("a");
        System.out.println("\n\n");
        driver.array("r");
        System.out.println("\n\n");
        driver.array("a");
        System.out.println("\n\n");
        // driver.unreserveBeanBags(5);


        System.out.println("\n\n");
        driver.array("a");
        driver.empty();
        System.out.println("The store has been emptied\n\n");
        driver.addBeanBags(1, "Argos", "Beanie", "0000bbbb", (short) 2019, (byte) 11);
        driver.addBeanBags(3, "Argos", "Beanie", "0000CCCC", (short) 2019, (byte) 11);
        driver.addBeanBags(5, "Argos", "Beanie", "0000ABAB", (short) 2019, (byte) 11);
        driver.setBeanBagPrice("0000bbbb", 5555);
        driver.setBeanBagPrice("0000cccc", 7777);
        driver.setBeanBagPrice("0000ABAB", 1212);
        // driver.addBeanBags(5, "Argos", "Beanie", "0000ABAB", (short) 2019, (byte) 11);
        driver.reserveBeanBags(1, "0000bbbb");
        driver.reserveBeanBags(1, "0000cccc");
        driver.reserveBeanBags(1, "0000cccc");
        driver.reserveBeanBags(1, "0000cccc");

        driver.array("a");

        driver.replace("0000CCCC","0000eeee");
        driver.array("a");

        driver.replace("0000bbbb","0000efef");
        driver.array("r");

        driver.sellBeanBags(0);
        driver.sellBeanBags(1);
        System.out.println(driver.getTotalPriceOfReservedBeanBags());
        driver.array("r");
        driver.array("s");
        System.out.println("Number of 0000efef sold: " + driver.getNumberOfSoldBeanBags("0000efef"));

        System.out.println(driver.getTotalPriceOfSoldBeanBags());
        System.out.println(driver.getTotalPriceOfSoldBeanBags("0000efef"));
        driver.sellBeanBags(3, "0000ABAB");
        System.out.println("Total number price of ABAB sold = " + driver.getTotalPriceOfSoldBeanBags("0000ABAB"));

        /*
        driver.addBeanBags(4, "Argos", "Beanie", "0000dddd", (short) 2019, (byte) 11, "This is a bean bag");
        driver.setBeanBagPrice("0000dddd", 8888);
        driver.array("a");
        System.out.println("\n");
        driver.reserveBeanBags(2, "0000dddd");
        driver.array("r");
        System.out.println("\n");
        driver.sellBeanBags(2, "0000dddd");
        driver.array("s");
        driver.sellBeanBags(0);
        driver.sellBeanBags(1);
        driver.array("s");

         */
        System.out.println("\n\n");
        driver.array("a");
        driver.array("r");
        System.out.println(driver.beanBagsInStock());
        System.out.println(driver.reserveBeanBags(1,"0000ABAB"));
        System.out.println(driver.beanBagsInStock("0000eeee"));
        System.out.println(driver.reserveBeanBags(1,"0000ABAB"));
        driver.unreserveBeanBags(0);
        driver.addBeanBags(1, "Argos", "Beanie", "0000bbbb", (short) 2019, (byte) 11);
        driver.addBeanBags(3, "Argos", "Beanie", "0000CCCC", (short) 2019, (byte) 11);
        driver.addBeanBags(5, "Argos", "Beanie", "0000ABAB", (short) 2019, (byte) 11);
        driver.setBeanBagPrice("0000CCCC", 5252);
        driver.addBeanBags(1, "Argos", "Beanie", "0000CCCC", (short) 2019, (byte) 11);
        driver.addBeanBags(1, "Argos", "Beanie", "0000ABCD", (short) 209, (byte) 11);
        driver.array("a");
        driver.array("r");
        driver.reserveBeanBags(1, "0000ABAB");
        // driver.addBeanBags(3, "Argo", "Beanie", "0000eeee", (short) 2019, (byte) 11);
        System.out.println(driver.getNumberOfDifferentBeanBagsInStock());
        driver.array("s");
        System.out.println(driver.getTotalPriceOfSoldBeanBags());
        System.out.println(driver.getTotalPriceOfSoldBeanBags("0000ABAB"));
        System.out.println(driver.getNumberOfSoldBeanBags());
        System.out.println(driver.getNumberOfSoldBeanBags("0000ABAB"));
        driver.setBeanBagPrice("0000ABAB", 1);
        driver.sellBeanBags(2, "0000ABAB");
        System.out.println(driver.getTotalPriceOfSoldBeanBags());
        System.out.println(driver.getTotalPriceOfSoldBeanBags("0000ABAB"));
        System.out.println(driver.getNumberOfSoldBeanBags());
        System.out.println(driver.getNumberOfSoldBeanBags("0000ABAB"));
        driver.array("a");
        driver.array("s");

    }
}
