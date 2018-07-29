package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemChangeDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemChangeChangeDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<ItemChangeDTO> getItemChangeInfo(int itemId) throws SQLException {
		ArrayList<ItemChangeDTO> ItemChangeDTO = new ArrayList<ItemChangeDTO>();
		String sql = "select * from item_info_transaction where id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, itemId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				ItemChangeDTO dto = new ItemChangeDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getInt("item_price"));
				dto.setItemStock(resultSet.getInt("item_stock"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				dto.setUpdate_date(resultSet.getString("update_date"));
				ItemChangeDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return ItemChangeDTO;
	}

	public int itemDataDelete (int id) throws SQLException {
		String sql = "delete from item_info_transaction where id = ?";
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
