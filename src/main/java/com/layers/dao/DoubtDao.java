package com.layers.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.layers.model.Doubt;


public interface DoubtDao {
	
	boolean addDoubt(Doubt doubt, long studentId) throws SQLException;

	ArrayList<Doubt> viewAllDoubts() throws SQLException;

	boolean findDoubtById(long doubtId) throws SQLException;
	
	boolean validateDoubtByStudent(long studId, long doubtId) throws SQLException;
	
	boolean editDoubt(Doubt doubt, long doubtId) throws SQLException;
}
