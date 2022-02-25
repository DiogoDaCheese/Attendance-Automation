package gui.model;

import be.Attendance;
import be.Student;
import be.Subject;
import bll.AttendanceAutomationManager;
import dal.dao.AttendanceDAO;
import dal.dao.StudentDAO;
import dal.dao.SubjectDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;


public class MainModel {

    private ObservableList<Student> allStudents;
    private ObservableList<Subject> allSubjects;
    private ObservableList<Attendance> allAttendance;
    private ObservableList<Subject> subjectById;
    private ObservableList<Student> studentById;
    private ObservableList<Attendance> attendanceByStudentId;
    private ObservableList<Attendance> attendanceBySubjectId;

    AttendanceAutomationManager manager;
    StudentDAO studentDAO;
    SubjectDAO subjectDAO;
    AttendanceDAO attendanceDAO;

    public MainModel(){
        manager = new AttendanceAutomationManager();
        studentDAO = new StudentDAO();
        subjectDAO = new SubjectDAO();
        attendanceDAO = new AttendanceDAO();
    }

    public ObservableList getAllStudents(){
        allStudents = FXCollections.observableArrayList();
        allStudents.addAll(manager.getAllStudents());
        return allStudents;
    }

        public ObservableList getAllSubjects(){
        allSubjects = FXCollections.observableArrayList();
        allSubjects.addAll(manager.getAllSubjects());
        return allSubjects;
    }

    public ObservableList getAllAttendance(){
        allAttendance = FXCollections.observableArrayList();
        allAttendance.addAll(manager.getAllAttendance());
        for (Attendance a: manager.getAllAttendance()
        ) {
            System.out.println(a);
        }
        return allAttendance;
    }

    public ObservableList getSubjectById(int id){
        subjectById = FXCollections.observableArrayList();
        subjectById.addAll(manager.getSubjectById(id));


        return subjectById;
    }

    public Student getStudentById(int id){

        return manager.getStudentById(id);
    }

    public String getAttendanceByStudentId(int id){
        StringBuilder sb = new StringBuilder();
        for (Attendance a:manager.getAttendanceByStudentId(id)
             ) {
                    sb.append(a.toString());
                    sb.append("\n");
        }

        return sb.toString();
    }

    public List<Attendance> getAttendanceBySubjectId(int id){

        return manager.getAttendanceBySubjectId(id);
    }

}
