package com.layers.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.layers.dao.AnswersDaoImpl;
import com.layers.dao.DoubtDaoImpl;
import com.layers.dao.StaffDaoImpl;
import com.layers.dao.StudentDaoImpl;
import com.layers.model.Answers;
import com.layers.model.Doubt;
import com.layers.model.Staff;
import com.layers.model.Student;

/**
 * Servlet implementation class edit
 */
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Student student = null;
	Staff staff = null;
	Doubt doubt = null;
	Answers answer = null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public edit() {
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
		HttpSession session = request.getSession();

		String entity = request.getParameter("entity");
		try {
			if (entity.equals("student")) {
				long id = Long.parseLong(request.getParameter("id"));
				if (StudentDaoImpl.getInstance().findStudentById(id)) {
					
					student = createStudent(request,response);
					result = StudentDaoImpl.getInstance().editStudent(student, id);
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
					staff = createStaff(request,response);
					result = StaffDaoImpl.getInstance().editStaff(staff,id);
				}

				else {
					PrintWriter out = response.getWriter();
					response.setContentType("text/html");
					out.println(
							"<h3>INVALID ID !!!</h3><br><br><input type = \"button\" onclick=\"history.back()\" value = \"Click to get back!\">");
				}
			} else if (entity.equals("doubt") && String.valueOf(session.getAttribute("userType")).equals("student")){
				
				String userName = String.valueOf(session.getAttribute("userName"));
				long doubtId = Long.parseLong(request.getParameter("doubtId"));
				long studentId = StudentDaoImpl.getInstance().findIdByUserName(userName);
				if(DoubtDaoImpl.getInstance().validateDoubtByStudent(studentId,doubtId))
				{
					doubt = createDoubt(studentId,request,response);
					result = DoubtDaoImpl.getInstance().editDoubt(doubt,doubtId);
				}
				else
				{
					PrintWriter out = response.getWriter();
					response.setContentType("text/html");
					out.println(
							"<h3>Different user's doubt Id !!!</h3><br><br><input type = \"button\" onclick=\"history.back()\" value = \"Click to get back!\">");
				}
			}
			
			else if (entity.equals("answer")) {
				long doubtId = Long.parseLong(request.getParameter("doubtId"));
				if (AnswersDaoImpl.getInstance().findAnswerById(doubtId)) {
					answer = createAnswer(request,response);
					result = AnswersDaoImpl.getInstance().editAnswer(answer,doubtId);
				}

				else {
					PrintWriter out = response.getWriter();
					response.setContentType("text/html");
					out.println(
							"<h3>INVALID ID !!!</h3><br><br><input type = \"button\" onclick=\"history.back()\" value = \"Click to get back!\">");
				}

			}

			if (result) {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println(
						"<h3>Data Updated !!!</h3><br><br><input type = \"button\" onclick=\"history.back()\" value = \"Click to get back!\">");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	private Answers createAnswer(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		long doubtId = Long.parseLong(request.getParameter("doubtId"));
		String newAnswer = request.getParameter("answer");
		return new Answers(doubtId,newAnswer);
	}

	private Doubt createDoubt(long studId, HttpServletRequest request, HttpServletResponse response) {
		String doubtDesc = request.getParameter("doubt");
		Long doubtId = Long.parseLong(request.getParameter("doubtId")); 
		return new Doubt(studId,doubtId,doubtDesc);
	}

	private Student createStudent(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("name");
		short age = (short) Integer.parseInt(request.getParameter("age"));
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		student = new Student(name, age, pincode, address, city, state, email, userName, password, country);
		return student;

	}
	
private Staff createStaff(HttpServletRequest request, HttpServletResponse response) {
		
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
		staff = new Staff(name,age,pincode,address,city,state,email,userName,password,country);
		return staff;
		
	}
}

