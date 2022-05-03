package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class j_issue_details extends Application{
	
	@FXML private TableView<u_j_Issue_details_class> tableview_books;
	@FXML private TableColumn<u_j_Issue_details_class, String> book_id_col,isbn_number_col,title_col,author_col,
	category_col,publisher_col,language_col,price_col;
	
	@FXML private TextField search_content_field;
	private String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15;

	private ObservableList<u_j_Issue_details_class> masterData = FXCollections.observableArrayList();

	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {

		Stage secondaryStage=new Stage();
		
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		secondaryStage.setX(bounds.getMinX());
		secondaryStage.setY(bounds.getMinY());
		secondaryStage.setWidth(bounds.getWidth());
		secondaryStage.setHeight(bounds.getHeight());
	
		//BorderPane root = new BorderPane();
	    Parent root=FXMLLoader.load(getClass().getResource("/application/j_issue_details.fxml"));
	 
		Scene scene = new Scene(root,800,500);
		scene.getStylesheets().add(getClass().getResource("Login_selector.css").toExternalForm());
	    secondaryStage.setScene(scene);
		secondaryStage.setResizable(false);
		secondaryStage.show();
	
		
	}
	
	// constructor for assigning the values:
	   public j_issue_details() throws SQLException {
			//for mysql database connection:
			String dburl="jdbc:mysql://localhost:3306/library_information_system"; 
			Connection conn1=DriverManager.getConnection(dburl,"root","");
		    Statement stmt1=conn1.createStatement();
		    String sql="Select * from table_books_issue_details";                  
		    ResultSet res =stmt1.executeQuery(sql);
		   
		    while(res.next()) {
		    	a1 = res.getString("book_id");
				a2=res.getString("isbn_number");
				a3=res.getString("title");
				a4=res.getString("author");   
				
				a6=res.getString("category");
				a7=res.getString("first_name");
				a8=res.getString("last_name");
				a9=res.getString("roll_no");
				a10=res.getString("issued_date");
			
				masterData.add(new u_j_Issue_details_class(a1,a2,a3,a4,a6,a7+" "+a8,a9,a10));
		      
		    
		  
			
		    }// ending of while loop:
		}
	   
	   
	   /**
		 * Initializes the controller class. This method is automatically called
		 * after the fxml file has been loaded.
		 * 
		 * Initializes the table columns and sets up sorting and filtering.
		 */
	   @FXML
		private void initialize() {
			// 0. Initialize the columns.
		    book_id_col.setCellValueFactory(cellData -> cellData.getValue().book_idProperty());
			isbn_number_col.setCellValueFactory(cellData -> cellData.getValue().isbn_numberProperty());
			title_col.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
			author_col.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
			category_col.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
			publisher_col.setCellValueFactory(cellData -> cellData.getValue().publisherProperty());
			language_col.setCellValueFactory(cellData -> cellData.getValue().languageProperty());
			price_col.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
			
			
			// 1. Wrap the ObservableList in a FilteredList (initially display all data).
			FilteredList<u_j_Issue_details_class> filteredData = new FilteredList<>(masterData, p -> true);
			
			// 2. Set the filter Predicate whenever the filter changes.
			search_content_field.textProperty().addListener((observable, oldValue, newValue) -> {
				filteredData.setPredicate(book_class -> {
					// If filter text is empty, display all persons.
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}
					
					// Compare first name and last name of every person with filter text.
					String lowerCaseFilter = newValue.toLowerCase();
					
					if (book_class.getBook_id().toLowerCase().indexOf(lowerCaseFilter) != -1) {
						return true; // Filter matches first name.
					} else if (book_class.getIsbn_number().toLowerCase().indexOf(lowerCaseFilter) != -1) {
						return true; // Filter matches last name.
					}
					return false; // Does not match.
				});
			});
			
			// 3. Wrap the FilteredList in a SortedList. 
			SortedList<u_j_Issue_details_class> sortedData = new SortedList<>(filteredData);
			
			// 4. Bind the SortedList comparator to the TableView comparator.
			// 	  Otherwise, sorting the TableView would have no effect.
			sortedData.comparatorProperty().bind(tableview_books.comparatorProperty());
			
			// 5. Add sorted (and filtered) data to the table.
			tableview_books.setItems(sortedData);
			
			
			
			// detecting double click:
			  tableview_books.setRowFactory(tv -> {
		            TableRow<u_j_Issue_details_class> row = new TableRow<>();
		            row.setOnMouseClicked(event -> {
		                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
		                    u_j_Issue_details_class rowData = row.getItem();
		                    System.out.println("Double click on: "+rowData.getPrice());
		                }
		            });
		            return row ;
		        });  //end of detecting double click in the row:
			
		} // end of initialize method:
	   
	   
	   // when user clicks issue book button:
	   public void issue_book_button() {
		   
	   }

	   
	   
	 
} //end of h_search class:
















    
	
		