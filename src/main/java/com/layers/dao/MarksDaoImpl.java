package com.layers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.layers.model.Marks;
import com.layers.utilities.JdbcConnection;

public class MarksDaoImpl implements MarksDao {
	
	Connection connection = null;
	PreparedStatement pstmnt = null;
	Statement stmnt = null;
	ResultSet resSet = null;

	private static MarksDaoImpl marksDao = null;

	public MarksDaoImpl() {
		super();
	}

	public static MarksDaoImpl getInstance() {
		if (marksDao == null)
			marksDao = new MarksDaoImpl();
		return marksDao;
	}

	private Connection getConnection() throws SQLException {
		Connection con = JdbcConnection.getInstance().getConnection();
		return con;
	}

	@Override
	public boolean addMarks(Marks marks) throws SQLException {
		try {
			connection = getConnection();
			String query = "insert into marks(id,maths,physics,chemistry,cs,english)values(?,?,?,?,?,?)";
			pstmnt = connection.prepareStatement(query);
			pstmnt.setLong(1, marks.getId());
			pstmnt.setInt(2, marks.getMaths());
			pstmnt.setInt(3, marks.getPhysics());
			pstmnt.setInt(4, marks.getChemistry());
			pstmnt.setInt(5, marks.getCs());
			pstmnt.setInt(6, marks.getEnglish());
			pstmnt.executeUpdate();
			System.out.println("MARKS ADDED!!");
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

	public ArrayList<Marks> viewAllMarks() throws SQLException {
		ArrayList<Marks> marksList = new ArrayList<Marks>();
		try {
			connection = getConnection();
			stmnt = connection.createStatement();
			String query = "select * from marks";
			resSet = stmnt.executeQuery(query);
			while(resSet.next())
			{
				long id = resSet.getLong("id");
				int maths = resSet.getInt("maths");
				int physics = resSet.getInt("physics");
				int chemistry = resSet.getInt("chemistry");
				int cs = resSet.getInt("cs");
				int english = resSet.getInt("english");
				marksList.add(new Marks(id,maths,chemistry,physics,cs,english));
				
			}
			return marksList;
			
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
	
	public ArrayList<Marks> viewAllMarks(long id) throws SQLException {
		ArrayList<Marks> marksList = new ArrayList<Marks>();
		try {
			connection = getConnection();
			
			String query = "select * from marks where id = ?";
			pstmnt = connection.prepareStatement(query);
			pstmnt.setLong(1, id);
			resSet = pstmnt.executeQuery();
			while(resSet.next())
			{
				long studId = resSet.getLong("id");
				int maths = resSet.getInt("maths");
				int physics = resSet.getInt("physics");
				int chemistry = resSet.getInt("chemistry");
				int cs = resSet.getInt("cs");
				int english = resSet.getInt("english");
				marksList.add(new Marks(studId,maths,chemistry,physics,cs,english));
				
			}
			return marksList;
			
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
