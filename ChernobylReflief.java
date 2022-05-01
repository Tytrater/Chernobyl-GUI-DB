package edu.unlv.mis768.GUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ChernobylReflief extends Application {
	
	//Fields

    private Label healthLabel;
    private Label shelterLabel;
    private Label workLabel;

	@Override
	public void start(Stage primaryStage) {
		
		healthLabel = new Label("");
		shelterLabel = new Label("");
		workLabel = new Label("");
		try {
			System.out.println("[1]Chernobyl Relief Start");
			
			// Load the FXML File
			Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
			
			//Establish the Scene
			Scene scene = new Scene(parent);
		    
			
			// Set the Scene to the Stage
			primaryStage.setScene(scene);
			
		} catch (IOException e) {
			// Display Error Message to Console
			System.out.println(e.getMessage());
		}
		
		// Set the Title of the Login Window
		primaryStage.setTitle("Login Page");
		
		// Show the Stage
		primaryStage.show();
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
