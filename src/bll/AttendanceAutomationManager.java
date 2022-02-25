package bll;

import be.Attendance;
import be.Student;
import be.Subject;
import dal.dao.AttendanceDAO;
import dal.dao.StudentDAO;
import dal.dao.SubjectDAO;

import java.util.List;

public class AttendanceAutomationManager {

    StudentDAO studentDAO;
    SubjectDAO subjectDAO;
    AttendanceDAO attendanceDAO;

    public AttendanceAutomationManager(){
        studentDAO = new StudentDAO();
        subjectDAO = new SubjectDAO();
        attendanceDAO = new AttendanceDAO();
    }


    public Student newStudent(String name) {
        return studentDAO.newStudent(name);
    }

    public List<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }

    public List<Subject> getAllSubjects(){
        return subjectDAO.getAllSubjects();
    }

    public List<Attendance> getAllAttendance(){
        return attendanceDAO.getAllAttendance();
    }

    public Subject getSubjectById(int id) {
        return subjectDAO.getSubjectbyId(id);
    }

    public List<Attendance> getAttendanceByStudentId(int id) {
        return attendanceDAO.getAttendanceByStudentId(id);
    }

    public List<Attendance> getAttendanceBySubjectId(int id) {
        return attendanceDAO.getAttendanceBySubjectId(id);
    }

    public Student getStudentById(int id) {
        return studentDAO.getStudentbyIId(id);
    }
}
