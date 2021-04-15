package com.layers.services;

import com.layers.dao.StudentDaoImpl;
import com.layers.model.Staff;
import com.layers.model.Student;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class saveForm
 */
public class saveForm extends HttpServlet {
	Student student = null;
	Staff staff = null;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public saveForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		student = createStudent(request, response);
		try {
			boolean result = StudentDaoImpl.getInstance().insertStudent(student);
			if (result)
				response.sendRedirect("./");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private Student createStudent(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("name");
		short age =  (short) Integer.parseInt(request.getParameter("age")) ;
		int pincode=  Integer.parseInt(request.getParameter("pincode"));
		String address= request.getParameter("address");
		String city= request.getParameter("city");
		String state= request.getParameter("state");
		String email= request.getParameter("email");
		String userName= request.getParameter("userName");
		String password= request.getParameter("password");
		String country= request.getParameter("country");
		student = new Student(name,age,pincode,address,city,state,email,userName,password,country);
		return student;
		
	}
	


}
