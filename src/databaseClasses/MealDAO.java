 package databaseClasses;

import JavaClasses.Meal;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;



public class MealDAO implements IMealsDAO {

    Connection connection = Database.getConnection();

    //function to add new meals in the owner's restaurant
    @Override
    public boolean AddMeal(Meal meal) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Meal (MEAL_NAME, DESCRIPTION, PRICE, RESTAURANT_ID)  VALUES (?,?,?,(Select restaurant_id from owner where restaurant_id = ?))");
            ps.setString(1, meal.getName());
            ps.setString(2, meal.getDescription());
            ps.setInt(3, meal.getPrice());
            ps.setInt(4, meal.getResturantID());
            int i = ps.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    //function to delete meals from the owner's restaurant
    @Override
    public void deleteMeal(Meal meal) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM MEAL WHERE meal_name = ?");
            ps.setString(1, meal.getName());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    //function to edit meals in the owner's restaurant
    @Override
    public void editMeal(Meal meal) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE MEAL SET Description = ?,price = ? WHERE meal_name = ?");
            ps.setString(1, meal.getDescription());
            ps.setInt(2, meal.getPrice());
            ps.setString(3, meal.getName());

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //function to get all meals from the database of a certain restaurant using its id
    @Override
    public void getallmeals(int restaurantID, JTable meals) {
        try {
            PreparedStatement ps = connection.prepareStatement("Select meal_name as Name,description  ,price  from meal where restaurant_id=?");
            ps.setInt(1, restaurantID);
            ResultSet resultSet = ps.executeQuery();
            meals.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //function to get all meals from the database of a certain restaurant using its name
    @Override
    public void getallmeals(String restaurantName, JComboBox jc) {
        try {
            PreparedStatement ps = connection.prepareStatement("Select meal_name from meal where restaurant_id=(SELECT restaurant_id FROM owner WHERE restaurant_name=?)");
            ps.setString(1, restaurantName);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                jc.addItem(resultSet.getString("meal_name"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //function to get each meal's price using its name
    @Override

    public int getmealprice(String name) {
        try {
            PreparedStatement ps = connection.prepareStatement("Select price from meal where meal_name=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            int price = 0;
            if (rs.next()) {
                price = rs.getInt(1);
            }
            return price;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }
}
