package databaseClasses;

import JavaClasses.OrderClass;
import java.util.ArrayList;
import javax.swing.JTable;

public interface IOrdersDAO {

    public void AddOrderToRestaurantOrders(OrderClass order);

    public void AddOrderToOrderedMeals(OrderClass order, ArrayList<String> selectedMeals, ArrayList<Integer> quantityOfSelectedMeals);

    public void selectAllCustomerOrders(String customerUsername, JTable orders);

    public void selectAllRestaurantOrders(String restaurantName, JTable orders);

}
