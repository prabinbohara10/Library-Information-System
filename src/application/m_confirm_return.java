package application;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class m_confirm_return extends Application {
	@FXML
	private Button select_image_button;
	@FXML
	private ImageView cover_imageview;
	@FXML
	private TextArea cover_image_url_textarea;
	private String image_file;
	@FXML public TextField book_id, isbn_number,title,author,category;
	@FXML public TextField book_id1, isbn_number1,title1,author1,category1;
    @FXML private TextArea description;
    private String a1,a2,a3,a4,a5,a6,a7,a8;
    private String b1,b2,b3,b4,b5;
    

	
	
	@Override
	public void start(Stage primaryStage) throws IOException, SQLException {
	
			//BorderPane root = new BorderPane();
		
		
		
			HBox root=new HBox();
		    //Parent root=FXMLLoader.load(getClass().getResource("/application/m_confirm_return.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("Login_selector.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			display();
			
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	//after student login successful:
	
	public void display() throws IOException, SQLException{
		Stage secondaryStage=new Stage();
		
		//BorderPane root = new BorderPane();
	    Parent root=FXMLLoader.load(getClass().getResource("/application/m_confirm_return.fxml"));
		Scene scene = new Scene(root,1000,500);
		scene.getStylesheets().add(getClass().getResource("Login_selector.css").toExternalForm());
	    secondaryStage.setScene(scene);
		secondaryStage.setResizable(false);
		
		secondaryStage.show();
		
	
		
	        
	}
	
	//when user clicks load button:
	public void load_button() throws SQLException {
		//for mysql database connection:
		String dburl="jdbc:mysql://localhost:3306/library_information_system"; 
		Connection conn1=DriverManager.getConnection(dburl,"root","");
	    Statement stmt1=conn1.createStatement();
	    String sql="Select * from tempo_issue_details";                  
	    ResultSet res =stmt1.executeQuery(sql);
	   
	    while(res.next()) {
	    	a1 = res.getString("book_id");
			a2=res.getString("isbn_number");
			a3=res.getString("title");
			a4=res.getString("author");   
			
			a5=res.getString("category");
			a6=res.getString("full_name");
			
			a7=res.getString("roll_no");
			a8=res.getString("issued_date");
		      
	 }// ending of while loop:
		book_id.setText(a1);
		isbn_number.setText(a2);
		title.setText(a3);
		author.setText(a4);
		category.setText(a5);
		book_id1.setText(a6);
		isbn_number1.setText(a7);
		title1.setText(a8);

		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date today_date = new Date();
        author1.setText(dateFormat.format(today_date));
} //end of load button:
	
	
	

		
	
	//when you click add book:
	public void return_book_button() throws SQLException {
	    
		a1 = book_id.getText();
		a2=isbn_number.getText();
		a3=title.getText();
		a4=author.getText();
		a5=category.getText();
		b1 = book_id1.getText();
		b2=isbn_number1.getText();
		b3=title1.getText();
		b4=author1.getText();
		
		
		
	
		
		String dburl="jdbc:mysql://localhost:3306/library_information_system"; 
		 
		Connection conn1=DriverManager.getConnection(dburl,"root","");
	    Statement stmt1=conn1.createStatement();
	    String sql="INSERT INTO table_books_return_details VALUES ('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+b1+"','"+b2+"','"+b3+"','"+b4+"')";
	         	    stmt1.executeUpdate(sql);
	         	 
	         	   Stage tempoStage = (Stage) book_id.getScene().getWindow();
	   		    // do what you have to do
	   		    tempoStage.close(); 
	   		
	   		 // deleting the targeted row form the table:
	   		 String dburl2="jdbc:mysql://localhost:3306/library_information_system"; 			 
			    Connection conn2 = DriverManager.getConnection(dburl2,"root","");						
			    Statement stmt2 = conn2.createStatement();
			    String sql2="DELETE FROM table_books_issue_details WHERE isbn_number='" +a2+ "'";
			    stmt2.executeUpdate(sql2);
										
	         	    
	            Alert alert = new Alert(AlertType.INFORMATION);	
	       	    alert.setTitle("Notice");
	       	    alert.setContentText("Book Successfully returned by "+b1);
	        	alert.showAndWait(); 
	        	
	       
	       
	        
	  }
	
	
	

	
	
		
}// final ending point:

