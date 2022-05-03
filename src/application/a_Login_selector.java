package application;
	
import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class a_Login_selector extends Application {
	@FXML private Button librarian_button,student_button,admin_button;

	@Override
	public void start(Stage primaryStage) throws IOException {
	
			//BorderPane root = new BorderPane();
		    Parent root=FXMLLoader.load(getClass().getResource("/application/a_Login_selector.fxml"));
			Scene scene = new Scene(root,800,500);
			scene.getStylesheets().add(getClass().getResource("Login_selector.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	//after student login successful:
	@FXML
	public void studentLogin() throws IOException, SQLException {
	        // get a handle to the stage
		    Stage tempoStage = (Stage) student_button.getScene().getWindow();
		    // do what you have to do
		    tempoStage.close();
	c_Librarian_login instant1=new c_Librarian_login();
	instant1.display(); 
	}
	
	//after librarian login successful:
	@FXML
	public void librarianLogin() throws IOException, SQLException {
	        // get a handle to the stage
		    Stage tempoStage = (Stage) librarian_button.getScene().getWindow();
		    // do what you have to do
		    tempoStage.close();
	c_Librarian_login instant2=new c_Librarian_login();
	instant2.display(); 
	}
	
	
	//after admin login successful:
	@FXML
	public void adminLogin() throws IOException, SQLException {
	        // get a handle to the stage
		    Stage tempoStage = (Stage) admin_button.getScene().getWindow();
		    // do what you have to do
		    tempoStage.close();
	c_Librarian_login instant3=new c_Librarian_login();
	instant3.display(); 
	}

	
	
		
}// final ending point:

