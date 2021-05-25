package databaseClasses;

import java.sql.*;
import JavaClasses.Owner;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class OwnerDAO implements IOwnerDAO {

    Connection connection = Database.getConnection();

    // function for owners' registeration 
    @Override
    public boolean Register(Owner owner) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Owner (Owner_Username, Restaurant_Name)  VALUES ((select username from Person where username = ?),?)");
            ps.setString(1, owner.getUsername());
            ps.setString(2, owner.getResturantName());

            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();;
        }

        return false;
    }

    //function to get the restaurant id of a certain owner
    @Override
    public int getRestaurantID(String username) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT Restaurant_ID FROM Owner where owner_username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            int RestaurantID = 0;
            if (rs.next()) {
                RestaurantID = rs.getInt(1);
            }
            return RestaurantID;
        } catch (SQLException ex) {
            ex.printStackTrace();;
        }
        return 0;
    }

    //function to get the restaurant's name using restaurant's id
    @Override
    public String getRestaurantName(int restaurantID) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT Restaurant_Name FROM Owner where Restaurant_ID = ?");
            ps.setInt(1, restaurantID);
            ResultSet rs = ps.executeQuery();
            String name = null;
            if (rs.next()) {
                name = rs.getString(1);
            }
            return name;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    //function to select all restaurants in the database
    @Override
    public void selectAllRestaurants(JTable Restaurants) {
        try {
            PreparedStatement ps = connection.prepareStatement("Select Restaurant_Name as Restaurants from Owner ");
            ResultSet resultSet = ps.executeQuery();
            Restaurants.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    //function to get the restaurant's id using the restaurant's name
    @Override    
    public int RestaurantID(String restaurantName) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT Restaurant_ID FROM Owner where Restaurant_Name = ?");
            ps.setString(1, restaurantName);
            ResultSet rs = ps.executeQuery();
            int RestaurantID = 0;
            if (rs.next()) {
                RestaurantID = rs.getInt(1);
            }
            return RestaurantID;
        } catch (SQLException ex) {
            ex.printStackTrace();;
        }
        return 0;
    }

    //function to get the owner's username using the restaurant's name
    @Override
    
    public String getOwnerUsername(String restaurantName) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT owner_username FROM Owner where Restaurant_name = ?");
            ps.setString(1, restaurantName);
            ResultSet rs = ps.executeQuery();
            String name = null;
            if (rs.next()) {
                name = rs.getString(1);
            }
            return name;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
