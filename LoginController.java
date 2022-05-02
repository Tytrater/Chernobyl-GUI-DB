package edu.unlv.mis768.chernobylSam;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {    

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField usernameTextField;
    
    public void login(String userType, ActionEvent e) throws IOException {
    	System.out.println("[2]"+userType + " login");
    	User user = new User(usernameTextField.getText(), passwordTextField.getText());
    	
    	//Create objects
    	UserController userController = new UserController();
    	WorkController workController = new WorkController();
    	ShelterController shelterController = new ShelterController();
    	HealthcareController healthController = new HealthcareController();
		ControllerLoader loader = new ControllerLoader();
		
		System.out.println("userType: " + userType);
    	switch(userType) {
    	case "Patient":
    		PatientController patController = new PatientController();
    		loader.PatientLoader(user, "Patient.fxml", patController, e);
    		break;
    	case "Work Provider":
    		System.out.println("[3] Provider Detected");
    		System.out.println("user at login: " + user);
    		System.out.println("Controller: " + userController);
    		loader.UserLoader("Work.fxml", userController, user, e);
    		break;
    	case "Healthcare Provider":
    		System.out.println("[3] Healthcare Provider Detected");
    		System.out.println("user at login: " + user);
    		System.out.println("Controller: " + userController);
    		loader.UserLoader("Healthcare.fxml", userController, user, e);
    		break;
    	case "Shelter Provider":
    		System.out.println("[3] Healthcare Provider Detected");
    		System.out.println("user at login: " + user);
    		System.out.println("Controller: " + userController);
    		loader.UserLoader("Shelter.fxml", userController, user, e);
    		break;
    	case "Manager":
    		System.out.println("[3] Manager Detected");
    		System.out.println("user at login: " + user);
    		System.out.println("Controller: " + userController);
    		loader.UserLoader("Manager.fxml",  userController, user, e);
    		break;
    	}
    }
    
    // Event Listener for Patient Login
    
    public void patientLoginButtonListener(ActionEvent e) throws IOException {
    	login("Patient", e);
    }
    
    // Event Listener for Shelter Provider Login
    
    public void shelterLoginButtonListener(ActionEvent e) throws IOException {
    	login("Shelter Provider", e);
    }
    
    // Event Listener for Work Provider Login
    
    public void workLoginButtonListener(ActionEvent e) throws IOException {
    	login("Work Provider", e);
    }
    
    // Event Listener for health-care Provider Login
    
    public void healthLoginButtonListener(ActionEvent e) throws IOException {
    	login("Healthcare Provider", e);
    }
    
    // Event Listener for Manager Login
    
    public void ManagerLoginButtonListener(ActionEvent e) throws IOException {
    	login("Manager", e);
    }
    
}
    
    
    /* Loader for post-login FXML File
    
    public void loader(String fileName, UserController controller, ActionEvent e) throws IOException {
    	
    	System.out.println("Loader Started");
    	
    	// get Text Field Contents
    	String username = usernameTextField.getText();
    	String password = passwordTextField.getText();
    	
    	// Create User object
    	
    	User usr = new User(username, password);
    	System.out.println("User Initialized");
    	
    	// Instantiate the FXMLLoader object for loading the UI 
    	FXMLLoader loader = new FXMLLoader();
    	
    	// specify the file location for the FXML file for the next window
    	loader.setLocation(getClass().getResource(fileName));
    	
    	// load the UI for the next window
    	Parent parent = loader.load();
    	
    	// set the scene
    	Scene scene = new Scene(parent);
    	
    	// access the controller class for the next window via the FXML loader
    	controller = loader.getController();
    	System.out.println("Controller Loaded");
    	
    	// call the method in the controller class for the next window
    	// so that the string can be passed
    	controller.initializeData(usr);
    	System.out.println("Controller Initialized");
    	
    	// get the current stage, using the ActionEvent object
    	Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
    	// change the title
    	stage.setTitle("Patient Window");
    	// set the new scene to the stage
    	stage.setScene(scene);
    	// show the stage
    	stage.show();
    }
    
    */
