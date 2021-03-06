import java.io.Serializable;

/**
 * BeanBag class which implements Serializable. Creates a new instance of a bean
 * bag object and changes/returns their respective attributes using
 * setter/getter methods.
 *
 * @author 680033128
 * @author 690065435
 * @version 1.1
 *
 *
 */

public class BeanBag implements Serializable {
    // Private instance variables.
    private String manufacturer;
    private String name;
    private String id;
    private short year;
    private byte month;
    private String information;
    private int priceInPence;

    /**
     * Constructor for initialising bean bag objects. Bean bag objects contain the
     * following attributes.
     *
     * @param manufacturer Maker of the beanbag.
     * @param name         Given name of the beanbag.
     * @param id           Unique identifier for identical beanbags.
     * @param year         Year of manufacturer.
     * @param month        Month of manufacturer.
     * @param information  Optional free text component containing further details.
     * @param priceInPence Price in pence.
     *
     */
    public BeanBag(String manufacturer, String name, String id, short year, byte month, String information,
            int priceInPence) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.id = id;
        this.year = year;
        this.month = month;
        this.information = information;
        this.priceInPence = priceInPence;
    }

    /**
     * Public getter method for unique identifiers.
     *
     * @return Returns the identifier associated with a particular beanbag.
     *
     */
    public String getIdentifier() {
        return id;
    }

    /**
     * Public getter method for bean bag manufacturer.
     *
     * @return Returns the manufacturer of a bean bag.
     *
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Public getter method for optional information.
     *
     * @return Returns the free text component of a bean bag.
     *
     */
    public String getInformation() {
        return information;
    }

    /**
     * Public getter method for month of production.
     *
     * @return Returns the production month of a bean bag.
     *
     */
    public byte getMonth() {
        return month;
    }

    /**
     * Public getter method for retrieving the name.
     *
     * @return Returns the name of a bean bag.
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Public getter method for the cost of a bean bag in pence.
     *
     * @return Returns the price in pence of a bean bag.
     *
     */
    public int getPriceInPence() {
        return priceInPence;
    }

    /**
     * Public getter method for year of production.
     *
     * @return Returns the production year of a bean bag.
     *
     */
    public short getYear() {
        return year;
    }

    /**
     * Public setter method for unique identifiers.
     *
     * @param id updates the identifier associated with a particular beanbag.
     *
     */
    public void setIdentifier(String id) {
        this.id = id;
    }

    /**
     * Public setter method for optional information. Method included for future
     * development.
     *
     * @param information Updates the identifier associated with a particular
     *                    beanbag.
     *
     */
    public void setInformation(String information) {
        this.information = information;
    }

    /**
     * Public setter method for maker of the beanbag. Method included for future
     * development.
     *
     * @param manufacturer Updates the maker of the bean bag.
     *
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Public setter method for month of production. Method included for future
     * development.
     *
     * @param month Updates the month of production.
     *
     */
    public void setMonth(byte month) {
        this.month = month;
    }

    /**
     * Public setter method for name of bean bag. Method included for future
     * development.
     *
     * @param name Updates the name.
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Public setter method for editing the price of a bean bag.
     *
     * @param priceInPence Changes the price of an item.
     *
     */
    public void setPriceInPence(int priceInPence) {
        this.priceInPence = priceInPence;
    }

    /**
     * Public setter method for year of production. Method included for future
     * development.
     *
     * @param year Updates the month of production.
     *
     */
    public void setYear(short year) {
        this.year = year;
    }
}
