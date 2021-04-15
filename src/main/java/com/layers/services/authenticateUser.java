package com.layers.services;
import com.layers.dao.AdministratorDaoImpl;
import com.layers.dao.StaffDaoImpl;
import com.layers.dao.StudentDaoImpl;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class authenticateUser
 */
public class authenticateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authenticateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userType = request.getParameter("userType");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html");
//		out.println("<h3>The result is - " + userType + "</h3>");
		boolean userFound = false;
		boolean validUser = false;
		if(userType.equals("student"))
		{
			try
			{
				userFound = StudentDaoImpl.getInstance().validateStudent(userName, password,1);
				if(userFound)
				{
					validUser = true;

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
			
			
		}
		else if(userType.equals("administrator"))
		{
			System.out.println("ADMIN");
			try
			{
				userFound = AdministratorDaoImpl.getInstance().validateAdmin(userName, password);
				if(userFound)
				{
					validUser = true;

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
			
		}
		else
		{
			try
			{
				userFound = StaffDaoImpl.getInstance().validateStaff(userName, password);
				if(userFound)
				{
					validUser = true;

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
			
		}
		if (validUser)
		{
			HttpSession session = request.getSession();
			session.setAttribute("userType", userType);
			session.setAttribute("userName", userName);
			session.setAttribute("password", password);
			response.sendRedirect("welcome.jsp");
		}

}
}
