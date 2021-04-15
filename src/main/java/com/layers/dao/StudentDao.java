package com.layers.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.layers.model.Student;

public interface StudentDao {

	boolean insertStudent(Student student) throws SQLException;
	boolean validateStudent(String userName, String password, int option) throws SQLException;
	void alterPassword(String userName, String newPassword) throws SQLException;
	boolean deleteStudent(long id) throws SQLException;
	boolean editStudent(Student student, long id) throws SQLException;
	boolean findStudentById(long id) throws SQLException;
	long findIdByUserName(String userName) throws SQLException;
	ArrayList<Student> viewAllStudent() throws SQLException;
	String getNameById(long id) throws SQLException;

}
