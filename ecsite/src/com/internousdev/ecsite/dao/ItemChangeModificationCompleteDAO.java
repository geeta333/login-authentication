package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemChangeModificationCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();
	private String sql = "update item_info_transaction set item_name = ?, item_price = ?, item_stock = ?, update_date = ? where id = ?";
	public void itemInfoChange(String item_name, int item_price, int item_stock, int itemId) throws SQLException {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_name);
			preparedStatement.setInt(2, item_price);
			preparedStatement.setInt(3, item_stock);
			preparedStatement.setString(4, dateUtil.getDate());
			preparedStatement.setInt(5, itemId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

}
