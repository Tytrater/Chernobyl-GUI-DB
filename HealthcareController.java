package edu.unlv.mis768.chernobylSam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

		public class HealthcareController {
	    @FXML
	    private TextField addressTextField;

	    @FXML
	    private TextField contactTextField;

	    @FXML
	    private TextField hosiptalNameTextField;

	    @FXML
	    private TextField hoursTextField;

	    @FXML
	    private TextField idTextField;

	    @FXML
	    private TextField specialtyTextField;

	
	    //If the user selects the clear button
	    //Clear every field 
	    public void clearButtonListner() {
	    	addressTextField.setText("");
	    	contactTextField.setText("");
	    	hosiptalNameTextField.setText("");
	    	hoursTextField.setText("");
	    	idTextField.setText("");
	    	specialtyTextField.setText("");
	    }
	    
	    //If the user selects the delete button
	    public void deleteButtonListner() throws SQLException {
	        final String DB_URL = Constants.DB_URL;
		    final String USER_NAME = Constants.USER_NAME;
		    final String PASSWORD = Constants.PASSWORD;
		    
		    //Create local variable
		    String id;
		    
		    id = idTextField.getText();
		    
		  //Create a connection to the database
		   Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD); 
    		
    		//Delete statement
    		String sql ="DELETE FROM Healthcare WHERE ID = ?";
			
			//Prepared statement object
			PreparedStatement prepStmt;
			
			prepStmt = conn.prepareStatement(sql);
	
			//Provide value
			prepStmt.setString(1, id);
			
			//Execute it
			int rows = prepStmt.executeUpdate();
			System.out.println(rows+" rows deleted");
	    }
	    
	    //If the user selects the insert button
	    public void insertButtonListner() throws SQLException {
	    	
	    	
	    	// Create named constants for the URL, user name and password
		    final String DB_URL = Constants.DB_URL;
		    final String USER_NAME = Constants.USER_NAME;
		    final String PASSWORD = Constants.PASSWORD;
	    	
	    	
	    	//create variables
	    	String id;
	    	String title;
	    	String specialty;
	    	String hours;
	    	String contact;
	    	String address;
	    	
	    	//Get values from user
	    	id = idTextField.getText();
	    	title = hosiptalNameTextField .getText();
	    	specialty = specialtyTextField.getText();
	    	hours = hoursTextField.getText();
	    	contact = contactTextField.getText();
	    	address = addressTextField.getText();
	  
	    	//Create a connection to the database
		    Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD); 
		    
		    //Create a INSERT statement
		    String sqlStatement = "INSERT INTO Healthcare VALUES (?,?,?,?,?,?)";
		    
		    //Instantiate a PrepareStatement object using the SQL command
		    PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
		    
		    //provide the values for the query
		    prepStmt.setString(1, id);
		    prepStmt.setString(2, title);
		    prepStmt.setString(3, specialty);
		    prepStmt.setString(4, hours);
		    prepStmt.setString(5, contact);
		    prepStmt.setString(6, specialty);
		    prepStmt.setString(7, address);
	
	    }
	    
	    //If the user selects the update button
	    public void updateButtonListner() throws SQLException {
	    	
    		// Create named constants for the URL, user name and password
		    final String DB_URL = Constants.DB_URL;
		    final String USER_NAME = Constants.USER_NAME;
		    final String PASSWORD = Constants.PASSWORD;
		    
		    //Create local variables
		    String id;
		    String hours;
		    
		    //Get the user's surname from the user's text input
		    id = idTextField.getText();
		    hours = hoursTextField.getText();		    
    		
    		
		   // Create an UPDATE statement to update 
 	       String sqlStatement = "UPDATE Healthcare SET Hours = ? WHERE ID = ?";
 	       
 	       //Create a connection to the database
		   Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD); 
 	       
 	   
 	        // instantiate a PrepareStatement object using the SQL command
 	        PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
 	        
 	        // provide the values for Update command.
 	        prepStmt.setString(1, hours);
 	        prepStmt.setString(2, id);
 			
 	       // Send the UPDATE statement to the DBMS.
 	       int rows = prepStmt.executeUpdate();

 	       // Display the results.
 	       System.out.println(rows + " row(s) updated.");
    		
    	}


}
