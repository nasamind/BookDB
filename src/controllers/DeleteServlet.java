package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelper.DeleteQuery;


/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet(description = "controller for delete book from BOOKDB", urlPatterns = { "/delete" })
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		//get bookID from request obj
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		
		//1. delete obj .. -> create connection
		DeleteQuery deleteObj = new DeleteQuery("xe", "sys as sysdba", "hari");
		//2. run  delete query
		deleteObj.doDelete(bookID);
		//call again readServlet to display all result 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/read");//calling read servlet..we can call jsp, html or servlet..see javapoint page
		dispatcher.forward(request, response);
	}

}
