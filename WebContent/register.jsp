<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link href="css/cssmenu/menu_assets/styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Regisztráció</title>
</head>
<body>

 
 <%@ include file='menu.jsp' %>
 <h3>Regisztráció</h3>
 
 
 
 
 <s:form action="register">
 	<s:textfield name='userReg.loginLname' label='Vezetéknév' />
 	<s:textfield name='userReg.loginFname' label='Keresztnév' />
 	<s:textfield name='userReg.loginName' label='Felhasználónév' />
 	<s:textfield name='userReg.loginEmail' label='Email' />
 	<s:password name='userReg.loginPw' label='Jelszó' />
 	<s:password name='userReg.loginPw2' label='Jelszó ismét' />
 	<s:submit value="Regisztráció"/>
 </s:form>
 
</body>
</html>