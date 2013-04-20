<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
 <head>
<link href="css/cssmenu/menu_assets/styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dokumentum Feltöltés</title>
</head>
<body>
 <%@ include file='menu.jsp' %>
<h1>A feltöltés sikeres volt. Megtekintheted a dokumentumaid között.(???)</h1>
   Dokumentum: <s:property value="uploadFileFileName"/> <br>
   Típusa: <s:property value="uploadFileContentType"/> <br>
   </body>
</html>