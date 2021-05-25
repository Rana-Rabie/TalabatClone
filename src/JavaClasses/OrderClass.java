package JavaClasses;

public class OrderClass {

    private String Meal;
    private int orderID;
    private int quantity;
    private String date;
    private int price;
    private String notes;
    private String customerUsername;
    private int restaurantID;
    private int totalPrice;

    public OrderClass() {
    }

    //Setters
    public void setMeal(String Meal) {
        this.Meal = Meal;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    //Getters
    public String getMeal() {
        return Meal;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }

    public String getNotes() {
        return notes;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

}
