package beanbags;

public class BeanBag {
    // private instance variables
    private String id;
    private String name;
    private String manufacturer;
    private short year;
    private byte month;
    private int penceInPrice;
    private String information;


    // Constructor: initialise name, email, gender with given values
    public BeanBag(String id, String name, String manufacturer, short year, byte month, int priceInPence, String information) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.year = year;
        this.month = month;
        this.penceInPrice = priceInPence;
        this.information = information;
    }



    // public getters for private instance
    public String getIdentifier() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public short getYear() {
        return year;
    }

    public byte getMonth() {
        return month;
    }

    public int getPenceInPrice() {
        return penceInPrice;
    }

    public String getInformation() {
        return information;
    }



    // public setters for private instance
    public void setIdentifier(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public void setMonth(byte month) {
        this.month = month;
    }

    public void setPenceInPrice(int priceInPence) {
        this.penceInPrice = priceInPence;
    }

    public void setInformation(String information) {
        this.information = information;
    }



    // method: toString
    public String toString() {
        return "[id=" + id + ",name=" + name + ",manufacturer=" + manufacturer + ",year=" + year +
                ",month=" + month +",priceInPence=" + penceInPrice + ",information=" + information +"]";
    }
}
