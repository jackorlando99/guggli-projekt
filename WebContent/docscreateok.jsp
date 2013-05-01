<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
<link href="css/cssmenu/menu_assets/styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dokumentum létrehozás</title>
</head>
<body>
 <%@ include file='menu.jsp' %>
<h4>Feltöltött dok neve:<s:property value="docName"/></h4>
<h4><s:property value="text"/></h4> 
<a href="documents.action">Vissza a dokumentumaimhoz</a>

</body>
</html>