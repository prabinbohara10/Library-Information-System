package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class v_dc_admin_manage_others_class {

	private StringProperty book_id;
	private StringProperty isbn_number;


	public v_dc_admin_manage_others_class(String book_id, String isbn_number) {
		this.book_id = new SimpleStringProperty(book_id);
		this.isbn_number = new SimpleStringProperty(isbn_number);

	}
	

	
		

	public String getBook_id() {
	    return book_id.get();
	}

	public void setBook_id(String Book_id) {
		 this.book_id=book_id;
	}

	public String getIsbn_number() {
	    return isbn_number.get();
	}

	public void setIsbn_number(SimpleStringProperty isbn_number) {
	    this.isbn_number=isbn_number;
	}
	



	
	

	//Starting of  property method:
	public StringProperty book_idProperty() {
		return book_id;
	}
	
	public StringProperty isbn_numberProperty() {
	    return isbn_number;
	}
	
	
	
	
}// end of i_Book_class:
