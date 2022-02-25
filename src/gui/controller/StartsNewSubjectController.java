package gui.controller;

import gui.model.StartsNewSubjectModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class StartsNewSubjectController implements Initializable {

    MainController mainController;

    @FXML
    private Button startsNewSubjectSaveBtn;

    @FXML
    private ChoiceBox<?> studentChoiceBox3;

    @FXML
    private ChoiceBox<?> subjectChoiceBox4;

    StartsNewSubjectModel startsNewSubjectModel;

    public StartsNewSubjectController(){
        startsNewSubjectModel = new StartsNewSubjectModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setController(MainController mainController) {
        this.mainController = mainController;
    }
}
