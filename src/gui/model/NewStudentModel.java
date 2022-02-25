package gui.model;

import be.Student;
import bll.AttendanceAutomationManager;

public class NewStudentModel {

    private final AttendanceAutomationManager manager;
    MainModel mainModel;

    public NewStudentModel(){
        manager = new AttendanceAutomationManager();
        mainModel = new MainModel();
    }

    public void newStudent(String name){
        Student student = manager.newStudent(name);
        mainModel.getAllStudents().add(student);
        for (Student s: manager.getAllStudents()
             ) {
            System.out.println(s);
        }
    }
}
