package databaseClasses;

import JavaClasses.Owner;
import javax.swing.JTable;

public interface IOwnerDAO {

    boolean Register(Owner owner);

    public int getRestaurantID(String username);

    public int RestaurantID(String restaurantName);

    public String getRestaurantName(int restaurantID);

    public void selectAllRestaurants(JTable meals);

    public String getOwnerUsername(String restaurantName);

}
