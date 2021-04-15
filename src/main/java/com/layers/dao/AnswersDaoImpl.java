package com.layers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.layers.model.Answers;
import com.layers.model.Marks;
import com.layers.utilities.JdbcConnection;

public class AnswersDaoImpl implements AnswersDao {
	Connection connection = null;
	PreparedStatement pstmnt = null;
	Statement stmnt = null;
	ResultSet resSet = null;

	private static AnswersDaoImpl answersDao = null;

	public AnswersDaoImpl() {
		super();
	}

	public static AnswersDaoImpl getInstance() {
		if (answersDao == null)
			answersDao = new AnswersDaoImpl();
		return answersDao;
	}

	private Connection getConnection() throws SQLException {
		Connection con = JdbcConnection.getInstance().getConnection();
		return con;
	}

	public ArrayList<Marks> viewAllMarks() throws SQLException {
		ArrayList<Marks> marksList = new ArrayList<Marks>();
		try {
			connection = getConnection();
			stmnt = connection.createStatement();
			String query = "select * from answers";
			resSet = stmnt.executeQuery(query);
			while (resSet.next()) {
				long id = resSet.getLong("id");
				int maths = resSet.getInt("maths");
				int physics = resSet.getInt("physics");
				int chemistry = resSet.getInt("chemistry");
				int cs = resSet.getInt("cs");
				int english = resSet.getInt("english");
				marksList.add(new Marks(id, maths, chemistry, physics, cs, english));

			}
			return marksList;

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

	public ArrayList<Marks> viewAllMarks(long id) throws SQLException {
		ArrayList<Marks> marksList = new ArrayList<Marks>();
		try {
			connection = getConnection();

			String query = "select * from answers where id = ?";
			pstmnt = connection.prepareStatement(query);
			pstmnt.setLong(1, id);
			resSet = pstmnt.executeQuery();
			while (resSet.next()) {
				long studId = resSet.getLong("id");
				int maths = resSet.getInt("maths");
				int physics = resSet.getInt("physics");
				int chemistry = resSet.getInt("chemistry");
				int cs = resSet.getInt("cs");
				int english = resSet.getInt("english");
				marksList.add(new Marks(studId, maths, chemistry, physics, cs, english));

			}
			return marksList;

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
	public boolean addAnswer(Answers answer, long doubtId) throws SQLException {
		// TODO Auto-generated method stub
		try {
			connection = getConnection();
			String query = "insert into answers(doubtId,answer)values(?,?)";
			pstmnt = connection.prepareStatement(query);
			pstmnt.setLong(1, doubtId);
			pstmnt.setString(2, answer.getAnswer());
			pstmnt.executeUpdate();
			System.out.println("ANSWER ADDED!!");
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
	public ArrayList<Answers> viewAllAnswers() throws SQLException {
		ArrayList<Answers> answersList = new ArrayList<Answers>();
		try {
			connection = getConnection();
			stmnt = connection.createStatement();
			String query = "select * from answers";
			resSet = stmnt.executeQuery(query);
			while (resSet.next()) {
				long id = resSet.getLong("doubtId");
				String answer = resSet.getString("answer");
				answersList.add(new Answers(id, answer));

			}
			return answersList;
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

	public boolean editAnswer(Answers answer, long doubtId) {
		try {
			connection = getConnection();
			String query = "update answers set answer = ? where doubtId = ?";
			pstmnt = connection.prepareStatement(query);
			
			pstmnt.setString(1, answer.getAnswer());
			pstmnt.setLong(2, doubtId);
			pstmnt.executeUpdate();
			System.out.println("ANSWER ADDED!!");
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

	public boolean findAnswerById(long doubtId) {
		try {
			connection = getConnection();
			String querry = "select * from answers where doubtId = "+doubtId;
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

//	@Override
//	public ArrayList<Answers> viewAllAnswers(long id) throws SQLException {
//		// TODO Auto-generated method stub
//		ArrayList<Answers> answersList = new ArrayList<Answers>();
//		try {
//			connection = getConnection();
//
//			String query = "select * from answers where id = ?";
//			pstmnt = connection.prepareStatement(query);
//			pstmnt.setLong(1, id);
//			resSet = pstmnt.executeQuery(query);
//			while (resSet.next()) {
//				long doubtId = resSet.getLong("doubtId");
//				String answer = resSet.getString("answer");
//				System.out.println(doubtId);
//				System.out.println(answer);
//				answersList.add(new Answers(doubtId, answer));
//
//			}
//			return answersList;
//		}
//
//		catch (SQLException sqle) {
//			System.out.println("CAN'T EXECUTE QUERY!!");
//			return null;
//
//		} finally
//
//		{
//			try {
//				if (pstmnt != null)
//					pstmnt.close();
//				if (connection != null)
//					connection.close();
//				if (resSet != null)
//					resSet.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		}
//	}

}
