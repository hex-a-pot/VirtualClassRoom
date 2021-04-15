package com.layers.dao;

import java.sql.SQLException;

public interface AdministratorDao {

	boolean validateAdmin(String userName, String password) throws SQLException;

}
