package databaseClasses;

import JavaClasses.OrderClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class OrdersDAO implements IOrdersDAO {

    Connection connection = Database.getConnection();

    //Add orders to restaurant's orders table
    @Override  
    public void AddOrderToRestaurantOrders(OrderClass order) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO restaurantorders (quantity,o_date,price,notes,restaurant_ID,customer_username)  VALUES (?,?,?,?,?,?)");
            ps.setInt(1, order.getQuantity());
            ps.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
            ps.setInt(3, order.getPrice());
            ps.setString(4, order.getNotes());
            ps.setInt(5, order.getRestaurantID());
            ps.setString(6, order.getCustomerUsername());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    //Add orders to ordered meals with quantity of each meal 
    @Override
    public void AddOrderToOrderedMeals(OrderClass order, ArrayList<String> selectedMeals, ArrayList<Integer> quantityOfSelectedMeals) {
        
        //enter each meal with its quantity
        Iterator<String> i1 = selectedMeals.iterator();
        Iterator<Integer> i2 = quantityOfSelectedMeals.iterator();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO orderedmeals VALUES ((select order_id from restaurantorders where  price=? and restaurant_id=? and customer_username=?),?,?)");
            ps.setInt(1, order.getPrice());
            ps.setInt(2, order.getRestaurantID());
            ps.setString(3, order.getCustomerUsername());
            while (i1.hasNext() && i2.hasNext()) {
                ps.setString(4, i1.next());
                ps.setInt(5, i2.next());
                ps.addBatch();
            }
            ps.executeBatch();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
//function to select all customer's orders using his username
    @Override 
    public void selectAllCustomerOrders(String customerUsername, JTable orders) {
        try {
            PreparedStatement ps = connection.prepareStatement("select orderedmeals.order_ID as ID, owner.restaurant_name as Restaurant,orderedmeals.meal_name as Name ,orderedmeals.quantity,meal.price , restaurantorders.notes from orderedmeals  , owner, meal  , restaurantorders where restaurantorders.customer_username=? and meal.restaurant_id=owner.restaurant_id and orderedmeals.order_id = restaurantorders.order_id and orderedmeals.meal_name = meal.meal_name");
            ps.setString(1, customerUsername);
            ResultSet resultSet = ps.executeQuery();
            orders.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //function to select all restaurant's order using the owner's username
    @Override
    public void selectAllRestaurantOrders(String ownerUsernme, JTable orders) {
        OwnerDAO ownerDAO = new OwnerDAO();

        try {
            PreparedStatement ps = connection.prepareStatement("select orderedmeals.order_ID as ID, restaurantorders.customer_username as Username,orderedmeals.meal_name as Name ,orderedmeals.quantity,meal.price , restaurantorders.notes from orderedmeals  , owner, meal  , restaurantorders where restaurantorders.restaurant_id=? and meal.restaurant_id=owner.restaurant_id and orderedmeals.order_id = restaurantorders.order_id and orderedmeals.meal_name = meal.meal_name");
            ps.setInt(1, ownerDAO.getRestaurantID(ownerUsernme));
            ResultSet resultSet = ps.executeQuery();
            orders.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
