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


public class f_manage_books extends Application {
	@FXML
	private Button select_image_button;
	@FXML
	private ImageView cover_imageview;
	@FXML
	private TextArea cover_image_url_textarea;
	private String image_file;
	@FXML
	private TextField book_id, isbn_number,title,author,category,publisher,
	          language,price,book_type,edition,year,pages,shelf,date_added,keywords;
    @FXML
	private TextArea description;
	
	private String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15;
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
			display_manage_books();
			
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	//after student login successful:
	
	public void display_manage_books() throws IOException, SQLException{
		Stage secondaryStage=new Stage();
		
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		secondaryStage.setX(bounds.getMinX());
		secondaryStage.setY(bounds.getMinY());
		secondaryStage.setWidth(bounds.getWidth());
		secondaryStage.setHeight(bounds.getHeight());
		
		//BorderPane root = new BorderPane();
	    Parent root=FXMLLoader.load(getClass().getResource("/application/f_manage_books.fxml"));
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
	
	
	//when you click add book:
	public void after_clicking_add_book() throws SQLException {
		a1 = book_id.getText();
		a2=isbn_number.getText();
		a3=title.getText();
		a4=author.getText();
		a5=description.getText();
		a6=category.getText();
		a7=publisher.getText();
		a8=language.getText();
		a9=price.getText();
		a10=book_type.getText();
		a11=edition.getText();
		a12=year.getText();
		a13=pages.getText();
		a14=shelf.getText();
		a15=date_added.getText();
		
		
	
		
		String dburl="jdbc:mysql://localhost:3306/library_information_system"; 
		 
		Connection conn1=DriverManager.getConnection(dburl,"root","");
	    Statement stmt1=conn1.createStatement();
	    String sql="INSERT INTO table_books_record VALUES ('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+a11+"','"+a12+"','"+a13+"','"+a14+"','"+a15+"')";
	         	    stmt1.executeUpdate(sql);
	         	
	        
	    
	   
	    
	}
	
	

	
	
		
}// final ending point:

