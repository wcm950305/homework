package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUtils {
    static final String URL="jdbc:mysql://localhost:3306/test1";
    static final String USERNAME="root";
    static final String PASSWORD="root";
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}
