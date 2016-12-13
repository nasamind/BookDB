package dbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteQuery {
	private Connection connection;
	
	public DeleteQuery(String dbName, String userName, String pwd) {
		String url = "jdbc:oracle:thin:@localhost:1521:" + dbName;
		try {
			// 0. load driver
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			//1. connection object
			this.connection = DriverManager.getConnection(url,userName,pwd);
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

	public void doDelete(int bookID){
		String deleteSqlQuery = "delete from BOOKDB where BOOKID ="+ bookID;
		try {
			
			//1. delete prepare statement
			PreparedStatement ps = this.connection.prepareStatement(deleteSqlQuery);
			//set ? value
			//ps.setInt(1, bookID);
			//2. run query
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
