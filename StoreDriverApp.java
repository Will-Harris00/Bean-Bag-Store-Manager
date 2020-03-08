package beanbags;

public class StoreDriverApp {
    public static void main(String[] args) throws IllegalIDException, BeanBagMismatchException, InvalidMonthException, IllegalNumberOfBeanBagsAddedException {
        Store driver = new Store();
        driver.addBeanBags(12, "Argos", "Beanie", "0000ffff", (short) 2019, (byte) 11, "Additional information");
        driver.addBeanBags(13, "Argos", "Beanie", "0000AAAA", (short) 2019, (byte) 13);
    }
}
