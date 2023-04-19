package fr.mariech.voitures.dbconnect;

import fr.mariech.voitures.model.Car;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    private final Connection connectionToDb = ConnectionManager.openConnection();

    public List<Car> fetchCars() {
        System.out.println("in fetch cars function");
        List<Car> cars = new ArrayList<>();
        try {
            String query = "SELECT car.id, car.name, description, image, category.name, price FROM car INNER JOIN category WHERE category.id = car.category";
            Statement statement = connectionToDb.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                int id = results.getInt(1);
                String name = results.getString(2);
                String description = results.getString(3);
                String image = results.getString(4);
                String category = results.getString(5);
                double price = results.getDouble(6);
                Car car = new Car(id, name, description, image, category, price);
                System.out.println(car);
                cars.add(car);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return cars;
    }

    public Car fetchOneCar(String id) {
        Car retrievedCar = null;
        try {
            String query = "SELECT car.id, car.name, description, image, category.name, price FROM car INNER JOIN category WHERE category.id = car.category AND car.id = ?;";
            PreparedStatement preparedStatement = connectionToDb.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                int intId = Integer.parseInt(id);
                String name = results.getString(2);
                String description = results.getString(3);
                String image = results.getString(4);
                String category = results.getString(5);
                double price = results.getDouble(6);
                retrievedCar = new Car(intId, name, description, image, category, price);
                System.out.println(retrievedCar);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return retrievedCar;
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

    public void deleteCar(String id) {
        try {
            String query = "DELETE FROM car WHERE id = ?;";
            PreparedStatement preparedStatement = connectionToDb.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }


}
