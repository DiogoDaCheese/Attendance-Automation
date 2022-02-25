package dal.dao;

import be.Student;
import dal.DatabaseConnector;
import dal.Interfaces.IStudentDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {

    DatabaseConnector databaseConnector;

    public StudentDAO(){
        databaseConnector = new DatabaseConnector();
    }


    public Student newStudent(String name) {

        Student student = null;
        String sql = "INSERT INTO STUDENT(name) VALUES(?)";

        checkNameNotNull(name);

        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                student = new Student(id, name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    private void checkNameNotNull(String name) {
        if (name.isEmpty())
            System.out.println("Please add a name");
    }

    public List<Student> getAllStudents() {
        List<Student> allStudents = new ArrayList<>();
        String sql = "SELECT * FROM STUDENT";
        try (Connection connection = databaseConnector.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                Student student = new Student(id, name);
                allStudents.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allStudents;
    }

    public Student getStudentbyIId(int id){
        Student student = null;
        String sql = "SELECT * FROM STUDENT WHERE id=?";
        try (Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                String name = resultSet.getString("name");
                student = new Student(id, name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }
}
