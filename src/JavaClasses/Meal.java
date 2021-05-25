package JavaClasses;

public class Meal {

    private int ID;
    private String name;
    private String description;
    private int Price;
    private int resturantID;

    public Meal() {
    }

    //setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public void setResturantID(int resturantID) {
        this.resturantID = resturantID;
    }

    //getters
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return Price;
    }

    public int getResturantID() {
        return resturantID;
    }

}
