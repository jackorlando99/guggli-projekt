<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link href="css/cssmenu/menu_assets/styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Felhasználói információk</title>
</head>
<body>

 <%@ include file='menu.jsp' %>
 
 <br/><span id='login_name'> Felhasználónév: <s:property value="userName" /> </span>
 <br/><span id='login_name'> UserId: <s:property value="userId" /> </span>
 <br/><span id='full_name'> Teljes név: <s:property value="fullName" /> </span>
 <br/><span id='email'> Email: <s:property value="email" /> </span> 
</body>
</html>