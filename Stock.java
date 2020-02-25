package beanbags;

public class Stock {
    // private variable initialized
    private String manufacturer;
    private String name;
    private double price;
    private int year;
    private int month;
    private String description;

    // Constructor: initialise manufacturer, name, price, quantity, year and moth of manufacturer, as well as the price
    public Stock(String manufacturer, String name, double price, int year, int month) {
        this.name = manufacturer;
        this.name = name;
        this.price = price;
        this.year = year;
        this.month = month;
    }

    // Constructor: initialise manufacturer, name, price, quantity, year and moth of manufacturer, as well as the price,
    // this method differs slightly from the above as in also includes reference to the free text component
    // when the constructor method is invoked the program will select the correct version of the method based on the
    // number of variable that are passed to the method with the description included this would be six variables.
    public Stock(String manufacturer, String name, double price, int year, int month, String description) {
        this.name = manufacturer;
        this.name = name;
        this.price = price;
        this.year = year;
        this.month = month;
        this.description = description;
    }

    // public getters and setters for private instance
    public String getName() {
        return name;
    }
}