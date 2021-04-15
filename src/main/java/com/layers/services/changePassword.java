package com.layers.services;
import com.layers.dao.StudentDaoImpl;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class changePassword
 */
public class changePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String newPassword = request.getParameter("newPassword");
		boolean found = false;
		try {
			found = StudentDaoImpl.getInstance().validateStudent(userName, email, 2);
			if(found)
			{
				StudentDaoImpl.getInstance().alterPassword(userName,newPassword);
				response.sendRedirect("index.jsp");
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/faultUser.jsp");
				rd.forward(request, response);
			}
			
		}
		catch(SQLException sqle)
		{
			System.out.println("UH-OH!!! There seems to be some error");
		}
//		doGet(request, response);
	}

}
