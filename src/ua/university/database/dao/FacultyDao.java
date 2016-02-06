package ua.university.database.dao;


import ua.university.database.entities.Faculty;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vladyslav on 04.01.2016.
 */
public interface FacultyDao {
    public Faculty read(int key) throws SQLException;
    public List<Faculty> getAll() throws SQLException;
}
