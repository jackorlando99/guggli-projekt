<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link href="css/cssmenu/menu_assets/styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bejelentkezés</title>
</head>
<body>

 
 <%@ include file='menu.jsp' %>
 <h3>Bejelentkezés</h3>
 
 
 
 
 <s:form action="login">
 	<s:textfield name='loginInfo.loginName' label='Felhasználónév' />
 	<s:textfield name='loginInfo.loginPw' label='Jelszó' />
 	<s:submit value="Bejelentkezés"/>
 </s:form>

 <p><a href='register.jsp'>Regisztráció</a></p>
</body>
</html>