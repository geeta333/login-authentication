package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserCreateConfirmDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private String sql = "select * from login_user_transaction where loginId = ?";

	public boolean userCheck(String loginUserId) throws SQLException {
		boolean result = false;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);

			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return result;
	}
}
