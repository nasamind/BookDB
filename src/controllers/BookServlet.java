package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelper.ReadQuery;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet(
		description = "Controller for reading book table", 
		urlPatterns = { 
				"/BookServlet", 
				"/read"
		})
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//readQuery object from my dbHelper package
		
		ReadQuery readQuery = new ReadQuery("xe", "sys as sysdba", "hari");//1. create connection
		
		readQuery.doRead();// 2. execute sql query inside 
		
		
		//get html table from readQuery
		String htmlCode = readQuery.getHTMLTable();// string htmlCode contain html table
		
		//pass execution control to read.jsp along with table
		
		request.setAttribute("table", htmlCode);//1st argument = lable in jsp and 2nd argument = value (htmlCode)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/read.jsp");
		dispatcher.forward(request, response);

	}

}
