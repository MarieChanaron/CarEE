package fr.mariech.voitures.dbconnect;

import fr.mariech.voitures.model.Car;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    private final Connection connectionToDb = ConnectionManager.openConnection();

    public List<Car> fetchCars() {
        List<Car> cars = new ArrayList<>();
        try {
            String query = "SELECT car.name, description, image, category.name, price FROM car INNER JOIN category WHERE category.id = car.category";
            Statement statement = connectionToDb.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String name = results.getString(1);
                String description = results.getString(2);
                String image = results.getString(3);
                String category = results.getString(4);
                double price = results.getDouble(5);
                Car car = new Car(name, description, image, category, price);
                System.out.println(car);
                System.out.println(car);
                cars.add(car);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return cars;
    }

    public void insertCar(String name, String description, String image, int category, double price) {
        try {
            String query = "INSERT INTO car (name, description, image, category, price) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connectionToDb.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, image);
            preparedStatement.setInt(4, category);
            preparedStatement.setDouble(5, price);
            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }


}
