package edu.unlv.mis768.chernobylSam;

import javafx.scene.control.Button;

import java.io.IOException;

import edu.unlv.mis768.Model.Provider;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ProviderController extends UserController {

	  @FXML
	    private TextField addressTextField;

	  @FXML
	    private Button healthcareButton;

	    @FXML
	    private TextField phoneNumberTextField;

	    @FXML
	    private Button shelterButton;

	    @FXML
	    private Button workButton;
	    
	    //UserController controller = new UserController();
    	ControllerLoader loader = new ControllerLoader();
    	
    	public void providerLogin(String prvdrType, UserController controller, ActionEvent e) throws IOException {
    		System.out.println(prvdrType + " Provider Login");
    		System.out.println("Controller: " + controller);
    		System.out.println("User at Provider Login: " + user);
    		Provider provider = new Provider(user, addressTextField.getText(), phoneNumberTextField.getText());
    		//controller.initializeProvider(provider);
    		System.out.println("[8]Provider at Provider Login: " + provider);
    		loader.ProviderLoader(provider, prvdrType + ".fxml",controller, e);
    		
    	}
    	
	    public void healthcareButtonListener(ActionEvent e) throws IOException {
	    	//Call Login Method
	    	System.out.println("Healthcare Button Clicked");
	    	HealthcareController controller = new HealthcareController();
	    	providerLogin("Healthcare", controller, e);
	    	/*
	    	System.out.println("Healthcare Provider Login");
	    	loader.ProviderLoader(provider, "Healthcare.fxml",controller, e);
	    	
	    	//loader.ProviderLoader( "Healthcare.fxml", controller, e);
	    	*/
	    }
	 
	    public void shelterButtonListener(ActionEvent e) throws IOException {
	    	ShelterController controller = new ShelterController();
	    	providerLogin("Shelter",controller, e);
	    	//loader.ProviderLoader(provider, "Shelter.fxml",controller, e);
	    }
	    
	    public void workButtonListener(ActionEvent e) throws IOException {
	    	WorkController controller = new WorkController();
	    	providerLogin("Work",controller, e);
	    	//loader.ProviderLoader(provider, "Work.fxml",controller, e);
		}
}