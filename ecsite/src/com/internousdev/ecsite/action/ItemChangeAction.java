package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemChangeDAO;
import com.internousdev.ecsite.dto.ItemChangeDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemChangeAction extends ActionSupport implements SessionAware  {
	public Map<String, Object> session;
	private ItemChangeDAO itemChangeDAO = new ItemChangeDAO();
	private ArrayList<ItemChangeDTO> itemChangeList = new ArrayList<ItemChangeDTO>();
	private String deleteFlg;
	private String message;
//	private String errorMassage;

	public String execute() throws SQLException {
		if(!session.containsKey("id")) {
			return ERROR;
		}

		if(deleteFlg == null) {
			itemChangeList = itemChangeDAO.getItemChangeInfo();
		} else if(deleteFlg.equals("1")) {
			delete();
		}

		String result = SUCCESS;
		return result;
	}


	public void delete() throws SQLException {
		int res = itemChangeDAO.itemAllDelete();

		if(res > 0) {
			itemChangeList = null;
			setMessage("商品情報を正しく削除しました。");
		} else if(res == 0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}


//	public void create(String itemName, int itemPrice, int item_stock) SQLException {
//		if(!(itemName.equals(""))
//				&& !(itemPrice == 0)
//				&& !(item_stock == 0)) {
//			itemChangeDAO.createItem(itemName, itemPrice, item_stock);
//			} else {
//				setErrorMassage("未入力の項目があります。");
//			}
//	}


//	public void delete() throws SQLException {
//		String item_transaction_id = session.get("id").toString();
//		String user_master_id = session.get("login_user_id").toString();
//
//
//		int res = itemChangeDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);
//
//		if(res > 0) {
//			itemChangeList = null;
//			setMessage("商品情報を正しく削除しました。");
//		} else if(res == 0) {
//			setMessage("商品情報の削除に失敗しました。");
//		}
//	}


	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<ItemChangeDTO> getItemChangeList() {
		return this.itemChangeList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

//	public void setErrorMassage(String errorMessage) {
//		this.errorMassage = errorMessage;
//	}

}
