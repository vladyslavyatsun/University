package ua.university.database.dao;


import ua.university.database.entities.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vladyslav on 04.01.2016.
 */
public interface StudentDao {
    public Student read(int idStudent) throws SQLException;
    public boolean add(Student student) throws SQLException;
    public boolean delete(int idStudent, String pass);
    public List<Student> getAllOnFaculty(int idFaculty) throws SQLException;

}
