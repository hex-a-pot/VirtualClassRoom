package com.layers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.layers.model.Doubt;
import com.layers.utilities.JdbcConnection;

public class DoubtDaoImpl implements DoubtDao {

	Connection connection = null;
	PreparedStatement pstmnt = null;
	Statement stmnt = null;
	ResultSet resSet = null;

	private static DoubtDaoImpl doubtDao = null;

	public DoubtDaoImpl() {
		super();
	}

	public static DoubtDaoImpl getInstance() {
		if (doubtDao == null)
			doubtDao = new DoubtDaoImpl();
		return doubtDao;
	}

	private Connection getConnection() throws SQLException {
		Connection con = JdbcConnection.getInstance().getConnection();
		return con;
	}

	@Override
	public boolean addDoubt(Doubt doubt, long studentId) throws SQLException {
		// TODO Auto-generated method stub
		try {
			connection = getConnection();
			String query = "insert into doubt(studId,doubtDesc)values(?,?)";
			pstmnt = connection.prepareStatement(query);
			pstmnt.setLong(1, studentId);
			pstmnt.setString(2, doubt.getDoubtDesc());
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
	public boolean findDoubtById(long doubtId) {
		// TODO Auto-generated method stub
		try {
			connection = getConnection();
			String querry = "select * from doubt where doubtId = ?";
			pstmnt = connection.prepareStatement(querry);
			pstmnt.setLong(1, doubtId);
			resSet = pstmnt.executeQuery();
			System.out.println(doubtId);
			if (resSet.next()) {
				System.out.println(doubtId);
				return true;
			} else
				return false;

		} catch (SQLException sqle) {
			System.out.println(doubtId);
			System.out.println("UH-OH No such doubt exists!!!");
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
	public ArrayList<Doubt> viewAllDoubts() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Doubt> doubtList = new ArrayList<Doubt>();
		try {
			connection = getConnection();
			stmnt = connection.createStatement();
			String query = "select * from doubt";
			resSet = stmnt.executeQuery(query);
			while (resSet.next()) {
				long studId = resSet.getLong("studId");
				long doubtId = resSet.getLong("doubtId");
				String doubtDesc = resSet.getString("doubtDesc");
				doubtList.add(new Doubt(studId, doubtId, doubtDesc));

			}
			return doubtList;

		} catch (SQLException sqle) {
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

	public ArrayList<Doubt> findDoubtsByStudId(long studId) {
		// TODO Auto-generated method stub
		ArrayList<Doubt> doubtList = new ArrayList<Doubt>();
		try {
			connection = getConnection();
			String querry = "select * from doubt where studId = ?";
			pstmnt = connection.prepareStatement(querry);
			pstmnt.setLong(1, studId);
			resSet = pstmnt.executeQuery();
			while (resSet.next()) {
				long studentId = resSet.getLong("studId");
				long doubtId = resSet.getLong("doubtId");
				String doubtDesc = resSet.getString("doubtDesc");
				doubtList.add(new Doubt(studentId, doubtId, doubtDesc));

			}
			return doubtList;
		} catch (SQLException sqle) {
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
	public boolean validateDoubtByStudent(long studId, long doubtId) throws SQLException {
		try {
			connection = getConnection();
			String querry = "select studId from doubt where doubtId ="+doubtId;
			stmnt = connection.createStatement();
			resSet = stmnt.executeQuery(querry);
			System.out.println(doubtId);
			if (resSet.next()) {
				if (studId == resSet.getLong("studId"))
					return true;
				else
					return false;
			} else
				return false;

		} catch (SQLException sqle) {
			System.out.println(doubtId);
			System.out.println("UH-OH No such doubt exists!!!");
			return false;
		} finally {
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
	public boolean editDoubt(Doubt doubt, long doubtId) throws SQLException {
		try {
			connection = getConnection();
			String query = "update doubt set doubtDesc = ? where doubtId = ?";
			pstmnt = connection.prepareStatement(query);
			pstmnt.setString(1, doubt.getDoubtDesc());
			pstmnt.setLong(2, doubtId);
			pstmnt.executeUpdate();
			System.out.println("UPDATED!!");
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


}
