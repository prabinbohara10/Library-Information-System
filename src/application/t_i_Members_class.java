package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class t_i_Members_class {

	private StringProperty book_id;
	private StringProperty isbn_number;
	private StringProperty title;
	private StringProperty author;
	private StringProperty category;
	private StringProperty publisher;
	private StringProperty language;
	private StringProperty price;
	private StringProperty book_type;
	private StringProperty edition;
	private StringProperty year;
	private StringProperty pages;
	private StringProperty date_added;

	public t_i_Members_class(String book_id, String isbn_number, String title, String author, String category,
			String publisher, String language, String price, String book_type,String edition, String year, String pages,String date_added) {
		this.book_id = new SimpleStringProperty(book_id);
		this.isbn_number = new SimpleStringProperty(isbn_number);
		this.title = new SimpleStringProperty(title);
		this.author = new SimpleStringProperty(author);
		this.category = new SimpleStringProperty(category);
		this.publisher = new SimpleStringProperty(publisher);
		this.language = new SimpleStringProperty(language);
		this.price = new SimpleStringProperty(price);
		this.book_type = new SimpleStringProperty(book_type);
		this.edition = new SimpleStringProperty(edition);
		this.year = new SimpleStringProperty(year);
		this.pages = new SimpleStringProperty(pages);
		this.date_added= new SimpleStringProperty(date_added);
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
	//start:
	public String getTitle() {
	    return title.get();
	}

	public void setTitle(SimpleStringProperty title) {
	    this.title=title;
	}  //ending:

	//start:
	public String getAuthor() {
	    return author.get();
	}

	public void setAuthor(SimpleStringProperty author) {
	    this.author=author;
	}  //ending:

	//start:
	public String getCategory() {
	    return category.get();
	}

	public void setCategory(SimpleStringProperty category) {
	    this.category=category;
	}  //ending:

	//start:
	public String getPublisher() {
	    return publisher.get();
	}

	public void setPublisher(SimpleStringProperty publisher) {
	    this.publisher=publisher;
	}  //ending:

	//start:
	public String getLanguage() {
	    return language.get();
	}

	public void setLanguage(SimpleStringProperty language) {
	    this.language=language;
	}  //ending:

	//start:
	public String getPrice() {
	    return price.get();
	}

	public void setPrice(SimpleStringProperty price) {
	    this.price=price;
	}  //ending:

	//start:
	public String getBook_type() {
	    return book_type.get();
	}

	public void setBook_type(SimpleStringProperty book_type) {
	    this.book_type=book_type;
	}  //ending:
	
	//start:
	public String getEdition() {
	    return edition.get();
	}

	public void setEdition(SimpleStringProperty edition) {
	    this.edition=edition;
	}  //ending:
	
	
	
	public String getYear() {
		return year.get();
	}


	public void setYear(SimpleStringProperty year) {
		this.year = year;
	}


	public String getPages() {
		return pages.get();
	}


	public void setPages(SimpleStringProperty pages) {
		this.pages = pages;
	}


	public String getDate_added() {
		return date_added.get();
	}


	public void setDate_added(SimpleStringProperty date_added) {
		this.date_added = date_added;
	}




	
	

	//Starting of  property method:
	public StringProperty book_idProperty() {
		return book_id;
	}
	
	public StringProperty isbn_numberProperty() {
	    return isbn_number;
	}
	
	public StringProperty titleProperty() {
	    return title;
	}
	
	public StringProperty authorProperty() {
	    return author;
	}
	
	public StringProperty categoryProperty() {
	    return category;
	}
	
	public StringProperty publisherProperty() {
	    return publisher;
	}
	
	public StringProperty languageProperty() {
	    return language;
	}
	
	public StringProperty priceProperty() {
	    return price;
	}
	
	public StringProperty book_typeProperty() {
	    return book_type;
	}
	
	public StringProperty editionProperty() {
	    return edition;
	}
	
	public StringProperty yearProperty() {
	    return year;
	}
	
	public StringProperty pagesProperty() {
	    return pages;
	}
	
	public StringProperty date_addedProperty() {
	    return date_added;
	}






	
	
	
	
	
}// end of i_Book_class:
