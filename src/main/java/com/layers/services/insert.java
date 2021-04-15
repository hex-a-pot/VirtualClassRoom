package com.layers.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.layers.dao.AnswersDaoImpl;
import com.layers.dao.DoubtDaoImpl;
import com.layers.dao.MarksDaoImpl;
import com.layers.dao.NewsDaoImpl;
import com.layers.dao.StaffDaoImpl;
import com.layers.dao.StudentDaoImpl;
import com.layers.model.Answers;
import com.layers.model.Doubt;
import com.layers.model.Marks;
import com.layers.model.News;
import com.layers.model.Staff;
import com.layers.model.Student;

/**
 * Servlet implementation class insert
 */
public class insert extends HttpServlet {
	Student student = null;
	Staff staff = null;
	Marks marks = null;
	Doubt doubt = null;
	Answers answer = null;
	News news = null;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public insert() {
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
				student = createStudent(request, response);
				result = StudentDaoImpl.getInstance().insertStudent(student);
			} else if (entity.equals("staff")) {
				staff = createStaff(request, response);
				result = StaffDaoImpl.getInstance().addStaff(staff);
			} else if (entity.equals("marks")) {
				long id = Long.parseLong(request.getParameter("id"));
				if (StudentDaoImpl.getInstance().findStudentById(id)) {
					marks = createMarks(request, response);
					result = MarksDaoImpl.getInstance().addMarks(marks);
				}

				else {
					PrintWriter out = response.getWriter();
					response.setContentType("text/html");
					out.println(
							"<h3>INVALID ID !!!</h3><br><br><input type = \"button\" onclick=\"history.back()\" value = \"Click to get back!\">");
				}
			} else if (entity.equals("doubt")) {
				HttpSession session = request.getSession();
				long studentId = Long.parseLong( (String) session.getAttribute("id") );
				doubt = createDoubt(request, response,studentId);
				result = DoubtDaoImpl.getInstance().addDoubt(doubt, studentId);

			}
			else if (entity.equals("answers")) {
				long doubtId = Long.parseLong(request.getParameter("doubtId"));
				System.out.println(DoubtDaoImpl.getInstance().findDoubtById(doubtId));
				if (DoubtDaoImpl.getInstance().findDoubtById(doubtId)) {
					answer = createAnswer(request, response,doubtId);
					result = AnswersDaoImpl.getInstance().addAnswer(answer,doubtId);
				}

				else {
					PrintWriter out = response.getWriter();
					response.setContentType("text/html");
					out.println(
							"<h3>INVALID ID !!!</h3><br><br><input type = \"button\" onclick=\"history.back()\" value = \"Click to get back!\">");
				}

			}
			else if (entity.equals("todayNewsForTable")) {
				
				news = createNews(request, response);
				result = NewsDaoImpl.getInstance().addNews(news);
			
			}
			if (result) {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println(
						"<h3>DATA STORED !!!</h3><br><br><input type = \"button\" onclick=\"history.back()\" value = \"Click to get back!\">");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private News createNews(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String todayNews = request.getParameter("todayNews");
		System.out.println(todayNews);
		news = new News(todayNews);
		return news;
	}

	private Answers createAnswer(HttpServletRequest request, HttpServletResponse response, long doubtId) {
		// TODO Auto-generated method stub
		String ans = request.getParameter("answer");
		answer = new Answers(doubtId,ans);
		return answer;
	}

	private Doubt createDoubt(HttpServletRequest request, HttpServletResponse response, long studentId) {
		// TODO Auto-generated method stub
		String doubtDesc = request.getParameter("doubtDesc");
		doubt = new Doubt(studentId,doubtDesc);
		return doubt;
	
	}

	private Marks createMarks(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		long id = Long.parseLong(request.getParameter("id"));
		int physics = Integer.parseInt(request.getParameter("physics"));
		int maths = Integer.parseInt(request.getParameter("maths"));
		int chemistry = Integer.parseInt(request.getParameter("chemistry"));
		int cs = Integer.parseInt(request.getParameter("cs"));
		int english = Integer.parseInt(request.getParameter("english"));
		marks = new Marks(id, maths, chemistry, physics, cs, english);

		return marks;
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
		short age = (short) Integer.parseInt(request.getParameter("age"));
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		staff = new Staff(name, age, pincode, address, city, state, email, userName, password, country);
		return staff;

	}
}
