package repository;

import model.Goods;
import utilities.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
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


}
