package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemChangeModificationConfirmAction extends ActionSupport implements SessionAware {
	private String itemName;
	private int itemPrice;
	private int item_stock;
	private Map<String, Object> session;
	private String errorMassage;

	public String execute() {
		String result = SUCCESS;

		if(!(itemName.equals(""))
			&& !(itemPrice == 0)
			&& !(item_stock == 0)) {
			session.put("itemName", itemName);
			session.put("itemPrice", itemPrice);
			session.put("item_stock", item_stock);
		} else {
			setErrorMassage("未入力の項目があります。");
			result = ERROR;
		}
		return result;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItem_stock() {
		return item_stock;
	}

	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMassage() {
		return errorMassage;
	}

	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}

}
