package fr.mariech.voitures.dbconnect;

import fr.mariech.voitures.model.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    private final Connection connectionToDb = ConnectionManager.openConnection();

    public List<Category> fetchCategories() {
        List<Category> categories = new ArrayList<>();
        try {
            String query = "SELECT name FROM category";
            Statement statement = connectionToDb.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String name = results.getString(1);
                Category category = new Category(name);
                System.out.println(category);
                categories.add(category);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return categories;
    }

}
