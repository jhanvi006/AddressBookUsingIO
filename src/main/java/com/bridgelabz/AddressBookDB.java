package com.bridgelabz;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDB {
    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/address_book_service?useSSL=false";
        String userName = "root";
        String password = "admin";
        Connection con;
        System.out.println("Connecting to database: "+jdbcURL);
        con = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successful!!"+ con);
        return con;
    }
    public List<Contacts> readData() {
        String sql = "SELECT * FROM address_book_table;";
        List<Contacts> contactsList = new ArrayList<>();
        try (Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String zipCode = resultSet.getString("zip_code");
                String phoneNo = resultSet.getString("phone_no");
                String email = resultSet.getString("email");
                String addressBookName = resultSet.getString("address_book_name");
                String addressBookType = resultSet.getString("address_book_type");
                contactsList.add(new Contacts(firstName, lastName, address, city,
                        state, zipCode, phoneNo, email, addressBookName, addressBookType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactsList;
    }
}
