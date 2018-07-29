package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemChangeModificationCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemChangeModificationCompleteAction extends ActionSupport implements SessionAware {

	private String itemName;
	private String itemPrice;
	private String item_stock;
	public Map<String, Object> session;
	private ItemChangeModificationCompleteDAO itemChangeModificationCompleteDAO = new ItemChangeModificationCompleteDAO();

	public String execute() throws SQLException {
		itemChangeModificationCompleteDAO.itemInfoChange(session.get("itemName").toString(),
				session.get("itemPrice").hashCode(), session.get("item_stock").hashCode(), session.get("itemId").hashCode());
		String result = SUCCESS;

		return result;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItem_stock() {
		return item_stock;
	}

	public void setItem_stock(String item_stock) {
		this.item_stock = item_stock;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
