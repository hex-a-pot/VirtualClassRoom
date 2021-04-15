package com.layers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.layers.model.Staff;
import com.layers.utilities.JdbcConnection;

public class StaffDaoImpl implements StaffDao {
	Connection connection = null;
	PreparedStatement pstmnt = null;
	Statement stmnt = null;
	ResultSet resSet = null;

	private static StaffDaoImpl staffDao = null;

	public StaffDaoImpl() {
		super();
	}

	public static StaffDaoImpl getInstance() {
		if (staffDao == null)
			staffDao = new StaffDaoImpl();
		return staffDao;
	}

	private Connection getConnection() throws SQLException {
		Connection con = JdbcConnection.getInstance().getConnection();
		return con;
	}

	@Override
	public ArrayList<Staff> viewAllStaff() throws SQLException {
	
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		try {
			connection = getConnection();
			stmnt = connection.createStatement();
			String query = "select * from staff";
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
				staffList.add(new Staff(id,name,age,pincode,address,city,state,country,email,userName,password));
				
			}
			return staffList;
			
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
	public boolean addStaff(Staff staff) throws SQLException {
		try {
			connection = getConnection();
			String query = "insert into staff(id,name,age,address,city,state,country,pincode,email,userName,password)values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmnt = connection.prepareStatement(query);
			pstmnt.setLong(1,staff.getId());
			pstmnt.setString(2, staff.getName());
			pstmnt.setInt(3, staff.getAge());
			pstmnt.setString(4, staff.getAddress());
			pstmnt.setString(5, staff.getCity());
			pstmnt.setString(6, staff.getState());
			pstmnt.setString(7, staff.getCountry());
			pstmnt.setInt(8, staff.getPincode());
			pstmnt.setString(9, staff.getEmail());
			pstmnt.setString(10, staff.getUserName());
			pstmnt.setString(11, staff.getPassword());
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
	public boolean deleteStaff(long id) throws SQLException {
		// TODO Auto-generated method stub
		try {
			connection = getConnection();
			String querry = "delete from staff where id = "+id;
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
	public boolean editStaff(Staff staff, long id) throws SQLException {
		// TODO Auto-generated method stub
		try {
			connection = getConnection();
			String querry = "update staff set name = ?,age= ?,address= ?,city= ?,state= ?,country= ?,pincode= ?,email= ?,userName= ?,password= ?  where id = "+id;
			pstmnt = connection.prepareStatement(querry);
			pstmnt.setString(1, staff.getName());
			pstmnt.setInt(2, staff.getAge());
			pstmnt.setString(3, staff.getAddress());
			pstmnt.setString(4, staff.getCity());
			pstmnt.setString(5, staff.getState());
			pstmnt.setString(6, staff.getCountry());
			pstmnt.setInt(7, staff.getPincode());
			pstmnt.setString(8, staff.getEmail());
			pstmnt.setString(9, staff.getUserName());
			pstmnt.setString(10, staff.getPassword());
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
	public boolean validateStaff(String userName, String password) throws SQLException {
		boolean isValid = false;
		try {
			String Querry = "";
			connection = getConnection();	
			Querry = "Select userName, password from Staff where username = ? and password = ?";	
			pstmnt = connection.prepareStatement(Querry);
			pstmnt.setString(1, userName);
			pstmnt.setString(2, password);
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
				if (resSet != null)
					resSet.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return isValid;
	}

	@Override
	public boolean findStaffById(long id) throws SQLException {
		// TODO Auto-generated method stub
		try {
			connection = getConnection();
			String querry = "select * from staff where id = "+id;
			pstmnt = connection.prepareStatement(querry);
			resSet = pstmnt.executeQuery();
			if(resSet.next())
				return true;
		}
		catch(SQLException sqle)
		{
			System.out.println("UH-OH Staff can't BE Found!!!");
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
	public String getNameById(long id) {
		String staffName = null;
		try {
			connection = getConnection();
			String query = "select name from staff where id =?";
			pstmnt = connection.prepareStatement(query);
			pstmnt.setLong(1, id);
			resSet = pstmnt.executeQuery(query);
			if(resSet.next())
				staffName = resSet.getString("name");
			return staffName;
			
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
