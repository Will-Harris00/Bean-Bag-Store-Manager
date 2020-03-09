package beanbags;

public class BeanBag {
    // private instance variables
    private String manufacturer;
    private String name;
    private String id;
    private short year;
    private byte month;
    private String information;
    private int penceInPrice;

    // Constructor: initialise name, email, gender with given values
    public BeanBag(String manufacturer, String name, String id, short year, byte month, String information, int penceInPrice) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.id = id;
        this.year = year;
        this.month = month;
        this.information = information;
        this.penceInPrice = penceInPrice;
        // priceInPence will be initialised with value zero so does not need to be declared here
    }


    // public getters for private instance
    public String getManufacturer() {
        return manufacturer;
    }

    public String getName() {
        return name;
    }

    public String getIdentifier() {
        return id;
    }

    public short getYear() {
        return year;
    }

    public byte getMonth() {
        return month;
    }

    public String getInformation() {
        return information;
    }

    public int getPenceInPrice() {
        return penceInPrice;
    }


    // public setters for private instance
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdentifier(String id) {
        this.id = id;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public void setMonth(byte month) {
        this.month = month;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setPenceInPrice(int priceInPence) {
        this.penceInPrice = priceInPence;
    }


    // method: toString
    public String toString() {
        return "[id=" + id + ",name=" + name + ",manufacturer=" + manufacturer + ",year=" + year +
                ",month=" + month + ",information=" + information + ",priceInPence=" + penceInPrice + "]";
    }
}
