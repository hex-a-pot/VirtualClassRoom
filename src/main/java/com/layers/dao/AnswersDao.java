package com.layers.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.layers.model.Answers;

public interface AnswersDao {

	boolean addAnswer(Answers answer, long doubtId) throws SQLException ;
	ArrayList<Answers> viewAllAnswers() throws SQLException ;
//	ArrayList<Answers> viewAllAnswers(long id) throws SQLException ;

}
