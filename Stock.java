// Class for storing the stock of bean bags.
package beanbags;

public class Stock {
    // Private variables initialized.
    private String manufacturer;
    private String name;
    private double price;
    private int year;
    private int month;
    private String description;

    // Constructor: initialise manufacturer, name, price, quantity, year and moth of
    // manufacturer, as well as the price.
    public Stock(String manufacturer, String name, double price, int year, int month) {
        this.name = manufacturer;
        this.name = name;
        this.price = price;
        this.year = year;
        this.month = month;
    }

    // Constructor: initialise manufacturer, name, price, quantity, year and month of
    // manufacturer, as well as the price.
    // This method differs slightly from the above as in also includes reference to
    // the free text component.
    // When the constructor method is invoked, the program will select the correct
    // version of the method based on the number of variables that are passed to the
    // method.
    public Stock(String manufacturer, String name, double price, int year, int month, String description) {
        this.name = manufacturer;
        this.name = name;
        this.price = price;
        this.year = year;
        this.month = month;
        this.description = description;
    }

    // Public getters for private instances.
    public String getName() {
        return name;
    }
}