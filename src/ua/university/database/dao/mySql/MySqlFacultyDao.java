package ua.university.database.dao.mySql;



import ua.university.database.dao.FacultyDao;
import ua.university.database.entities.Faculty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vladyslav on 04.01.2016.
 */
public class MySqlFacultyDao implements FacultyDao {
    private final Connection connection;
    public MySqlFacultyDao(Connection connection){
        this.connection = connection;
    }

    @Override
    public Faculty read(int key) throws SQLException {
        String sql = "SELECT * FROM university.faculties WHERE id_faculty = ?;";

        try(PreparedStatement statement = connection.prepareStatement(sql);){

        statement.setInt(1, key);

        ResultSet rs = statement.executeQuery();

        rs.next();


        return parsResultSet(rs);
        }
    }

    @Override
    public List<Faculty> getAll() throws SQLException {
       String sql = "SELECT * FROM university.faculties;";
        List<Faculty> list = new LinkedList<Faculty>();

        try(PreparedStatement stm = connection.prepareStatement(sql);) {

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                list.add(parsResultSet(rs));
            }

        return list;
        }
    }

    private Faculty parsResultSet(ResultSet rs) throws SQLException{
        Faculty f = new Faculty();
        f.setId(rs.getInt("id_faculty"));
        f.setName(rs.getString("faculty"));
        f.setVacancies(rs.getInt("vacancies"));
        f.setSubject1(rs.getString("subject1"));
        f.setSubject2(rs.getString("subject2"));
        f.setSubject3(rs.getString("subject3"));
        return f;
    }
}
