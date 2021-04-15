package com.layers.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
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
 * Servlet implementation class dataToTable
 */
public class dataToTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dataToTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String entity = String.valueOf(session.getAttribute("viewMode"));
		if(entity.equals("staff"))
		{
		System.out.println("Data to table servlet works!!");
			ArrayList<Staff> staffList = new ArrayList<Staff>();
			try {
				staffList  = StaffDaoImpl.getInstance().viewAllStaff();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("UH-OH SOMETHING WENT WRONG!!!");
			}
			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(staffList, new TypeToken<List<Staff>>() {}.getType());

			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
		}
		else if(entity.equals("student"))
		{
		System.out.println("Data to table servlet works!!");
			ArrayList<Student> studentList = new ArrayList<Student>();
			try {
				studentList  = StudentDaoImpl.getInstance().viewAllStudent();
				Collections.sort(studentList, new CompareStudentsByName());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("UH-OH SOMETHING WENT WRONG!!!");
			}
			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(studentList, new TypeToken<List<Student>>() {}.getType());

			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
		}
		else if(entity.equals("marks") && (String.valueOf(session.getAttribute("userType")).equals("administrator") || String.valueOf(session.getAttribute("userType")).equals("staffMember")))
		{
			ArrayList<Marks> marksList = new ArrayList<Marks>();
			try {
				marksList  = MarksDaoImpl.getInstance().viewAllMarks();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("UH-OH SOMETHING WENT WRONG!!!");
			}
			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(marksList, new TypeToken<List<Marks>>() {}.getType());

			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
		}
		else if(entity.equals("marks") && String.valueOf(session.getAttribute("userType")).equals("student"))
		{
			ArrayList<Marks> marksList = new ArrayList<Marks>();
			try {
				String userName = String.valueOf(session.getAttribute("userName"));
	
				long id = StudentDaoImpl.getInstance().findIdByUserName(userName);
		
				marksList  = MarksDaoImpl.getInstance().viewAllMarks(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("UH-OH SOMETHING WENT WRONG!!!");
			}
			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(marksList, new TypeToken<List<Marks>>() {}.getType());

			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
		}
		else if(entity.equals("doubts") && (String.valueOf(session.getAttribute("userType")).equals("administrator") || String.valueOf(session.getAttribute("userType")).equals("staffMember")))
		{
			ArrayList<Doubt> doubtList = new ArrayList<Doubt>();
			try {
				doubtList  = DoubtDaoImpl.getInstance().viewAllDoubts();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("UH-OH SOMETHING WENT WRONG!!!");
			}
			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(doubtList, new TypeToken<List<Doubt>>() {}.getType());

			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
		}
		else if(entity.equals("doubts") && (String.valueOf(session.getAttribute("userType")).equals("student")))
		{
			ArrayList<Doubt> doubtList = new ArrayList<Doubt>();
			try {
				String userName = String.valueOf(session.getAttribute("userName"));
				
				long id = StudentDaoImpl.getInstance().findIdByUserName(userName);
				doubtList  = DoubtDaoImpl.getInstance().findDoubtsByStudId(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("UH-OH SOMETHING WENT WRONG!!!");
			}
			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(doubtList, new TypeToken<List<Doubt>>() {}.getType());

			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
		}
		else if(entity.equals("answers"))
		{
			ArrayList<Answers> answersList = new ArrayList<Answers>();
			try {
		
				answersList  = AnswersDaoImpl.getInstance().viewAllAnswers();
				System.out.println(answersList.get(0).getDoubtId());
				System.out.println(answersList.get(0).getAnswer());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("UH-OH SOMETHING WENT WRONG!!!");
			}
			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(answersList, new TypeToken<List<Answers>>() {}.getType());

			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
			
		}
		else if(entity.equals("news"))
		{
			ArrayList<News> newsList = new ArrayList<News>();
			try {
		
				newsList  = NewsDaoImpl.getInstance().viewAllNews();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("UH-OH SOMETHING WENT WRONG!!!");
			}
			Gson gson = new Gson();
			JsonElement element = gson.toJsonTree(newsList, new TypeToken<List<News>>() {}.getType());

			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
