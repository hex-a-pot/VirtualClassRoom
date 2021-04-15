package com.layers.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.layers.model.News;

public interface NewsDao {

	boolean addNews(News news) throws SQLException;

	ArrayList<News> viewAllNews() throws SQLException;

}
