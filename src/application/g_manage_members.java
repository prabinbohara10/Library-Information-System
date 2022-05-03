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

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class g_manage_members extends Application {
	@FXML
	private Button select_image_button;
	@FXML
	private ImageView cover_imageview;
	@FXML
	private TextArea cover_image_url_textarea;
	private String image_file;
	
	@FXML
	private TextField first_name,last_name,dob,roll_no,standard,faculty,shift,section,
	gender, age, height,weight, blood_group, address,phone_no,email;
	
	
	private String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16;
	
	@Override
	public void start(Stage primaryStage) throws IOException, SQLException {
	
			//BorderPane root = new BorderPane();
		
		
		
			HBox root=new HBox();
		    //Parent root=FXMLLoader.load(getClass().getResource("/application/f_manage_books.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("Login_selector.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			display_manage_members();
			
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	//after student login successful:
	
	public void display_manage_members() throws IOException, SQLException{
		Stage secondaryStage=new Stage();
		
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		secondaryStage.setX(bounds.getMinX());
		secondaryStage.setY(bounds.getMinY());
		secondaryStage.setWidth(bounds.getWidth());
		secondaryStage.setHeight(bounds.getHeight());
	
		//BorderPane root = new BorderPane();
	    Parent root=FXMLLoader.load(getClass().getResource("/application/g_manage_members.fxml"));
		Scene scene = new Scene(root,800,500);
		scene.getStylesheets().add(getClass().getResource("Login_selector.css").toExternalForm());
	    secondaryStage.setScene(scene);
	    secondaryStage.setResizable(false);
		secondaryStage.show();
		
	}
	
	//when you click select image button:
	public void after_clicking_select_button() throws FileNotFoundException, MalformedURLException {
	
	FileChooser fileChooser = new FileChooser();
	fileChooser.setTitle("Open Resource File");
	  Stage tempoStage = (Stage) select_image_button.getScene().getWindow();
	File file1 = fileChooser.showOpenDialog(tempoStage);
	
	if(file1 != null) {
		cover_image_url_textarea.setText(file1.getAbsolutePath());
		
		FileInputStream input=new FileInputStream(file1.getAbsoluteFile());
		
		image_file=file1.toURI().toURL().toString();
		Image image =new Image(image_file);
		cover_imageview=new ImageView(image);
		cover_imageview.setFitHeight(100);
		cover_imageview.setFitWidth(120);
		cover_imageview.setPreserveRatio(true);
			}
	   }//end of select image button:
	
	
	//when you click add members:

	public void after_clicking_add_members() throws SQLException {
	
		a1=first_name.getText();
		a2=last_name.getText();
		a3=dob.getText();
		a4=roll_no.getText();
		a5=standard.getText();
		a6=faculty.getText();
		a7=shift.getText();
		a8=section.getText();
		a9=gender.getText();
		a10=age.getText();
		a11=height.getText();
		a12=weight.getText();
		a13=blood_group.getText();
		a14=address.getText();
		a15=phone_no.getText();
		a16=email.getText();
		System.out.println(a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15+a16);
		System.out.println(a6);
		System.out.println("new console");
		String dburl="jdbc:mysql://localhost:3306/library_information_system"; 
		 
		Connection conn1=DriverManager.getConnection(dburl,"root","");
	    Statement stmt1=conn1.createStatement();
	    String sql="INSERT INTO table_students_record VALUES ('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+a11+"','"+a12+"','"+a13+"','"+a14+"','"+a15+"','"+a16+"')";
	    System.out.println("sql");
	    stmt1.executeUpdate(sql);
	
System.out.println(a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15+a16);
	        
	    
	  
	    
	}
	
	

	
	
		
}// final ending point:

