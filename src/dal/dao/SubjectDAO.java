package dal.dao;

import be.Subject;
import dal.DatabaseConnector;
import dal.Interfaces.ISubjectDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO implements ISubjectDAO {

    DatabaseConnector databaseConnector;

    public SubjectDAO(){
        databaseConnector = new DatabaseConnector();
    }

    public List<Subject> getAllSubjects() {
        List<Subject> allSubjects = new ArrayList<>();
        String sql = "SELECT * FROM CLASS";
        try (Connection connection = databaseConnector.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                //String weekday = resultSet.getString("Weekday");
                //Subject subject = new Subject(id, name, weekday);
                Subject subject = new Subject(id, name);
                allSubjects.add(subject);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allSubjects;
    }

    public Subject getSubjectbyId(int id){
        Subject subject = null;
        String sql = "SELECT * FROM CLASS WHERE id=?";
        try (Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                String name = resultSet.getString("name");
                subject = new Subject(id, name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return subject;
    }
}


