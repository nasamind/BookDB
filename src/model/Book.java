/**
 * 
 */
package model;

/**
 * @author yadha02
 *
 */
public class Book {

	private int bookID;
	private String author;
	private String title;
	private int pages;
	
	/**
	 *default constructor 
	 */
	public Book() {
		super();
		this.bookID = 1;
		this.author = "No author";
		this.title = "No title";
		this.pages = 0;
	}

	
	
	/**
	 * @param bookID
	 * @param author
	 * @param title
	 * @param pages
	 */
	public Book(int bookID, String author, String title, int pages) {
		super();
		this.bookID = bookID;
		this.author = author;
		this.title = title;
		this.pages = pages;
	}



	/**
	 * @return the bookID
	 */
	public int getBookID() {
		return bookID;
	}



	/**
	 * @param bookID the bookID to set
	 */
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}



	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}



	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}



	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}



	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}



	/**
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}



	/**
	 * @param pages the pages to set
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", author=" + author + ", title=" + title + ", pages=" + pages + "]";
	}
	
	
}
