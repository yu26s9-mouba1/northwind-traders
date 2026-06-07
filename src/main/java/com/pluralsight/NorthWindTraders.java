package com.pluralsight;
import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.*;

public class NorthWindTraders {

    String productsQuery = """
           
            select productID, productName, unitPrice, unitsInstock
          
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

        //Header
        System.out.printf("%-5s %-30s %-10s %-10s%n",
                "Id", "Name", "Price", "Stock");
        System.out.println("----------------------------------------------------------------------------");


        while (resultSet.next()) {
            int productId = resultSet.getInt("ProductID");
            String productName = resultSet.getString("ProductName");
            double unitPrice = resultSet.getDouble("UnitPrice");
            int unitsInStock = resultSet.getInt("UnitsInStock");


            //Stacked Format
//            System.out.println("Product ID: " + productId);
//            System.out.println("Product Name: " + productName);
//            System.out.println("Unit Price: " + unitPrice);
//            System.out.println("Units In Stock: " + unitsInStock);
//            System.out.println("--------------------------------");




            //Tabular Format
            System.out.printf("%-5d %-30s %-10.2f %-10d%n",
                    productId, productName, unitPrice, unitsInStock);




        }


    }





}
