package repository;

import model.Category;
import utilities.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRepository {

    public int save(String name) throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        String query="INSERT INTO category (name) VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        int i = preparedStatement.executeUpdate();
        JdbcConnection.closeResources(connection, preparedStatement);
        return i;
    }

    public boolean isExistByName(String name) throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        String query="SELECT * FROM category WHERE name=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean result = resultSet.next();
        JdbcConnection.closeResources(connection, preparedStatement, resultSet);
        return result;


    }
}
