package org.example.repositories;

import org.example.entities.Pizza;

import javax.management.StringValueExp;
import java.sql.*;

public class JdbcPizzaRepository {
    private Connection connection;

    public JdbcPizzaRepository(Connection connection){
        this.connection = connection;
    }

    public Pizza save(Pizza pizza){
        String sql = "INSERT INTO pizzas(name, price, size)VALUE(?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, pizza.getName());
            ps.setBigDecimal(2, pizza.getPrice());
            ps.setString(3, String.valueOf(pizza.getSize()));
            int row = ps.executeUpdate();
            if (row == 0) throw new RuntimeException("Saving Pizza failed");
            try(ResultSet rs = ps.getGeneratedKeys()){
                if (rs.next()) pizza.setId(rs.getLong(1));
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to Save", e);
        }
        return pizza;
    }



}
