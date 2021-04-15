package com.layers.dao;

import java.sql.SQLException;

import com.layers.model.Marks;

public interface MarksDao {

	boolean addMarks(Marks marks) throws SQLException;

}
