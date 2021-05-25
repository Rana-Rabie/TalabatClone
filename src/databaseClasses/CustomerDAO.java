package databaseClasses;

import JavaClasses.Customer;
import java.sql.*;

public class CustomerDAO implements ICustomerDAO {

    Connection connection = Database.getConnection();

    //function for registeration of new customers
    @Override
    public boolean Register(Customer customer) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Customer VALUES ((select username from Person where username = ?),?,?)");
            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getMobNum());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

}
