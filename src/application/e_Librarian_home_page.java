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


public class e_Librarian_home_page extends Application {
	@FXML 
	private Button manage_books_button;

	@Override
	public void start(Stage primaryStage) throws IOException, SQLException {
	     
			//BorderPane root = new BorderPane();
		/*  Parent root=FXMLLoader.load(getClass().getResource("/application/e_Librarian_home_page.fxml"));
			Scene scene = new Scene(root,800,500);
			scene.getStylesheets().add(getClass().getResource("Login_selector.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();     
		*/
			display();
			
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	//after student login successful:
	
	public void display() throws IOException, SQLException{
		Stage secondaryStage=new Stage();
		
		//BorderPane root = new BorderPane();
	    Parent root=FXMLLoader.load(getClass().getResource("/application/e_Librarian_home_page.fxml"));
		Scene scene = new Scene(root,800,500);
		scene.getStylesheets().add(getClass().getResource("Login_selector.css").toExternalForm());
	    secondaryStage.setScene(scene);
		secondaryStage.setResizable(false);
		secondaryStage.show();
	  }
	
	  //after clicking manage books button:
    public void manage_books_function() throws IOException, SQLException {
		f_manage_books inst3=new f_manage_books();
		inst3.display_manage_books();
		Stage tempoStage = (Stage) manage_books_button.getScene().getWindow();
	    
	    tempoStage.close();
	 }  
	
      //after clicking manage members button:
    public void manage_members_function() throws IOException, SQLException {
		g_manage_members inst3=new g_manage_members();
		inst3.display_manage_members();
		Stage tempoStage = (Stage) manage_books_button.getScene().getWindow();
	    
	    tempoStage.close();
	 } 
	
	

	
	
		
}// final ending point:

