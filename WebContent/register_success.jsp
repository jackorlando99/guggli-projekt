<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/cssmenu/menu_assets/styles.css" rel="stylesheet" type="text/css">
<title>register successful</title>
</head>
<body>
<%@ include file='menu.jsp' %>
 


 <p>A regisztráció sikeres volt</p>
 <p><s:property value="userReg"></s:property></p> 
</body>
</html>