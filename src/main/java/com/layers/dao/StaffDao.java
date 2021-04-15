package com.layers.dao;

import java.sql.SQLException;
import java.util.ArrayList;


import com.layers.model.Staff;

public interface StaffDao {

	ArrayList<Staff> viewAllStaff() throws SQLException;
	boolean validateStaff(String userName, String password) throws SQLException;
	boolean addStaff(Staff staff) throws SQLException;
	boolean deleteStaff(long id) throws SQLException;
	boolean editStaff(Staff staff,long id) throws SQLException;
	boolean findStaffById(long id) throws SQLException;
	String getNameById(long id)throws SQLException;

}
