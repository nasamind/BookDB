/**
 * 
 */
package dbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Book;

/**
 * @author yadha02
 *
 */
public class ReadQuery {

	private Connection connection;
	private ResultSet results;
	
	//0. load driver and 1. create connection
	public ReadQuery(String dbName, String uName, String pwd){
		String url = "jdbc:oracle:thin:@localhost:1521:" + dbName;
		try {
			//0. load driver
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			//1. create connection
			this.connection = DriverManager.getConnection(url, uName, pwd );
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void doRead(){
		String dbQuery = "select * from BOOKDB";
		try {
			PreparedStatement prepareStatementObj = this.connection.prepareStatement(dbQuery);
			this.results = prepareStatementObj.executeQuery();
			/*
			while(this.results.next()){
				System.out.println(this.results.getInt(1)+"	"
						+this.results.getString(2)+"	"+
						this.results.getString(3)+"	"+
						this.results.getInt(4));
				
			}
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getHTMLTable(){ //return table string that is html code..creating html code with given above output
		String table="";
		table +="<table border=1>";
		try {
			while(this.results.next()){
				Book book = new Book();
				book.setBookID(this.results.getInt(1));
				book.setAuthor(this.results.getString(2));
				book.setTitle(this.results.getString(3));
				book.setPages(this.results.getInt(4));
				
				table += "<tr>";
				
				table += "<td>";
				table += book.getBookID();
				table += "</td>";
				
				table += "<td>";
				table += book.getAuthor();
				table += "</td>";
				
				table += "<td>";
				table += book.getTitle();
				table += "</td>";
				
				table += "<td>";
				table += book.getPages();
				table += "</td>";
				
				table += "<td>";
				table += "<a href=update>Update</a> <a href =delete?bookID="+book.getBookID()+">Delete</a>";
				table += "</td>";
				
				table += "</tr>";


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table +="</table>";
		
		return table;
	}
}
