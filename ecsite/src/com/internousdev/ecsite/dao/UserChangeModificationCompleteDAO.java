package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserChangeModificationCompleteDAO {
	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private DateUtil dateUtil = new DateUtil();

	private String sql = "update login_user_transaction set login_id = ?, login_pass = ?, user_name = ?, updated_date = ? where id = ?";

	public void userInfoChange(String loginUserId, String loginUserPassword, String userName, int userId) throws SQLException {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, dateUtil.getDate());
			preparedStatement.setInt(5, userId);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}
