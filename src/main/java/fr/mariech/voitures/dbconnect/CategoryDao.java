package fr.mariech.voitures.dbconnect;

import fr.mariech.voitures.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    private final Connection connectionToDb = ConnectionManager.openConnection();

    public List<Category> fetchCategories() {
        List<Category> categories = new ArrayList<>();
        try {
            String query = "SELECT id, name FROM category";
            Statement statement = connectionToDb.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                int id = results.getInt(1);
                String name = results.getString(2);
                Category category = new Category(id, name);
                System.out.println(category);
                categories.add(category);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return categories;
    }

    public void insertCategory(String name) {
        try {
            String query = "INSERT INTO category (name) VALUES (?)";
            PreparedStatement preparedStatement = connectionToDb.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }


    public void deleteCategory(String id) {
        try {
            String query = "DELETE FROM category WHERE id = ?;";
            PreparedStatement preparedStatement = connectionToDb.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

}
