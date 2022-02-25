package gui.controller;

import gui.model.NewStudentModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NewStudentController implements Initializable {

    MainController mainController;

    @FXML
    private Button newStudentSaveBtn;

    @FXML
    private TextField studentNameTxtField;

    NewStudentModel newStudentModel;

    public NewStudentController(){
        newStudentModel = new NewStudentModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setController(MainController mainController) {
        this.mainController = mainController;
    }

    public void newStudent(ActionEvent actionEvent){
        try {
            newStudentModel.newStudent(studentNameTxtField.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) newStudentSaveBtn.getScene().getWindow();
        stage.close();
    }

}
