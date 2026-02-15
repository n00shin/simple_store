package repository;

import dto.GoodsInventory;
import dto.SimpleGoods;
import model.Goods;
import org.example.DynamicArray;
import utilities.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsRepository {
    public int save(Goods goods) throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        String query = "INSERT INTO goods(name,inventory,category_id) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, goods.getName());
        preparedStatement.setInt(2, goods.getInventory());
        preparedStatement.setInt(3, goods.getCategoryId());
        int i = preparedStatement.executeUpdate();
        JdbcConnection.closeResources(connection, preparedStatement);
        return i;
    }


public int removeById(int id) throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        String query = "DELETE FROM goods WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        int i = preparedStatement.executeUpdate();
        JdbcConnection.closeResources(connection, preparedStatement);
        return i;
}

    public boolean iaExistsById(int id) throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        String query = "SELECT * FROM goods WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean result = resultSet.next();
        JdbcConnection.closeResources(connection, preparedStatement, resultSet);
        return result;

    }

    public DynamicArray findByName(String name) throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        String query="SELECT * FROM goods WHERE name like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        DynamicArray dynamicArray=new DynamicArray("SimpleGoods");
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name1= resultSet.getString("name");
            SimpleGoods simpleGoods = new SimpleGoods(id, name1);
            dynamicArray.add(simpleGoods);
        }
        JdbcConnection.closeResources(connection, preparedStatement, resultSet);
        return dynamicArray;
    }
    
    public int incrementInventory(int id,int number) throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        String query = "UPDATE goods SET inventory = inventory + ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, number);
        preparedStatement.setInt(2, id);
        int i = preparedStatement.executeUpdate();

        JdbcConnection.closeResources(connection, preparedStatement);
        return i;
    }

    public GoodsInventory findById(int id) throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        String query = "SELECT * FROM goods WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            int id1 = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int inventory = resultSet.getInt("inventory");
             return new GoodsInventory(id1, name, inventory);
        }
        return null;
    }

    public int decrementInventory(int id, int number) throws SQLException {
        Connection connection = JdbcConnection.getConnection();
        String query = "UPDATE goods SET inventory = inventory - ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, number);
        preparedStatement.setInt(2, id);
        int i = preparedStatement.executeUpdate();
        JdbcConnection.closeResources(connection, preparedStatement);
        return i;
    }
}
