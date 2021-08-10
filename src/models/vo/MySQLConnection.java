package models.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    
    public static MySQLConnection instance;
    private Connection xcon;

    private MySQLConnection() {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";
        String db_name = "pets_db";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
        }
    
        try {
            xcon = DriverManager.getConnection(url + db_name, user, password);
            //System.out.println("SQL Connection to database established!");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
        } 
    }
        
    public synchronized static MySQLConnection getInstance() {
        if(instance == null) {
            instance = new MySQLConnection();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return xcon;
    }
    
    public void close_connection() {
        instance = null;
    }
}