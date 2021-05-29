package utilities.impl;

import java.sql.Connection;
import java.sql.DriverManager;

import utilities.DbUtil;

public class DbUtilImpl implements DbUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/practice";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Argha@2021";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    @Override
    public Connection dbConnection(Connection connection) {

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return connection;
    }

}
