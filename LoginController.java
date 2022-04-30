package edu.unlv.mis768.GUI;

import java.io.IOException;

import edu.unlv.mis768.Model.User;
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
    private Button patientLoginButton;

    @FXML
    
    private Button providerLoginButton;
    
    @FXML
    private Button managerLoginButton;    

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField usernameTextField;
    
    public void login(String userType, ActionEvent e) throws IOException {
    	System.out.println("[2]"+userType + " login");
    	User user = new User(usernameTextField.getText(), passwordTextField.getText());
    	UserController userController = new UserController();
    	ProviderController provController = new ProviderController();
		ControllerLoader loader = new ControllerLoader();
		System.out.println("userType: " + userType);
    	switch(userType) {
    	case "Patient":
    		PatientController patController = new PatientController();
    		loader.PatientLoader(user, "Patient.fxml", patController, e);
    		break;
    	case "Provider":
    		System.out.println("[3] Provider Detected");
    		System.out.println("user at login: " + user);
    		System.out.println("Controller: " + userController);
    		//String fileName, UserController controller, User user, ActionEvent e
    		loader.UserLoader("Provider.fxml", userController, user, e);
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
    
    // Event Listener for Provider Login
    
    public void providerLoginButtonListener(ActionEvent e) throws IOException {
    	login("Provider", e);
    }
    
    // Event Listener for Manager Login
    

    public void ManagerLoginButtonListener(ActionEvent e) throws IOException {
    	login("Manager", e);
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
    
    
}
