package dal.dao;

import be.Attendance;
import dal.DatabaseConnector;
import dal.Interfaces.IAttendanceDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendanceDAO implements IAttendanceDAO {

    DatabaseConnector databaseConnector;
    StudentDAO studentDAO;
    SubjectDAO subjectDAO;

    public AttendanceDAO(){
        databaseConnector = new DatabaseConnector();
        studentDAO = new StudentDAO();
        subjectDAO = new SubjectDAO();
    }

    public List<Attendance> getAllAttendance() {
        List<Attendance> allAttendance = new ArrayList<>();
        String sql = "SELECT * FROM ATTENDANCE";
        try (Connection connection = databaseConnector.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int student_id = resultSet.getInt("student_id");
                int subject_id = resultSet.getInt("subject_id");
                Date date = resultSet.getDate("date");
                boolean attended = resultSet.getBoolean("attended");
                Attendance attendance = new Attendance(student_id, subject_id, date, attended);
                allAttendance.add(attendance);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allAttendance;
    }

    public List<Attendance> getAttendanceByStudentId(int id) {
        List<Attendance> list_attendance = new ArrayList<>();
        String sql = "SELECT * FROM ATTENDANCE WHERE student_id=?";
        try (Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int student_id = resultSet.getInt("student_id");
                int subject_id = resultSet.getInt("subject_id");
                Date date = resultSet.getDate("date");
                boolean attended = resultSet.getBoolean("attended");
                Attendance attendance = new Attendance(student_id, subject_id, date, attended);
                list_attendance.add(attendance);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list_attendance;
    }

    public List<Attendance> getAttendanceBySubjectId(int id) {
        List<Attendance> list_attendance = new ArrayList<>();
        String sql = "SELECT * FROM ATTENDANCE WHERE subject_id=?";
        try (Connection connection = databaseConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int student_id = resultSet.getInt("student_id");
                int subject_id = resultSet.getInt("subject_id");
                Date date = resultSet.getDate("date");
                boolean attended = resultSet.getBoolean("attended");
                Attendance attendance = new Attendance(student_id, subject_id, date, attended);
                list_attendance.add(attendance);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list_attendance;
    }
}
