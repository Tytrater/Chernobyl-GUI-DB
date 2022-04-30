package edu.unlv.mis768.Database;

import java.sql.*;

import edu.unlv.mis768.Model.User;
import edu.unlv.mis768.Model.Work;

public class ProjectDBUtil {
	
		/**
		 * This method establishes the DB connection
		 * @return a database connection
		 */
		public static Connection getDBConnection(){
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER_NAME, Constants.PASSWORD);
			} catch (Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
			}
			
			return conn;
			
		}
		/**
		 * @throws SQLException 
		 * 
		 */
		public void Query(String table, String col, String id) throws SQLException {
			System.out.println("Querying: " + id);
	    	//Create a connection to the database
		    Connection conn = DriverManager.getConnection(Constants.DB_Project_URL, Constants.USER_NAME, Constants.PASSWORD); 
		    //Query the database
		    String sqlStatement = "SELECT * FROM " + table + " WHERE " + col + " = ?";
		    PreparedStatement prepStmt = conn.prepareStatement(sqlStatement,
                    ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
		    //Provide id to be queried
		    prepStmt.setString(1, id);
	       // Send the SELECT statement to the DBMS.
	       ResultSet result = prepStmt.executeQuery();

	       //Get number of rows in table
	       result.last();
	       int rows = result.getRow();
	       result.beforeFirst();
	       
	       //Retrieving the ResultSetMetaData object
	       ResultSetMetaData rsmd = result.getMetaData();
	       //get number of columns in table
	       int columns = rsmd.getColumnCount();
	       // Print each row and table to console
	       System.out.println("rows = " + rows);
	       if (rows > 0) {
	       System.out.println("Element Found: \n");
		       for (int i = 1; i <= rows; i++) {
		    	   if (result.next()) {
		    		   for (int j = 1; j <= columns; j++)
		    			   System.out.println(result.getString(j));
		    		   
		    	   }
		    	   System.out.println("\n");
		    	    		   
		       }
	       }
    	   else
    		   System.out.println("Element not found"); 
	       closeDBConnection(conn);
		}
		
		public void Delete(String table, String col, String id) throws SQLException {
			System.out.println("Delete Method Started");
			//Create a connection to the database
		    Connection conn = DriverManager.getConnection(Constants.DB_Project_URL, Constants.USER_NAME, Constants.PASSWORD); 
		    // Sql Statement to delete row
		    String sqlStatement = "DELETE  FROM " + table + " WHERE " + col + " = ?";
		    PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
		    //Provide id to be deleted
		    prepStmt.setString(1, id);
	       // Execute Delete Statementuser
	       prepStmt.executeUpdate();
	       
	       System.out.println(id + " Deleted");
		}
		
		public void Insert(String table, User user) throws SQLException {
			//Create a connection to the database
		    Connection conn = DriverManager.getConnection(Constants.DB_Project_URL, Constants.USER_NAME, Constants.PASSWORD);
		    //Query the database
		    String sqlStatement = "SELECT * FROM " + table;
		    PreparedStatement prepStmt = conn.prepareStatement(sqlStatement,
                    ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
	       // Send the SELECT statement to the DBMS.
	       ResultSet result = prepStmt.executeQuery();
	       //Retrieving the ResultSetMetaData object
	       ResultSetMetaData rsmd = result.getMetaData();
	       int columns = rsmd.getColumnCount();
	       String sqlColumns = "(?";
		   for (int i = 1; i <= columns; i++)
			   sqlColumns += ",?";
		   sqlColumns += ")";
		    //Insert into table
		    sqlStatement = "INSERT INTO " + table + " VALUES " + sqlColumns;
		    
		    // provide the values for the query
		    //prepStmt.setString(1,shelter.);
		    
		    closeDBConnection(conn);
		}

		/**
		 * This method closes the DB connection
		 * @param the connection to be closed
		 */
		
		
		public static void closeDBConnection(Connection conn) {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex) {
					System.out.println("ERROR: " + ex.getMessage());
				}
			}
		}

	
	
	
	

}
