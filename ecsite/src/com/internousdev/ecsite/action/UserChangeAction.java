package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserChangeDAO;
import com.internousdev.ecsite.dto.UserChangeDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserChangeAction extends ActionSupport implements SessionAware  {
	public Map<String, Object> session;
	private UserChangeDAO userChangeDAO = new UserChangeDAO();
	private ArrayList<UserChangeDTO> userChangeList = new ArrayList<UserChangeDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {
		if(!session.containsKey("id")) {
			return ERROR;
		}

		if(deleteFlg == null) {

		} else if(deleteFlg.equals("1")) {
			delete();
		}

		userChangeList = userChangeDAO.getItemChangeInfo();

		String result = SUCCESS;
		return result;
	}


	public void delete() throws SQLException {
		int res = userChangeDAO.userAllDelete();

		if(res > 0) {
			userChangeList.clear();
			setMessage("ユーザー情報を正しく削除しました。");
		} else if(res == 0) {
			setMessage("ユーザー情報の削除に失敗しました。");
		}
	}



	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<UserChangeDTO> getUserChangeList() {
		return this.userChangeList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
