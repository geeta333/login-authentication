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
	<title>itemChange画面</title>
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
			<p>ItemChange</p>
		</div>
		<div>
			<s:if test="itemChangeList == null">
				<h3>商品情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>商品情報は以下になります。</h3>
			<table border="1">
				<tr>
					<th>商品名</th>
					<th>価格</th>
					<th>ストック数</th>
					<th>insert_date</th>
					<th>updated_date</th>
					<th>変更する</th>
				</tr>
				<s:iterator value="itemChangeList">
				<tr>
					<th><s:property value="itemName" /></th>
					<th><s:property value="itemPrice" /><span>円</span></th>
					<th><s:property value="itemStock" /><span>個</span></th>
					<th><s:property value="insert_date" /></th>
					<th><s:property value="update_date" /></th>
					<th>
					<s:form action="ItemChangeChangeAction">
						<input type="hidden" name="itemId" value='<s:property value="id"/>'>
						<s:submit value="変更"/>
					</s:form>
					</th>
				</tr>
				</s:iterator>
			</table>
			</s:elseif>
			<s:form action="ItemChangeCreateAction">
				<s:submit value="商品の追加"/>
			</s:form>
			<s:form action="ItemChangeAction">
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="全部削除" method="delete" />
			</s:form>
			<s:if test="message != null">
				<h3><s:property value="message"/></h3>
			</s:if>
			<div id="text-right">
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