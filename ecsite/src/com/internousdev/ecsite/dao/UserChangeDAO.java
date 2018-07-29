package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserChangeDTO;
import com.internousdev.ecsite.util.DBConnector;
//import com.internousdev.ecsite.util.DateUtil;

public class UserChangeDAO {
//	private DBConnector dbConnector = new DBConnector();
//	private Connection connection = dbConnector.getConnection();
//	private DateUtil dateUtil = new DateUtil();

	public ArrayList<UserChangeDTO> getItemChangeInfo() throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ArrayList<UserChangeDTO> userChangeDTO = new ArrayList<UserChangeDTO>();
		String sql = "select * from login_user_transaction";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				resultSet.previous();

				while (resultSet.next()) {
					UserChangeDTO dto = new UserChangeDTO();
					dto.setId(resultSet.getInt("id"));
					dto.setLogin_id(resultSet.getString("login_id"));
					dto.setLogin_pass(resultSet.getString("login_pass"));
					dto.setUser_name(resultSet.getString("user_name"));
					dto.setAdministrator(resultSet.getInt("administrator"));
					dto.setInsert_date(resultSet.getString("insert_date"));
					dto.setUpdate_date(resultSet.getString("updated_date"));
					userChangeDTO.add(dto);
				}
			} else {
				userChangeDTO = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return userChangeDTO;
	}

//	public void createUser(String login_id, String login_pass, String user_name) throws SQLException {
//		DBConnector dbConnector = new DBConnector();
//		Connection connection = dbConnector.getConnection();
//		String sql = "insert into login_user_transaction (login_id, login_pass, user_name, insert_date) values(?,?,?,?)";
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, login_id);
//			preparedStatement.setString(2, login_pass);
//			preparedStatement.setString(3, user_name);
//			preparedStatement.setString(4, dateUtil.getDate());
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			connection.close();
//		}
//	}


	public int userAllDelete() throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "delete from login_user_transaction where id != 1 ";
		PreparedStatement preparedStatement;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return result;
	}
}
