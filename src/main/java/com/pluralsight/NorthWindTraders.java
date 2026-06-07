package com.pluralsight;
import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.*;

public class NorthWindTraders {

    String productsQuery = """
           
            select productName
          
            from products
            
            order by productName
           
            """;

    public void displayProducts() throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind?allowMultiQueries=true&useSSL=true");
        dataSource.setUsername("testuser2");
        dataSource.setPassword("Password123");

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(productsQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String productName = resultSet.getString("productName");
            System.out.println("Product Name: " + productName);


        }


    }





}
