package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserChangeDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserChangeChangeDAO {
//	private DBConnector dbConnector = new DBConnector();
//	private Connection connection = dbConnector.getConnection();

	public ArrayList<UserChangeDTO> getUserChangeInfo(int itemId) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ArrayList<UserChangeDTO> ItemChangeDTO = new ArrayList<UserChangeDTO>();
		String sql = "select * from login_user_transaction where id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, itemId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				UserChangeDTO dto = new UserChangeDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setLogin_id(resultSet.getString("login_id"));
				dto.setLogin_pass(resultSet.getString("login_pass"));
				dto.setUser_name(resultSet.getString("user_name"));
				dto.setAdministrator(resultSet.getInt("administrator"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				dto.setUpdate_date(resultSet.getString("updated_date"));
				ItemChangeDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return ItemChangeDTO;
	}

	public int userDataDelete (int id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "delete from login_user_transaction where id = ? and id != 1";
		PreparedStatement preparedStatement;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return result;
	}

}
