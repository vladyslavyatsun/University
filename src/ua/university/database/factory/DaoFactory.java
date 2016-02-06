package ua.university.database.factory;


import ua.university.database.dao.FacultyDao;
import ua.university.database.dao.StudentDao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Vladyslav on 04.01.2016.
 */
public interface DaoFactory {
    enum dbFactories{MYSQL};
    public Connection getConnection() throws SQLException;
    public FacultyDao getFacultyDao(Connection connection);
    public StudentDao getStudentDao(Connection connection);

    public static DaoFactory getFactory(dbFactories db){
        switch (db ){
        case MYSQL:
            try {
                Class clazz = Class.forName("database.factory.MySqlDaoFactory");
                return (DaoFactory) clazz.newInstance();
            } catch (Exception ex) {
                return null;
            }
        }
        return null;
    }

}
