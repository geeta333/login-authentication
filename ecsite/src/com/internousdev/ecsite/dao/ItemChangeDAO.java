package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemChangeDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemChangeDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();

	public ArrayList<ItemChangeDTO> getItemChangeInfo() throws SQLException {
		ArrayList<ItemChangeDTO> ItemChangeDTO = new ArrayList<ItemChangeDTO>();
		String sql = "select * from item_info_transaction";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				resultSet.previous();

				while (resultSet.next()) {
					ItemChangeDTO dto = new ItemChangeDTO();
					dto.setId(resultSet.getInt("id"));
					dto.setItemName(resultSet.getString("item_name"));
					dto.setItemPrice(resultSet.getInt("item_price"));
					dto.setItemStock(resultSet.getInt("item_stock"));
					dto.setInsert_date(resultSet.getString("insert_date"));
					dto.setUpdate_date(resultSet.getString("update_date"));
					ItemChangeDTO.add(dto);
				}
			} else {
				ItemChangeDTO = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return ItemChangeDTO;
	}

	public void createItem(String itemName, int itemPrice, int item_stock) throws SQLException {
		String sql = "insert into item_info_transaction (item_name, item_price, item_stock, insert_date) values(?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, itemName);
			preparedStatement.setInt(2, itemPrice);
			preparedStatement.setInt(3, item_stock);
			preparedStatement.setString(4, dateUtil.getDate());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}


	public int itemAllDelete() throws SQLException {
		String sql = "delete from item_info_transaction ";
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
