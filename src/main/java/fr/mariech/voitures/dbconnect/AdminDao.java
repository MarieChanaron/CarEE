package fr.mariech.voitures.dbconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {

    private final Connection connectionToPostDb = ConnectionManager.openConnection();

    public boolean checkCredentials(String login, String password) {
        boolean adminExists = false;
        try {
            String query = "SELECT * FROM admin WHERE login = ? AND password = ?;";
            PreparedStatement preparedStatement = connectionToPostDb.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();
            adminExists = result.next();
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return adminExists;
    }
}
