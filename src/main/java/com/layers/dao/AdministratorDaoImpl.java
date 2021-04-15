package com.layers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.layers.utilities.JdbcConnection;

public class AdministratorDaoImpl implements AdministratorDao {
	
	Connection connection = null;
	PreparedStatement pstmnt = null;
	Statement stmnt = null;
	ResultSet resSet = null;
	
	private static AdministratorDaoImpl adminDao = null;
	
	AdministratorDaoImpl()
	{
		super();
	}
	
	public static AdministratorDaoImpl getInstance()
	{
		if(adminDao == null)
			adminDao = new AdministratorDaoImpl();
		return adminDao;
	}
	
	
	private Connection getConnection() throws SQLException
	{
		Connection con = JdbcConnection.getInstance().getConnection();
		return con;
	}

	@Override
	public boolean validateAdmin(String userName, String password) throws SQLException {
		// TODO Auto-generated method stub
		try {
			connection = getConnection();
			String querry = "Select userName, password from administrator where username = ? and password = ?";
			pstmnt = connection.prepareStatement(querry);
			pstmnt.setString(1, userName);
			pstmnt.setString(2, password);
			resSet = pstmnt.executeQuery();
			if(resSet.next())
				return true;
		}
		catch (SQLException sqe)
		{
			System.out.println("CAN'T EXECUTE QUERY!!");
			return false;
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

}
