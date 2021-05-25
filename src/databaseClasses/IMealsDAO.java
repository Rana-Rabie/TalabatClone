package databaseClasses;

import JavaClasses.Meal;

import javax.swing.*;

public interface IMealsDAO {

    public boolean AddMeal(Meal meal);

    public void deleteMeal(Meal meal);

    public void editMeal(Meal meal);

    public void getallmeals(int restaurantid, JTable meals);

    public void getallmeals(String restaurantName, JComboBox jc);

    public int getmealprice(String name);

}
