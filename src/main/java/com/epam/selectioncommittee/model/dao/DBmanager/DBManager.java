package com.epam.selectioncommittee.model.dao.DBmanager;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
    private static DBManager instance;


    private static Connection connection;


    private static final String DATABASE_URL;
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(new FileReader("app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DATABASE_URL = (String) properties.get("connection.url");
    }

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            try {
                instance = new DBManager();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    private DBManager() throws SQLException {

        Properties properties = new Properties();



        connection = DriverManager.getConnection(DATABASE_URL);

    }

    public  Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        DBManager.connection = connection;
    }
}
