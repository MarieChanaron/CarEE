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
            String query = "SELECT * FROM car";
            Statement statement = connectionToDb.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String name = results.getString("name");
                String description = results.getString("description");
                String image = results.getString("image");
                String category = results.getString("category");
                int price = results.getInt("price");
                Car car = new Car(name, description, image, category, price);
                System.out.println(car);
                cars.add(car);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return cars;
    }
}
