package ua.university.database.dao.mySql;


import ua.university.database.dao.StudentDao;
import ua.university.database.entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vladyslav on 04.01.2016.
 */
public class MySqlStudentDao implements StudentDao {
    private final Connection connection;

    public MySqlStudentDao(Connection connection){
        this.connection = connection;
    }


    @Override
    public Student read(int idStudent) throws SQLException {
        String sql = "SELECT * FROM university.students WHERE id_faculty = ? ;";
        try(PreparedStatement statement = connection.prepareStatement(sql);){

        statement.setInt(1, idStudent);
       // statement.setInt(2, idFaculty);

        ResultSet rs = statement.executeQuery();

        rs.next();


        return parsResultSet(rs);
        }
    }

    @Override
    public boolean add(Student student) throws SQLException {
        String sql = "INSERT INTO university.students" +
                "(id_student, fname, lname, subject1, subject2, subject3, certificate, password, id_faculty)" +
                "VALUES(?,?,?,?,?,?,?,?,?);";
        try (PreparedStatement stm = connection.prepareStatement(sql)){
            preparedStatementForAdd(stm, student);
            int count = stm.executeUpdate();
            if(count !=1){
                throw new SQLException("On update modify more then 1 record: " + count);
            }
        } catch (Exception e){
            throw new SQLException(e);
        }
        return true;
    }

    @Override
    public boolean delete(int idStudent, String password){
        return true;
    }

    @Override
    public List<Student> getAllOnFaculty(int idFaculty) throws SQLException {
        String sql = "SELECT * FROM university.students WHERE id_faculty = ?;";
        List<Student> list = new LinkedList<Student>();

        try(PreparedStatement stm = connection.prepareStatement(sql);){

        stm.setInt(1, idFaculty);

        ResultSet rs = stm.executeQuery();

        while (rs.next()){
            list.add(parsResultSet(rs));
        }}
        return list;
    }

    private void preparedStatementForAdd(PreparedStatement statement, Student student) throws SQLException {
            statement.setInt(1,student.getIdStudent());
            statement.setString(2, student.getFname());
        statement.setString(3,student.getLname());
        statement.setInt(4, student.getSubject1());
        statement.setInt(5, student.getSubject2());
        statement.setInt(6, student.getSubject3());
        statement.setInt(7, student.getCertificate());
        statement.setString(8, student.getPassword());
        statement.setInt(9, student.getIdFaculty());
    }

    private Student parsResultSet(ResultSet rs) throws SQLException{
        Student s = new Student();
        s.setIdStudent(rs.getInt("id_student"));
        s.setFname(rs.getString("fname"));
        s.setLname(rs.getString("lname"));
        s.setSubject1(rs.getInt("subject1"));
        s.setSubject2(rs.getInt("subject2"));
        s.setSubject3(rs.getInt("subject3"));
        s.setCertificate(rs.getInt("certificate"));
        s.setPassword(rs.getString("password"));
        s.setIdFaculty(rs.getInt("id_faculty"));

        return s;
    }
}
