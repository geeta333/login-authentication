package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserChangeChangeDAO;
import com.internousdev.ecsite.dto.UserChangeDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserChangeChangeAction extends ActionSupport implements SessionAware {
	private int userId;
	public Map<String, Object> session;
	private UserChangeChangeDAO userChangeChangeDAO = new UserChangeChangeDAO();
	private ArrayList<UserChangeDTO> userChangeList = new ArrayList<UserChangeDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {
		if (!(userId == 0)) {
			session.put("userId", userId);
		}
		if(!session.containsKey("id")) {
			return ERROR;
		}

		if(deleteFlg == null) {

		} else if(deleteFlg.equals("1")) {
			delete();
		}

		userChangeList = userChangeChangeDAO.getUserChangeInfo(userId);

		String result = SUCCESS;
		return result;
	}


	public void delete() throws SQLException {
		int res = userChangeChangeDAO.userDataDelete(session.get("userId").hashCode());

		if(res > 0) {
			userChangeList = null;
			setMessage("ユーザー情報を正しく削除しました。");
		} else if(res == 0 && session.get("userId").hashCode() == 1) {
			setMessage(session.get("administratorUserName").toString() + "ユーザーは削除できません。");
		} else if(res == 0) {
			setMessage("ユーザー情報の削除に失敗しました。");
		}
	}


	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
