package application;
	
import java.io.IOException;
import java.sql.*;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;


public class d_Admin_login extends Application {
	@FXML private TextField username_field;
	@FXML private PasswordField password_field;
	
	
	
		
	
	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) throws IOException, SQLException {
	
			BorderPane root = new BorderPane();
		  //  Parent root=FXMLLoader.load(getClass().getResource("/application/a_Login_selector.fxml"));
			Scene scene = new Scene(root,800,500);
			scene.getStylesheets().add(getClass().getResource("Login_selector.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
			display();
			
			
	}
	
	
	
	public void display() throws IOException, SQLException {
		Stage secondaryStage=new Stage();
		
		//BorderPane root = new BorderPane();
	    Parent root=FXMLLoader.load(getClass().getResource("/application/c_Librarian_login.fxml"));
		Scene scene = new Scene(root,710,400);
		scene.getStylesheets().add(getClass().getResource("Login_selector.css").toExternalForm());
	    secondaryStage.setScene(scene);
		secondaryStage.setResizable(false);
		secondaryStage.show();
	
	
		}//ending of display method:
	
	
	
	 //for checking_user_pass method after clicking login button:
    
	@FXML 
     public void checking_user_pass() throws SQLException, IOException {
    		//for mysql database connection:
			String dburl="jdbc:mysql://localhost:3306/library_information_system"; 
			 
			Connection conn1=DriverManager.getConnection(dburl,"root","");
		    Statement stmt1=conn1.createStatement();
		    String sql="Select * from table_user_pass Where admin_user='"+username_field.getText()+"' and admin_password ='"+password_field.getText()+"'";                  
		    ResultSet res =stmt1.executeQuery(sql);
		   int count=0;
		    while(res.next()) {	
		    	count=count+1;
		    }// ending of while loop:
		    
		    
		    //initalizing the alert object:
		    Alert alert = new Alert(AlertType.INFORMATION);	
		    alert.setTitle("There's something wrong");
		    
		    
			if(count==1) {
		    	   
		    	   e_Librarian_home_page inst2=new e_Librarian_home_page();
		    	   inst2.display();
		       }
		       else if((username_field.getText().equals(""))||(password_field.getText().equals(""))) 		  
               {
		    	   alert.setContentText("Either of the fields is left empty");
		    	   alert.showAndWait();
		       }
		       else {
		    	   
		    	   
		    	  // alert.setHeaderText("Look, an Error Dialog");
		    	   alert.setContentText("Incorrect username or password!!");

		    	   alert.showAndWait();
		       }
		      
    
	}//ending of checking_user_pass method:


	private Object encode(String test_user) {
		// TODO Auto-generated method stub
		return null;
	}
		
}// final ending point of c_Librarian_login class:

