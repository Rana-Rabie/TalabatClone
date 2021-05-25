package JavaClasses;

public class Owner extends Person {

    private String resturantName;
    private int restaurantID;

    public Owner() {
    }

    //setters
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public void setResturantName(String resturantName) {
        this.resturantName = resturantName;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    //getters
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public String getResturantName() {
        return resturantName;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

}
