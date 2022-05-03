package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class k_issue_book extends Application{
	// declaring variables for FXML controller class:
	
//for books table:
	@FXML private TableView<s_h_Books_class> tableview_books;
	@FXML private TableColumn<s_h_Books_class, String> book_id_col,isbn_number_col,title_col,author_col,
	category_col,publisher_col,language_col,price_col,book_type_col,edition_col,year_col,pages_col,date_added_col;
	
	@FXML private TextField search_content_field;
	private String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15;
	@FXML private TextField selected_book_id_field,selected_isbn_number_field,selected_title_field;
		
	private ObservableList<s_h_Books_class> masterData = FXCollections.observableArrayList();
	
	
//for members table (tableview_books1):
		@FXML private TableView<t_i_Members_class> tableview_books1;
		@FXML private TableColumn<t_i_Members_class, String> book_id_col1,isbn_number_col1,title_col1,author_col1,
		category_col1,publisher_col1,language_col1,price_col1,book_type_col1,edition_col1,year_col1,pages_col1,date_added_col1;
		
		@FXML private TextField search_content_field1;
		private String b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
		@FXML private TextField selected_roll_no_field,selected_full_name_field;
		
     	private ObservableList<t_i_Members_class> masterData1 = FXCollections.observableArrayList();
     	
     	private String c1,c2,c3,c4,c5,c6,c7,c8,c9;
	
	
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
	    Parent root=FXMLLoader.load(getClass().getResource("/application/k_issue_book.fxml"));
	 
		Scene scene = new Scene(root,800,500);
		scene.getStylesheets().add(getClass().getResource("Login_selector.css").toExternalForm());
	    secondaryStage.setScene(scene);
		secondaryStage.setResizable(false);
		secondaryStage.show();
	
		
	}
	
	// constructor for assigning the values:
	   public k_issue_book() throws SQLException {
		//for mysql database connection:
		   
 // for initializing the values of search books(tableview_books):
		   
			String dburl="jdbc:mysql://localhost:3306/library_information_system"; 
			Connection conn1=DriverManager.getConnection(dburl,"root","");
		    Statement stmt1=conn1.createStatement();
		    String sql="Select * from table_books_record";                  
		    ResultSet res =stmt1.executeQuery(sql);
		   
		    while(res.next()) {
		    	a1 = res.getString("book_id");
				a2=res.getString("isbn_number");
				a3=res.getString("title");
				a4=res.getString("author");   
				a5=res.getString("description"); //a5 is missing bcz of description:
				a6=res.getString("category");
				a7=res.getString("publisher");
				a8=res.getString("language");
				a9=res.getString("price");
				a10=res.getString("book_type");
				a11=res.getString("edition");
				a12=res.getString("year");
				a13=res.getString("pages");
				a14=res.getString("shelf");   //a14 is missing
				a15=res.getString("date_added");
	  
		     masterData.add(new s_h_Books_class(a1,a2,a3,a4,a6,a7,a8,a9,a10,a11,a12,a13,a15));
        } // ending of while loop: 
		    
 // for initializing the values of search members(tableview_books1):
		    
				//for mysql database connection:
				String dburl2="jdbc:mysql://localhost:3306/library_information_system"; 
				Connection conn2=DriverManager.getConnection(dburl2,"root","");
			    Statement stmt2=conn2.createStatement();
			    String sql2="Select * from table_students_record";                  
			    ResultSet res2 =stmt2.executeQuery(sql2);
			   
			    while(res2.next()) {
			    	b1 = res2.getString("first_name");
					b2=res2.getString("last_name");
					b3=res2.getString("dob");
					b4=res2.getString("roll_no");   
					b5=res2.getString("standard");
					b6=res2.getString("faculty");
					b7=res2.getString("shift");
					b8=res2.getString("section");
					b9=res2.getString("gender");
					b10=res2.getString("age");
					b11=res2.getString("height"); // height is missing:
					b12=res2.getString("weight"); // weight is missing:
					b13=res2.getString("blood_group"); // blood_group is missing:
					b14=res2.getString("address");
					b15=res2.getString("phone_no");
					b16=res2.getString("email");
			 masterData1.add(new t_i_Members_class(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b14,b15,b16));
			      }// ending of while loop:
		    
		    
		
}// ending of k_issue_book constructor:
	   
	   
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
			book_type_col.setCellValueFactory(cellData -> cellData.getValue().book_typeProperty());
			edition_col.setCellValueFactory(cellData -> cellData.getValue().editionProperty());
			year_col.setCellValueFactory(cellData -> cellData.getValue().yearProperty());
			pages_col.setCellValueFactory(cellData -> cellData.getValue().pagesProperty());
			date_added_col.setCellValueFactory(cellData -> cellData.getValue().date_addedProperty());
			
	 
			
			// 1. Wrap the ObservableList in a FilteredList (initially display all data).
			FilteredList<s_h_Books_class> filteredData = new FilteredList<>(masterData, p -> true);
			
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
			SortedList<s_h_Books_class> sortedData = new SortedList<>(filteredData);
			
			// 4. Bind the SortedList comparator to the TableView comparator.
			// 	  Otherwise, sorting the TableView would have no effect.
			sortedData.comparatorProperty().bind(tableview_books.comparatorProperty());
			
			
			// 5. Add sorted (and filtered) data to the table.
			tableview_books.setItems(sortedData);
			
			
			
			// detecting double click:
			  tableview_books.setRowFactory(tv -> {
		            TableRow<s_h_Books_class> row = new TableRow<>();
		            row.setOnMouseClicked(event -> {
		                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
		                    s_h_Books_class rowData = row.getItem();
		                    c1=rowData.getBook_id();
		                   	c2=rowData.getIsbn_number();
		                   	c3=rowData.getTitle();
		                	c4=rowData.getAuthor();
		                	c5=rowData.getCategory();
		                
		                	selected_book_id_field.setText(rowData.getBook_id());
		                	selected_isbn_number_field.setText(rowData.getIsbn_number());
		                	selected_title_field.setText(rowData.getTitle());
		                  
		                }
		            });
		            return row ;
		        });  //end of detecting double click in the row:
			  
			  
	 // for search members:
	    book_id_col1.setCellValueFactory(cellData -> cellData.getValue().book_idProperty());
		isbn_number_col1.setCellValueFactory(cellData -> cellData.getValue().isbn_numberProperty());
		title_col1.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
		author_col1.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
		category_col1.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
		publisher_col1.setCellValueFactory(cellData -> cellData.getValue().publisherProperty());
		language_col1.setCellValueFactory(cellData -> cellData.getValue().languageProperty());
		price_col1.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
		book_type_col1.setCellValueFactory(cellData -> cellData.getValue().book_typeProperty());
		edition_col1.setCellValueFactory(cellData -> cellData.getValue().editionProperty());
		year_col1.setCellValueFactory(cellData -> cellData.getValue().yearProperty());
		pages_col1.setCellValueFactory(cellData -> cellData.getValue().pagesProperty());
		date_added_col1.setCellValueFactory(cellData -> cellData.getValue().date_addedProperty());
			
		
		// 1. Wrap the ObservableList in a FilteredList (initially display all data).
					FilteredList<t_i_Members_class> filteredData1 = new FilteredList<>(masterData1, p -> true);
					
					// 2. Set the filter Predicate whenever the filter changes.
					search_content_field1.textProperty().addListener((observable, oldValue, newValue) -> {
						filteredData1.setPredicate(member_class -> {
							// If filter text is empty, display all persons.
							if (newValue == null || newValue.isEmpty()) {
								return true;
							}
							
							// Compare first name and last name of every person with filter text.
							String lowerCaseFilter = newValue.toLowerCase();
							
							if (member_class.getBook_id().toLowerCase().indexOf(lowerCaseFilter) != -1) {
								return true; // Filter matches first name.
							} else if (member_class.getIsbn_number().toLowerCase().indexOf(lowerCaseFilter) != -1) {
								return true; // Filter matches last name.
							}
							return false; // Does not match.
						});
					});
					
					// 3. Wrap the FilteredList in a SortedList.
					
					SortedList<t_i_Members_class> sortedData1 = new SortedList<>(filteredData1);
				
					// 4. Bind the SortedList comparator to the TableView comparator.
					// 	  Otherwise, sorting the TableView would have no effect.
					
					sortedData1.comparatorProperty().bind(tableview_books1.comparatorProperty());
					// 5. Add sorted (and filtered) data to the table.
					tableview_books1.setItems(sortedData1);
					
					
					
					// detecting double click:
					  tableview_books1.setRowFactory(tv -> {
				            TableRow<t_i_Members_class> row1 = new TableRow<>();
				            row1.setOnMouseClicked(event -> {
				                if (event.getClickCount() == 2 && (! row1.isEmpty()) ) {
				                	t_i_Members_class rowData1 = row1.getItem();
				                	 c6=rowData1.getBook_id();
					                 c7=rowData1.getIsbn_number();
					                 c8=rowData1.getAuthor();
					                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					                    Date today_date = new Date();
					                    System.out.println(dateFormat.format(today_date));
					                    c9 = dateFormat.format(today_date);
					                 
					                 
				                			
				                			
				                   	selected_roll_no_field.setText(rowData1.getAuthor());
				                	selected_full_name_field.setText(rowData1.getBook_id()+" "+rowData1.getIsbn_number());
				                 //corresponding roll number and full name:
				                	
				                  
				                }
				            });
				            return row1 ;
				        });  //end of detecting double click in the row:
					  
			  
			
     } // end of initialize method:
	   
	  
	 //when issue_button is clicked:
	   public void issue_book_button() throws SQLException {
		   
		   
		if((selected_book_id_field.getText().equals(""))||
		(selected_isbn_number_field.getText().equals(""))||
       	(selected_title_field.getText().equals(""))||
       	(selected_roll_no_field.getText().equals(""))||
    	(selected_full_name_field.getText().equals("")))
		{ 
		Alert alert = new Alert(AlertType.INFORMATION);	
	    alert.setTitle("There's something wrong");
	    alert.setContentText("Some fields are left empty");
 	    alert.showAndWait();
	    }
		
		
       	
		    String dburl3="jdbc:mysql://localhost:3306/library_information_system"; 
			Connection conn3=DriverManager.getConnection(dburl3,"root","");
		    Statement stmt3=conn3.createStatement();
		    String sql3="INSERT INTO table_books_issue_details VALUES ('"+c1+"','"+c2+"','"+c3+"','"+c4+"','"+c5+"','"+c6+"','"+c7+"','"+c8+"','"+c9+"')";                
		    stmt3.executeUpdate(sql3);
		    
			
	
			
			
		         	
	   }

	   
	   
	 
} //end of h_search class:
















    
	
		