package gui.controller;

import be.Attendance;
import be.Student;
import be.Subject;
import gui.model.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class MainController implements Initializable {
    @FXML
    private Button attendanceBtn;

    @FXML
    private Button individualattBtn;

    @FXML
    private Button mostAbsentBtn;

    @FXML
    private Button newStudentBtn;

    @FXML
    private Button overviewBtn;

    @FXML
    private Button startSubjectBtn;

    @FXML
    private ChoiceBox<?> studentChoiceBox1;

    @FXML
    private ChoiceBox<?> studentChoiceBox2;

    @FXML
    private ChoiceBox<?> subjectChoiceBox1;

    @FXML
    private ChoiceBox<?> subjectChoiceBox2;

    @FXML
    private ChoiceBox<?> subjectChoiceBox3;

    @FXML
    private AnchorPane anchorPane;

    MainModel mainModel;

    private Student student;
    private Subject subject;
    private Attendance attendance;

    private Stage stage;


    public MainController(){
        mainModel = new MainModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadData();

    }

    private void loadData(){

        subjectChoiceBox1.getItems().addAll(mainModel.getAllSubjects());
        subjectChoiceBox2.getItems().addAll(mainModel.getAllSubjects());
        //subjectChoiceBox3.getItems().addAll(mainModel.getAllSubjects());
        studentChoiceBox1.getItems().addAll(mainModel.getAllStudents());
        //studentChoiceBox2.getItems().addAll(mainModel.getAllStudents());

    }

    public void recordAttendance(ActionEvent actionEvent){
        Parent root;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/gui/view/RecordAttendanceWindow.fxml"));
        try {
            root = loader.load();
            RecordAttendanceController recordAttendanceController = loader.getController();
            recordAttendanceController.setController(this);
            Stage stage = new Stage();
            stage.setTitle("Record Attendance");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void newStudent(ActionEvent actionEvent){
        Parent root;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/gui/view/NewStudentWindow.fxml"));
        try {
            root = loader.load();
            NewStudentController newStudentController = loader.getController();
            newStudentController.setController(this);
            Stage stage = new Stage();
            stage.setTitle("New Student");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void startSubject(ActionEvent actionEvent){
        Parent root;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/gui/view/StartsNewSubjectWindow.fxml"));
        try {
            root = loader.load();
            StartsNewSubjectController startsNewSubjectController = loader.getController();
            startsNewSubjectController.setController(this);
            Stage stage = new Stage();
            stage.setTitle("Starts New Subject");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void classAttendanceOverview(ActionEvent actionEvent) {
        int chosenItemId = ((Subject)(subjectChoiceBox1.getSelectionModel().getSelectedItem())).getId();
        try {
            StringBuilder sb = new StringBuilder();
            for (Attendance a:mainModel.getAttendanceBySubjectId(chosenItemId)
            ) {
                sb.append(a.toString());
                sb.append("\n");
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Class Attendance Overview");
            alert.setHeaderText(sb.toString());

            if (alert.showAndWait().get() == ButtonType.OK) {
                alert.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void individualAttendance(ActionEvent actionEvent) {
        int chosenItemId = ((Student)(studentChoiceBox1.getSelectionModel().getSelectedItem())).getID();
        try {
            String result = mainModel.getAttendanceByStudentId(chosenItemId);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Individual Attendance");
            alert.setHeaderText(result);

            if (alert.showAndWait().get() == ButtonType.OK) {
                alert.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostAbsentStudents(ActionEvent actionEvent) {
        int chosenItemId = ((Subject)(subjectChoiceBox2.getSelectionModel().getSelectedItem())).getId();
        List<Attendance> result = mainModel.getAttendanceBySubjectId(chosenItemId);
        HashMap<Integer, Integer> student_att = new HashMap<>();
        for (Attendance a:result
             ) {
                    if(!student_att.containsKey(a.getStudentId())){
                        student_att.put(a.getStudentId(), 0);
                    }
                    if(!a.isAttended()){
                        int count = (int)student_att.get(a.getStudentId());
                        count ++;
                        student_att.put(a.getStudentId(), count);
                    }
        }

        Set<Map.Entry<Integer, Integer>> entries = student_att.entrySet();

        Comparator<Map.Entry<Integer, Integer>> valueComparator = new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                Integer v1 = e1.getValue();
                Integer v2 = e2.getValue();
                return v1.compareTo(v2);
            }
        };

        List<Map.Entry<Integer, Integer>> listOfEntries = new ArrayList<Map.Entry<Integer, Integer>>(entries);

        Collections.sort(listOfEntries, valueComparator);

        LinkedHashMap<Integer, Integer> sortedByValue = new LinkedHashMap<Integer, Integer>(listOfEntries.size());

        Set<Map.Entry<Integer, Integer>> entrySetSortedByValue = sortedByValue.entrySet();

        for(Map.Entry<Integer, Integer> entry : listOfEntries){
            sortedByValue.put(entry.getKey(), entry.getValue());
        }

        try {
            StringBuilder sb = new StringBuilder();
            for (var a:sortedByValue.entrySet()
            ) {
                sb.append(mainModel.getStudentById(a.getKey()).getName() + " was absent " + a.getValue() + " time(s)");
                sb.append("\n");
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Most Absent Students");
            alert.setHeaderText(sb.toString());

            if (alert.showAndWait().get() == ButtonType.OK) {
                alert.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
