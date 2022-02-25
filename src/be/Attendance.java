package be;

import dal.dao.StudentDAO;
import dal.dao.SubjectDAO;

import java.util.Date;

public class Attendance {
    int studentId;
    int subjectId;
    Date date;
    boolean attended;
    StudentDAO studentDAO = new StudentDAO();
    SubjectDAO subjectDAO = new SubjectDAO();

    public int getStudentId(){
        return studentId;
    }

    public int getSubjectId(){
        return subjectId;
    }

    public Date getDate(){
        return date;
    }

    public boolean isAttended() { return attended; }

    public Attendance(int studentId, int subjectId, Date date, boolean attended){
        this.studentId=studentId;
        this.subjectId=subjectId;
        this.date=date;
        this.attended=attended;
    }

    /*public String toString(){
        String toString = null;
        try {
            toString = StudentDAO.getAllStudents(studentId).toString();
        } catch (Exception e){
            e.printStackTrace();
        }
        return toString;
    }*/
    public String toString(){
        String toString = null;
        try {
            String ternary = attended==true ? "attended" : "not attended";
            toString = studentDAO.getStudentbyIId(studentId).toString();
            toString = toString + " - " + subjectDAO.getSubjectbyId(subjectId).toString();
            toString = toString + " - " + date + " - " + ternary;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toString;
    }
}
