package com.pluralsight;
import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.*;
import java.util.Scanner;


public class NorthWindTraders {

//    String productsQuery = """
//
//            select productID, productName, unitPrice, unitsInstock
//
//            from products
//
//            order by productName
//
//            """;



//    public void displayProducts() throws SQLException {
//        Scanner sc = new Scanner(System.in);
//
//        BasicDataSource dataSource = new BasicDataSource();
//
//        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind?allowMultiQueries=true&useSSL=true");
//        dataSource.setUsername("testuser2");
//        dataSource.setPassword("Password123");
//
//        Connection connection = dataSource.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(productsQuery);
//        ResultSet resultSet = preparedStatement.executeQuery();

        //Header
//        System.out.printf("%-5s %-30s %-10s %-10s%n",
//                "Id", "Name", "Price", "Stock");
//        System.out.println("----------------------------------------------------------------------------");
//
//
//        while (resultSet.next()) {
//            int productId = resultSet.getInt("ProductID");
//            String productName = resultSet.getString("ProductName");
//            double unitPrice = resultSet.getDouble("UnitPrice");
//            int unitsInStock = resultSet.getInt("UnitsInStock");


            //Stacked Format
//            System.out.println("Product ID: " + productId);
//            System.out.println("Product Name: " + productName);
//            System.out.println("Unit Price: " + unitPrice);
//            System.out.println("Units In Stock: " + unitsInStock);
//            System.out.println("--------------------------------");


            //Tabular Format
//            System.out.printf("%-5d %-30s %-10.2f %-10d%n",
//                    productId, productName, unitPrice, unitsInStock);

//        }
//    }

    public void homePage() throws SQLException {
        Scanner sc = new Scanner(System.in);

        int option;
        do {
            System.out.println("What do you want to do?");
            System.out.println("1- Display All Products ");
            System.out.println("2- Display All Customers ");
            System.out.println("0- Exit ");
            System.out.println("Enter your option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    displayAllProducts();
                    break;
                case 2:
                    displayAllCustomers();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;

            }
        }while (option != 0);

    }


    public void displayAllProducts() throws SQLException {

        String productsQuery = """
                select productID, productName, unitPrice, unitsInStock
                from products
                order by productName
        """;
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("testuser2");
        dataSource.setPassword("Password123");

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(productsQuery);
                ResultSet resultSet = preparedStatement.executeQuery();
        ){
            System.out.println("\n+++++++++  Welcome to North Wind Traders +++++++++\n");
            System.out.printf("%-5s %-30s %-10s %-10s%n",
                              "Id", "Name", "Price", "Stock");

            System.out.println("--------------------------------------------------------------------------");
            while (resultSet.next()) {
                int productId = resultSet.getInt("ProductID");
                String productName = resultSet.getString("ProductName");
                double unitPrice = resultSet.getDouble("UnitPrice");
                int unitsInStock = resultSet.getInt("UnitsInStock");

                System.out.printf("%-5d %-30s %-10.2f %-10d%n",
                           productId, productName, unitPrice, unitsInStock);

            }
        }


    }

    public void displayAllCustomers() throws SQLException {
        String customersQuery = """
                select CustomerID, CompanyName, ContactName, City, Country, phone
                from Customers
                order by country
        """;
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("testuser2");
        dataSource.setPassword("Password123");

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(customersQuery);
                ResultSet resultSet = preparedStatement.executeQuery();

        ){
            System.out.println("\n+++++++++  Welcome to North Wind Traders +++++++++\n");
            System.out.printf("%-8s %-30s %-30s %-20s %-20s %-20s%n",
                    "Id", "Company", "Contact", "City", "Country", "Phone");

            System.out.println("----------------------------------------------------------------------------------------------------------------------------");
            while (resultSet.next()) {
                String customerId = resultSet.getString("CustomerID");
                String CompanyName = resultSet.getString("CompanyName");
                String ContactName = resultSet.getString("ContactName");
                String City = resultSet.getString("City");
                String Country = resultSet.getString("Country");
                String phone = resultSet.getString("phone");

                System.out.printf("%-8s %-30s %-30s %-20s %-20s %-20s%n",
                        customerId, CompanyName, ContactName, City, Country, phone);
            }


        }

    }



}
