// Enables access and changing of all attributes of bean bag objects.

package beanbags;

import java.io.Serializable;

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
     * Constructor for initialising bean bag objects.
     * Bean bag objects contain the following attributes.
     *
     * @param manufacturer the maker of the beanbag.
     * @param name         the given name of the beanbag.
     * @param id           a unique identifier for identical beanbags.
     * @param year         the year of manufacturer.
     * @param month        the month of manufacturer.
     * @param information  optional free text component containing further details.
     * @param priceInPence price in pence.
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
     * @return returns the identifier associated with a particular beanbag.
     *
     */
    public String getIdentifier() {
        return id;
    }

    /**
     * Public getter method for bean bag manufacturer.
     *
     * @return returns the manufacturer of a bean bag.
     *
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Public getter method for optional information.
     *
     * @return returns the free text component of a bean bag.
     *
     */
    public String getInformation() {
        return information;
    }

    /**
     * Public getter method for month of production.
     *
     * @return returns the production month of a bean bag.
     *
     */
    public byte getMonth() {
        return month;
    }

    /**
     * Public getter method for retrieving the name.
     *
     * @return returns the name of a bean bag.
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Public getter method for the cost of a bean bag in pence.
     *
     * @return returns the price in pence of a bean bag.
     *
     */
    public int getPriceInPence() {
        return priceInPence;
    }

    /**
     * Public getter method for year of production.
     *
     * @return returns the production year of a bean bag.
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
     * Public setter method for optional information. Method included for future development.
     *
     * @param information updates the identifier associated with a particular beanbag.
     *
     */
    public void setInformation(String information) {
        this.information = information;
    }

    /**
     * Public setter method for maker of the beanbag. Method included for future development.
     *
     * @param manufacturer updates the maker of the bean bag.
     *
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Public setter method for month of production. Method included for future development.
     *
     * @param month updates the month of production.
     *
     */
    public void setMonth(byte month) {
        this.month = month;
    }

    /**
     * Public setter method for name of bean bag. Method included for future development.
     *
     * @param name updates the name.
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Public setter method for editing the price of a bean bag.
     *
     * @param priceInPence changes the price of an item.
     *
     */
    public void setPriceInPence(int priceInPence) {
        this.priceInPence = priceInPence;
    }

    /**
     * Public setter method for year of production. Method included for future development.
     *
     * @param year updates the month of production.
     *
     */
    public void setYear(short year) {
        this.year = year;
    }
}
