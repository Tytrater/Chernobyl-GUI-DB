package edu.unlv.mis768.chernobylSam;

import java.sql.SQLException;

import edu.unlv.mis768.Database.ProjectDBUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ManagerController extends UserController {

	 @FXML
	    private Button deleteButton;
	 


	    @FXML
	    private RadioButton healthcareRadioButton;

	    @FXML
	    private RadioButton patientRadioButton;

	    @FXML
	    private Button queryButton;

	    @FXML
	    private RadioButton shelterRadioButton;

	    @FXML
	    private ToggleGroup user;

	    @FXML
	    private TextField userTextField;

	    @FXML
	    private RadioButton workRadioButton;


    @FXML
    void queryButtonListener(ActionEvent event) throws SQLException {
    	ProjectDBUtil util = new ProjectDBUtil();
    	if(healthcareRadioButton.isSelected())
    		util.Query("Healthcare", "Title", userTextField.getText());
    	else if(patientRadioButton.isSelected())
    		util.Query("Patient","Username", userTextField.getText());
    	else if(shelterRadioButton.isSelected())
    		util.Query("Shelter", "ShelterTitle", userTextField.getText());
    	else if(workRadioButton.isSelected())
    		util.Query("Work", "Name", userTextField.getText());

    }
    

    
    @FXML
    void deleteButtonListener(ActionEvent event) throws SQLException {
    	ProjectDBUtil util = new ProjectDBUtil();
    	if(healthcareRadioButton.isSelected())
    		util.Delete("Healthcare", "Title", userTextField.getText());
    	else if(patientRadioButton.isSelected())
    		util.Delete("Patient","username", userTextField.getText());
    	else if(shelterRadioButton.isSelected())
    		util.Delete("Shelter", "ShelterTitle", userTextField.getText());
    	else if(workRadioButton.isSelected())
    		System.out.println("Work Radio Button Selected");
    		util.Delete("Work", "Name", userTextField.getText());
    }

}
