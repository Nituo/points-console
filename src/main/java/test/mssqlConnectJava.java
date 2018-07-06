/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class mssqlConnectJava {
    
    private static Connection connection = null;
    //1.jdbc driver name
    private static String SQL_JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    // 2. Database URL, V_UDAY\FRAMEWORK is ServerName and JSF is DataBase name
    private static String URL = "jdbc:sqlserver://COMPUTER\\SQLEXPRESS:1433;databaseName=cyberdb";
    //3.Database credentials
    private static String USERNAME = "admin";//UserName
    private static String PASSWORD = "password";//Password

public static void main(String[] args) {
    getLocalConnection();
}

public static Connection getLocalConnection() {
    try {
        Class.forName(SQL_JDBC_DRIVER);// Register jdbc driver

        System.out.println("****Connect to Database****");

        //4. open a connection
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        System.out.println("DataBase connect to: "+ connection.getMetaData().getDriverName());
        System.out.println("URL: "+ connection.getMetaData().getURL());

        setConnectionClose();
        System.out.println("Database Connection Closed");
    } catch (Exception e) {
        e.printStackTrace();
        System.err.println("Exception in getLocalConnection() "+e.getMessage());
    }
    return connection;
}

public static void setConnectionClose() throws SQLException {
    if (connection != null) {
        connection.close();
    }
}

}
