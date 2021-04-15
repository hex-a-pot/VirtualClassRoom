package com.layers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.layers.model.News;
import com.layers.utilities.JdbcConnection;

public class NewsDaoImpl implements NewsDao {
	Connection connection = null;
	PreparedStatement pstmnt = null;
	Statement stmnt = null;
	ResultSet resSet = null;

	private static NewsDaoImpl newsDao = null;

	public NewsDaoImpl() {
		super();
	}

	public static NewsDaoImpl getInstance() {
		if (newsDao == null)
			newsDao = new NewsDaoImpl();
		return newsDao;
	}

	private Connection getConnection() throws SQLException {
		Connection con = JdbcConnection.getInstance().getConnection();
		return con;
	}

	@Override
	public boolean addNews(News news) throws SQLException {
		try {
			connection = getConnection();
			String query = "insert into news(news)values(?)";
			pstmnt = connection.prepareStatement(query);
			pstmnt.setString(1, news.getNews());
			
			pstmnt.executeUpdate();
			System.out.println("NEWS ADDED!!");
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
	public ArrayList<News> viewAllNews() throws SQLException {
		ArrayList<News> newsList = new ArrayList<News>();
		try {
			connection = getConnection();
			stmnt = connection.createStatement();
			String query = "select * from news order by newsId DESC limit 0,5";
			resSet = stmnt.executeQuery(query);
			while(resSet.next())
			{
				long newsId = resSet.getLong("newsId");
				String news = resSet.getString("news");
				
				newsList.add(new News(newsId,news));
				
			}
			return newsList;
			
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
