package ua.university.database.factory;

import ua.university.database.dao.FacultyDao;
import ua.university.database.dao.StudentDao;
import ua.university.database.dao.mySql.MySqlFacultyDao;
import ua.university.database.dao.mySql.MySqlStudentDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Vladyslav on 04.01.2016.
 */
public class MySqlDaoFactory implements DaoFactory {
    private String driver = "com.mysql.jdbc.Driver";

    MySqlDaoFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        Properties dbProp = new Properties();

        try {
            dbProp.load(new FileInputStream("./src/database/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(dbProp.getProperty("db.url"),
                                            dbProp.getProperty("db.user"),
                                            dbProp.getProperty("db.pass"));
    }

    @Override
    public FacultyDao getFacultyDao(Connection connection) {
        return new MySqlFacultyDao(connection);
    }

    @Override
    public StudentDao getStudentDao(Connection connection) {
        return new MySqlStudentDao(connection);
    }
}
