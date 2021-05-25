package databaseClasses;

import JavaClasses.Person;
import java.sql.*;

public class PersonDAO implements IPersonDAO {

    Connection connection = Database.getConnection();

    //function to match the entered data with already existing enteries in the database
    @Override
    public boolean LogIn(String username, String pass) {

        try {
            PreparedStatement ps = connection.prepareStatement("Select * From Person WHERE Username = ? AND Password = ?");
            ps.setString(1, username);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();;
        }

        return false;

    }

     //function for registeration of new users
    @Override
    public boolean Register(Person person) {

        try {
            PreparedStatement ps = connection.prepareStatement("insert into Person values(?,?,?,?)");
            ps.setString(1, person.getUsername());
            ps.setString(2, person.getEmail());
            ps.setString(3, person.getPassword());
            ps.setString(4, String.valueOf(person.getType()));
            int i = ps.executeUpdate();

            if (i > 0) {

                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

     //function to get the person's type (C/O)
    @Override
    public char getPersonType(String Username) {
        try {
            PreparedStatement ps = connection.prepareStatement("Select persontype from person where username=?");
            ps.setString(1, Username);
            char type = ' ';
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                type = rs.getString(1).charAt(0);
            }
            return type;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ' ';
    }

}
