package com.bridgelabz;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookDB {
    Scanner sc = new Scanner(System.in);
    List<Contacts> contactsList;
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
        contactsList = new ArrayList<>();
        try (Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            contactsList = this.getContactDetails(resultSet);
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return contactsList;
    }

    public void updateContact(String email, String lastName) {
        String sql = "UPDATE address_book_table SET last_name = ? WHERE email = ?";
        try {
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lastName);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
    }
    public boolean checkEmployeePayrollInSyncWithDB(String email) {
        try {
            String sql = "SELECT * FROM address_book_table WHERE email = ?";
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            contactsList = this.getContactDetails(resultSet);
            return contactsList.get(0).equals(getDetails(email));
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return false;
    }
    private Contacts getDetails(String email) {
        return this.contactsList.stream()
                .filter(contact -> contact.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
    private List<Contacts> getContactDetails(ResultSet resultSet) {
        List<Contacts> contactsList = new ArrayList<>();
        try {
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
                LocalDate dateAdded = resultSet.getDate("date_added").toLocalDate();
                contactsList.add(new Contacts(firstName, lastName, address, city,
                        state, zipCode, phoneNo, email, addressBookName, addressBookType, dateAdded));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return contactsList;
    }

    public List<Contacts> retrieveDataByDate(String date) {
        try {
            String sql = "SELECT * FROM address_book_table WHERE date_added BETWEEN ? AND CURDATE()";
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            contactsList = this.getContactDetails(resultSet);
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return contactsList;
    }
    public List<Contacts> retrieveDataByCityOrState(String city, String state) {
        try {
            String sql = "SELECT * FROM address_book_table WHERE city = ? OR state = ?";
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, city);
            preparedStatement.setString(2, state);
            ResultSet resultSet = preparedStatement.executeQuery();
            contactsList = this.getContactDetails(resultSet);
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return contactsList;
    }

    public void addContact() {
        String sql = "INSERT INTO address_book_table (first_name, last_name, address, city, " +
                "state, zip_code, phone_no, email, address_book_name, address_book_type, " +
                "date_added) VALUES ('Shreya', 'Patel', 'Baner', 'Pune', 'Maharashtra', " +
                "'410450', '1880902233', 'shreya@gmail.com', 'famjam', 'Family', '2020-08-30');";
        try {
            Connection connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
    }
}
