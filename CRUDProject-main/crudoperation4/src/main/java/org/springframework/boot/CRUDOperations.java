package org.springframework.boot;

import org.springframework.boot.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDOperations {
    private Connection connection;



    public CRUDOperations() {
        try {
            connection = DatabaseConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create
    public void createRecord(String name) throws SQLException {
        String sql = "INSERT INTO mytable (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement. executeUpdate();
        }
    }

    // Read
    public String readRecord(int id) throws SQLException {
        String sql = "SELECT name FROM mytable WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("name");
                }
            }
        }
        return null;
    }

    // Update
    public void updateRecord(int id, String newName) throws SQLException {
        String sql = "UPDATE mytable SET name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newName);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }

    // Delete
    public void deleteRecord(int id) throws SQLException {
        String sql = "DELETE FROM mytable WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
