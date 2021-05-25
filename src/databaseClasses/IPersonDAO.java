package databaseClasses;

import JavaClasses.Person;

public interface IPersonDAO {

    boolean LogIn(String username, String password);

    boolean Register(Person person);

    char getPersonType(String Username);

}
