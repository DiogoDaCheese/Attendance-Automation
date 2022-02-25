package gui.controller;

import gui.model.RecordAttendanceModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class RecordAttendanceController implements Initializable {

    MainController mainController;

    @FXML
    private Button attendanceNoBtn;

    @FXML
    private Button attendanceYesBtn;

    @FXML
    private TextArea studentNameTxtArea;

    @FXML
    private TextArea subjectNameTxtArea;

    RecordAttendanceModel recordAttendanceModel;

    public RecordAttendanceController(){
        recordAttendanceModel = new RecordAttendanceModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setController(MainController mainController) {
        this.mainController = mainController;
    }
}
