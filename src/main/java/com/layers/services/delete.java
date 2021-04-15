package com.layers.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.layers.dao.MarksDaoImpl;
import com.layers.dao.StaffDaoImpl;
import com.layers.dao.StudentDaoImpl;

/**
 * Servlet implementation class delete
 */
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public delete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean result = false;
		String entity = request.getParameter("entity");
		try {
			if (entity.equals("student")) {
				long id = Long.parseLong(request.getParameter("id"));

				if (StudentDaoImpl.getInstance().findStudentById(id)) {
					String deletedContent = StudentDaoImpl.getInstance().getNameById(id);
					PrintWriter out = response.getWriter();
					response.setContentType("text/html");
					out.println("<h3>" + deletedContent + "\'s deleted !!!</h3>");
					result = StudentDaoImpl.getInstance().deleteStudent(id);
				}

				else {
					PrintWriter out = response.getWriter();
					response.setContentType("text/html");
					out.println(
							"<h3>INVALID ID !!!</h3><br><br><input type = \"button\" onclick=\"history.back()\" value = \"Click to get back!\">");
				}
			} else if (entity.equals("staff")) {

				long id = Long.parseLong(request.getParameter("id"));
				if (StaffDaoImpl.getInstance().findStaffById(id)) {
					String deletedContent = StaffDaoImpl.getInstance().getNameById(id);
					PrintWriter out = response.getWriter();
					response.setContentType("text/html");
					out.println("<h3>" + deletedContent + "\'s deleted !!!</h3>");
					result = StaffDaoImpl.getInstance().deleteStaff(id);
				}

				else {
					PrintWriter out = response.getWriter();
					response.setContentType("text/html");
					out.println(
							"<h3>INVALID ID !!!</h3><br><br><input type = \"button\" onclick=\"history.back()\" value = \"Click to get back!\">");
				}
			} else {
//				long id = Long.parseLong(request.getParameter("id"));
//				if(StudentDaoImpl.getInstance().findStudentById(id))
//				{
//					marks = createMarks(request,response);
//					result = MarksDaoImpl.getInstance().addMarks(marks);
//				}
//					
//				else
//				{
//					PrintWriter out = response.getWriter();
//					response.setContentType("text/html");
//					out.println("<h3>INVALID ID !!!</h3><br><br><input type = \"button\" onclick=\"history.back()\" value = \"Click to get back!\">");
//				}
			}

			if (result) {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("<br><br><input type = \"button\" onclick=\"history.back()\" value = \"Click to get back!\">");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
