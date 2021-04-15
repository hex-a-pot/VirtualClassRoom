package com.layers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.layers.model.Student;
import com.layers.utilities.JdbcConnection;

public class StudentDaoImpl implements StudentDao {

	Connection connection = null;
	PreparedStatement pstmnt = null;
	Statement stmnt = null;
	ResultSet resSet = null;

	private static StudentDaoImpl studentDao = null;

	public StudentDaoImpl() {
		super();
	}

	public static StudentDaoImpl getInstance() {
		if (studentDao == null)
			studentDao = new StudentDaoImpl();
		return studentDao;
	}

	private Connection getConnection() throws SQLException {
		Connection con = JdbcConnection.getInstance().getConnection();
		return con;
	}

	@Override
	public boolean insertStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		try {
			connection = getConnection();
			String query = "insert into student(name,age,address,city,state,country,pincode,email,userName,password)values(?,?,?,?,?,?,?,?,?,?)";
			pstmnt = connection.prepareStatement(query);
			pstmnt.setString(1, student.getName());
			pstmnt.setInt(2, student.getAge());
			pstmnt.setString(3, student.getAddress());
			pstmnt.setString(4, student.getCity());
			pstmnt.setString(5, student.getState());
			pstmnt.setString(6, student.getCountry());
			pstmnt.setInt(7, student.getPincode());
			pstmnt.setString(8, student.getEmail());
			pstmnt.setString(9, student.getUserName());
			pstmnt.setString(10, student.getPassword());
			pstmnt.executeUpdate();
			System.out.println("ADDED!!");
			return true;

		} catch (SQLException sqle) {
			System.out.println(" NOT ADDED!!");
			sqle.printStackTrace();
			return false;
		} finally {
			try {
				if (pstmnt != null)
					pstmnt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public boolean validateStudent(String userName, String param2,int option) throws SQLException {
		boolean isValid = false;
		try {
			String Querry = "";
			connection = getConnection();
			if (option == 1)
			{
				Querry = "Select userName, password from Student where username = ? and password = ?";
				
			}
			else
			{
				Querry = "Select userName, password from Student where username = ? and email = ?";
			}
			pstmnt = connection.prepareStatement(Querry);
			pstmnt.setString(1, userName);
			pstmnt.setString(2, param2);
			resSet = pstmnt.executeQuery();
			if (resSet.next())
				isValid = true;
		} catch (SQLException sqle) {
			System.out.println("CAN'T EXECUTE QUERY!!");

		} finally

		{
			try {
				if (pstmnt != null)
					pstmnt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return isValid;

	}


	public void alterPassword(String userName, String newPassword) {
		// TODO Auto-generated method stub
		
		try {
			String Querry = "";
			connection = getConnection();
			Querry = "update Student set password = ? where userName = ?";
			pstmnt = connection.prepareStatement(Querry);
			pstmnt.setString(1, newPassword);
			pstmnt.setString(2, userName);
			pstmnt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println("CAN'T EXECUTE QUERY!!");

		} finally

		{
			try {
				if (pstmnt != null)
					pstmnt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
	}

	@Override
	public boolean deleteStudent(long id) throws SQLException {
		// TODO Auto-generated method stub
		try {
			connection = getConnection();
			String querry = "delete from student where id = "+id;
			pstmnt = connection.prepareStatement(querry);
			int res = pstmnt.executeUpdate();
			if(res == 1)
				return true;
		}
		catch(SQLException sqle)
		{
			System.out.println("UH-OH CAN't BE DELETED!!!");
		}
		finally
		{
			try {
				if (pstmnt != null)
					pstmnt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean editStudent(Student student , long id) throws SQLException {
		// TODO Auto-generated method stub
		try {
			connection = getConnection();
			String querry = "update student set name = ?,age= ?,address= ?,city= ?,state= ?,country= ?,pincode= ?,email= ?,userName= ?,password= ?  where id = "+id;
			pstmnt = connection.prepareStatement(querry);
			pstmnt.setString(1, student.getName());
			pstmnt.setInt(2, student.getAge());
			pstmnt.setString(3, student.getAddress());
			pstmnt.setString(4, student.getCity());
			pstmnt.setString(5, student.getState());
			pstmnt.setString(6, student.getCountry());
			pstmnt.setInt(7, student.getPincode());
			pstmnt.setString(8, student.getEmail());
			pstmnt.setString(9, student.getUserName());
			pstmnt.setString(10, student.getPassword());
			int res = pstmnt.executeUpdate();
			if(res==1)
				return true;
		}
		catch(SQLException sqle)
		{
			System.out.println("UH-OH Student can't BE Found!!!");
		}
		finally
		{
			try {
				if (pstmnt != null)
					pstmnt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
		
	}

	@Override
	public boolean findStudentById(long id) throws SQLException {
		// TODO Auto-generated method stub
		
		try {
			connection = getConnection();
			String querry = "select * from student where id = "+id;
			pstmnt = connection.prepareStatement(querry);
			resSet = pstmnt.executeQuery();
			if(resSet.next())
				return true;
		}
		catch(SQLException sqle)
		{
			System.out.println("UH-OH Student can't BE Found!!!");
		}
		finally
		{
			try {
				if (pstmnt != null)
					pstmnt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public long findIdByUserName(String userName) throws SQLException {
		// TODO Auto-generated method stub
		try {
			connection = getConnection();
			String querry = "select id from student where userName = ?";
			pstmnt = connection.prepareStatement(querry);
			pstmnt.setString(1, userName);
			resSet = pstmnt.executeQuery();
			if(resSet.next())
				return resSet.getLong(1);
			else
				return 0;
		}
		catch(SQLException sqle)
		{
			System.out.println("UH-OH Student can't BE Found!!!");
			return 0;
		}
		finally
		{
			try {
				if (pstmnt != null)
					pstmnt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<Student> viewAllStudent() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Student> studentList = new ArrayList<Student>();
		try {
			connection = getConnection();
			stmnt = connection.createStatement();
			String query = "select * from student";
			resSet = stmnt.executeQuery(query);
			while(resSet.next())
			{
				long id = resSet.getLong("id");
				String name = resSet.getString("name");
				short age = resSet.getShort("age");
				String address = resSet.getString("address");
				String city = resSet.getString("city");
				String state = resSet.getString("state");
				String country = resSet.getString("country");
				int pincode = resSet.getInt("pincode");
				String email = resSet.getString("email");
				String userName = resSet.getString("userName");
				String password = resSet.getString("password");
				studentList.add(new Student(id,name,age,pincode,address,city,state,country,email,userName,password));
				
			}
			return studentList;
			
		}
		catch (SQLException sqle) {
			System.out.println("CAN'T EXECUTE QUERY!!");
			return null;

		} finally

		{
			try {
				if (pstmnt != null)
					pstmnt.close();
				if (connection != null)
					connection.close();
				if (resSet != null)
					resSet.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	@Override
	public String getNameById(long id) throws SQLException {
		String studentName = null;
		try {
			connection = getConnection();
			String query = "select name from student where id = "+id;
			stmnt = connection.createStatement();
			resSet = stmnt.executeQuery(query);
			if(resSet.next())
			studentName = resSet.getString("name");
			return studentName;
			
		}
		catch (SQLException sqle) {
			System.out.println("CAN'T EXECUTE QUERY!!");
			return null;

		} finally

		{
			try {
				if (pstmnt != null)
					pstmnt.close();
				if (connection != null)
					connection.close();
				if (resSet != null)
					resSet.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}






}
