package fr.mariech.voitures.dbconnect;

import fr.mariech.voitures.model.Car;

import java.sql.*;
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
                int price = results.getInt(5);
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
}
