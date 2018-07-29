package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemChangeChangeDAO;
import com.internousdev.ecsite.dto.ItemChangeDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemChangeChangeAction extends ActionSupport implements SessionAware {
	private int itemId;
	public Map<String, Object> session;
	private ItemChangeChangeDAO itemChangeChangeDAO = new ItemChangeChangeDAO();
	private ArrayList<ItemChangeDTO> itemChangeList = new ArrayList<ItemChangeDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {
		if (!(itemId == 0)) {
			session.put("itemId", itemId);
		}
		if(!session.containsKey("id")) {
			return ERROR;
		}

		if(deleteFlg == null) {
			itemChangeList = itemChangeChangeDAO.getItemChangeInfo(itemId);
		} else if(deleteFlg.equals("1")) {
			delete();
		}

		String result = SUCCESS;
		return result;
	}


	public void delete() throws SQLException {
		int res = itemChangeChangeDAO.itemDataDelete(session.get("itemId").hashCode());

		if(res > 0) {
			itemChangeList = null;
			setMessage("商品情報を正しく削除しました。");
		} else if(res == 0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}


	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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
}
