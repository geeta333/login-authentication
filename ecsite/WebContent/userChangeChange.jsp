<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<title>userChangeChange画面</title>
	<style type="text/css">
	/*========TAG LAYPUT========*/
	body {
    	margin: 0;
    	padding: 0;
    	line-height: 1.6;
    	letter-spacing: 1px;
    	font-family: Verdana, Helvetica, sans-serif;
    	font-size: 12px;
    	color: #333;
    	background: #fff;
	}

	table {
    	text-align: center;
    	margin: 0 auto;
	}
	/*========ID LAYPUT========*/
	#top {
    	width: 780px;
    	margin: 30px auto;
    	border: 1px solid #333;
	}

	#header {
    	width: 100%;
    	height: 80px;
    	background-color: black;
	}

	#main {
    	width: 100%;
    	height: 500px;
    	text-align: center;
	}

	#footer {
    	width: 100%;
    	height: 80px;
    	background-color: black;
    	clear: both;
	}

	#text-center {
		display: inline-block;
		text-align: center;
	}

	#text-right {
		display: inline-block;
		text-align: right;
	}
	</style>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>userChangeChange</p>
		</div>
		<div>
			<s:if test="userChangeList == null">
				<h3>ユーザー情報は削除されました。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>ユーザー情報は以下になります。</h3>
			<table border="1">
				<tr>
					<th>login_id</th>
					<th>login_pass</th>
					<th>user_name</th>
					<th>administrator</th>
					<th>insert_date</th>
					<th>updated_date</th>
				</tr>
				<s:iterator value="userChangeList">
				<tr>
					<th><s:property value="login_id" /></th>
					<th><s:property value="login_pass" /></th>
					<th><s:property value="user_name" /></th>
					<th><s:property value="administrator" /></th>
					<th><s:property value="insert_date" /></th>
					<th><s:property value="updated_date" /></th>
				</tr>
				</s:iterator>
			</table>
			<s:form action="UserChangeModificationAction">
				<s:submit value="変更する"/>
			</s:form>
			<s:form action="UserChangeChangeAction">
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="削除" />
			</s:form>
			</s:elseif>
			<s:if test="message != null">
				<h3><s:property value="message"/></h3>
			</s:if>
			<div id="text-right">
				<p>UserChange画面へ戻る場合は<a href='<s:url action="UserChangeAction" />'>こちら</a></p>
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
				<p>管理者画面へ戻る場合は<a href='<s:url action="HomeAction" />'>こちら</a></p>
				<p>ログアウトする場合は<a href='<s:url action="LogoutAction" />'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>