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
	<title>administrator画面</title>
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
			<p>administrator</p>
		</div>
		<div>
			<s:property value="session.administratorUserName"/>さん、管理画面へようこそ！
			<s:form action="ItemChangeAction">
				<s:submit value="商品変更"/>
			</s:form>
			<s:form action="UserChangeAction">
				<s:submit value="ユーザー変更"/>
			</s:form>
			<div id="text-right">
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
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