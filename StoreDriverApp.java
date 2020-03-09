package beanbags;

public class StoreDriverApp {
    public static void main(String[] args) throws IllegalIDException, BeanBagMismatchException, InvalidMonthException, IllegalNumberOfBeanBagsAddedException {
        Store driver = new Store();
        driver.addBeanBags(12, "Argos", "Beanie", "0000ffff", (short) 2019, (byte) 11);
        driver.addBeanBags(1, "Argos", "Beanie", "0000AAAA", (short) 2019, (byte) 12, "Test");
        driver.viewObj();
    }
}
