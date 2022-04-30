package edu.unlv.mis768.GUI;

import java.io.IOException;

import edu.unlv.mis768.Model.Provider;
import edu.unlv.mis768.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerLoader {
	
	public void UserLoader(String fileName, UserController controller, User user, ActionEvent e) throws IOException {
		// Instantiate the FXMLLoader object for loading the UI 
		FXMLLoader loader = new FXMLLoader();
		// specify the file location for the FXML file for the next window
		loader.setLocation(getClass().getResource(fileName));
		// load the UI for the next window
		Parent parent = loader.load();
		// set the scene
		Scene scene = new Scene(parent);
		// access the controller class for the next window via the FXML loader
		System.out.println("Controller preLoad: " + controller);
		System.out.println("loader.getController: " + loader.getController());
		controller = loader.getController();
		// call the method in the controller class for the next window
    	// so that the user can be passed
		System.out.println("Controller preInitialize: " + controller);
		controller.initializeUser(user);
		System.out.println("Controller postInitialize: " + controller);
		// get the current stage, using the ActionEvent object
		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
		// change the title
		stage.setTitle(fileName.substring(0,fileName.indexOf(".")) + " Window");
		// set the new scene to the stage
		stage.setScene(scene);
		// show the stage
		stage.show();
    	System.out.println("Stage shown");
		
    }
	
	public void ProviderLoader(Provider prvdr, String fileName, UserController controller,  ActionEvent e) throws IOException {
		// Instantiate the FXMLLoader object for loading the UI 
    	FXMLLoader loader = new FXMLLoader();
    	
    	// specify the file location for the FXML file for the next window
    	loader.setLocation(getClass().getResource(fileName));
    	
    	// load the UI for the next window
    	Parent parent = loader.load();
    	
    	// set the scene
    	Scene scene = new Scene(parent);
    	
    	// access the controller class for the next window via the FXML loader
    	System.out.println("Controller: " + controller);
    	System.out.println("loader.getController(): " + loader.getController());
    	// Why does this next line keep popping in and out of the code?
    	controller = loader.getController();
    	System.out.println("Controller: " + controller);
    	System.out.println("[8]Controller Loaded");
    	//System.out.println("Controller: " + controller);
    	
    	// call the method in the controller class for the next window
    	// so that the user can be passed
    	controller.initializeProvider(prvdr);
    	System.out.println("[10]Provider Controller Initialized");
    	
    	
    	
    	
    	// get the current stage, using the ActionEvent object
    	Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
    	
    	// change the title
    	stage.setTitle(fileName.substring(0,fileName.indexOf(".")) + " Window");

    	// set the new scene to the stage
    	stage.setScene(scene);
    	
    	// show the stage
    	stage.show();
    	System.out.println("Stage shown");
		}

	
	
	public void ManagerLoader(String fileName, UserController cntrllr, ActionEvent e) throws IOException {

	}
	
	public void PatientLoader(User user, String fileName, PatientController controller,  ActionEvent e) throws IOException {
		
		System.out.println("[4]Loader Started");
		    	
		    	/* get Text Field Contents
		    	String username = usrnm;
		    	String password =psswrd;
		    	
		    	// Create User object
		    	
		    	User usr = new User(username, password);
		    	System.out.println("[4]User Initialized");
		    	*/
		    	
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
		    	System.out.println("[5]Controller Loaded");
		    	
		    	// call the method in the controller class for the next window
		    	// so that the user can be passed
		    	//controller.initializeUser(user);
		    		//controller.initializeProvider(user);
		    	System.out.println("[7]Controller Initialized");
		    	
		    	
		    	
		    	// get the current stage, using the ActionEvent object
		    	Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
		    	// change the title
		    	stage.setTitle(fileName.substring(0,fileName.indexOf(".")) + " Window");
		    	// set the new scene to the stage
		    	stage.setScene(scene);
		    	// show the stage
		    	stage.show();
				
			}


}
