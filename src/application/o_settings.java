package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class o_settings extends Application {
	@FXML private TextField text_field_1,text_field_2,text_field_3;
	private String a1,a2,a3;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException, SQLException {
		display();
	}

	
	
	
	public void display() throws IOException, SQLException {
		Stage secondaryStage=new Stage();
					  
		//BorderPane root = new BorderPane();
	    Parent root=FXMLLoader.load(getClass().getResource("/application/o_settings.fxml"));
		Scene scene = new Scene(root,800,500);
		scene.getStylesheets().add(getClass().getResource("Login_selector.css").toExternalForm());
	    secondaryStage.setScene(scene);
		secondaryStage.setResizable(false);
		secondaryStage.show();
		
	

		}//ending of display method:
	
	// When user clicks save button:
	 public void save_button() throws SQLException {
		 a1=text_field_1.getText();
		 a2=text_field_2.getText();
		 a3=text_field_3.getText();
		 if(a1.equals("")||a2.equals("")||a3.equals(""))
		 {
			 Alert alert = new Alert(AlertType.INFORMATION);	
			    alert.setTitle("There's something wrong");
			    alert.setContentText("Some fields are left empty");
		 	    alert.showAndWait();
		 }
		 else {
		 
			String dburl1="jdbc:mysql://localhost:3306/library_information_system"; 
			 
			Connection conn1=DriverManager.getConnection(dburl1,"root","");
		    Statement stmt1=conn1.createStatement();
		    String sql="INSERT INTO table_settings VALUES ('"+a1+"','"+a2+"','"+a3+"')";
		         	    stmt1.executeUpdate(sql);
		     
		            Alert alert = new Alert(AlertType.INFORMATION);	
		       	    alert.setTitle("Notice");
		       	    alert.setContentText("Save successfully changed");
		       	    alert.showAndWait();
		 }
	 }
	
}
