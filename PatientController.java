package edu.unlv.mis768.chernobylSam;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PatientController extends User{

    @FXML
    private RadioButton administrativeButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextField familySizeText;

    @FXML
    private RadioButton managementButton;

    @FXML
    private RadioButton mentalCareButton;

    @FXML
    private RadioButton physicalCareButton;

    @FXML
    private Button submitButton;

    @FXML
    private TextField surnameText;

    @FXML
    private RadioButton tradeButton;
    
    
    
    public void clearButtonListener() {
    	surnameText.setText("");
    	familySizeText.setText("");
    }


    	public void insertButtonListener() throws SQLException  {
    		
    		//Create patient object
    		User patient = new User();
    		
	    	// Create named constants for the URL, user name and password
		    final String DB_URL = Constants.DB_URL;
		    final String USER_NAME = Constants.USER_NAME;
		    final String PASSWORD = Constants.PASSWORD;
	    	
	    	
	    	//create variables
	    	String healthStatus;
	    	String workSkills;
	    	String surname;
	    	Double familySize;
	    	String username;
	    	
	    	//Get the user name
	    	username = patient.getUsername();
	    	
	    	
	    	surname = surnameText.getText();
	    	familySize = Double.parseDouble(familySizeText.getText());
	    	
	    	if(mentalCareButton.isSelected()) {
	    		healthStatus = "Mental";	    	
	    		}
	    	else {
	    		healthStatus = "Physical";
	    	}
	    	
	    	
	    	//Set the work skills variable
	    	if(tradeButton.isSelected()) {
	    		workSkills = "Trade";
	    	}
	    	else if(managementButton.isSelected()) {
	    		workSkills = "Management";
	    	}
	    	else {
	    		workSkills = "Administrative";
	    	}
	    	
	    	
	    	//Create a connection to the database
		    Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD); 
		    
		    //Create a SELECT statement to get the specific field row from the patient table
		    String sqlStatement = "INSERT INTO Patient VALUES (?,?,?,?,?)";
		    
		    //Instantiate a PrepareStatement object using the SQL command
		    PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
		    
		    //provide the values for the query
		    prepStmt.setString(1, username);
		    prepStmt.setString(2, surname);
		    prepStmt.setString(2, healthStatus);
		    prepStmt.setString(3, workSkills);
		    prepStmt.setDouble(4, familySize);
		    
		
	    	
	    }
	
    	
    	public void deleteButtonListener() throws SQLException {
    		
    		//Create patient object
    		User patient = new User();
    		
    		// Create named constants for the URL, user name and password
		    final String DB_URL = Constants.DB_URL;
		    final String USER_NAME = Constants.USER_NAME;
		    final String PASSWORD = Constants.PASSWORD;
		    
		    String username;
		    
		    username = patient.getUsername();
		    
		  //Create a connection to the database
		   Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD); 
    		
    		
    		String sql ="DELETE FROM Patient WHERE Username = ?";
			
			//Prepared statement object
			PreparedStatement prepStmt;
			
			prepStmt = conn.prepareStatement(sql);
	
			//Provide value
			prepStmt.setString(1, username);
			
			//Execute it
			int rows = prepStmt.executeUpdate();
			System.out.println(rows+" rows deleted");
    	}
    	
    	
    	
    	public void updateButtonListener() throws SQLException{
    		
    		//Create patient object
    		User patient = new User();
    		
    		// Create named constants for the URL, user name and password
		    final String DB_URL = Constants.DB_URL;
		    final String USER_NAME = Constants.USER_NAME;
		    final String PASSWORD = Constants.PASSWORD;
		    
		    //Create local variables
		    String username;
		    String healthStatus;
		    
		    //Get the user's surname from the user's text input
		    username = patient.getUsername();
		    
		    //Get the user's health status based on which button they selected
		    if(mentalCareButton.isSelected()) {
	    		healthStatus = "Mental";	    	
	    		}
	    	else {
	    		healthStatus = "Physical";
	    	}
    		
    		
		   // Create an UPDATE statement to update the user's health status for the specified user-name.
 	       String sqlStatement = "UPDATE Patient SET HealthStatus = ? WHERE Username = ?";
 	       
 	       //Create a connection to the database
		   Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD); 
 	       
 	   
 	        // instantiate a PrepareStatement object using the SQL command
 	        PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
 	        
 	        // provide the values for Update command.
 	        prepStmt.setString(1, healthStatus);
 	        prepStmt.setString(2, username);
 			
 	       // Send the UPDATE statement to the DBMS.
 	       int rows = prepStmt.executeUpdate();

 	       // Display the results.
 	       System.out.println(rows + " row(s) updated.");
    		
    	}

}
