package beanbags;

public class StoreDriverApp {
    public static void main(String[] args) throws IllegalIDException {
        BeanBagStore.addBeanBags();
        BeanBag item1 = new BeanBag("fd862033", "Beanie", "Argos", (short) 2019, (byte) 11, "This is an interesting beanbag");
        System.out.println(item1);
    }
}
