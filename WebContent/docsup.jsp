<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><link href="css/cssmenu/menu_assets/styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dokumentum feltöltés</title>
<s:head />
</head>
<body>
 <%@ include file='menu.jsp' %>
 <h3>Feltöltés</h3>
<s:form action="resultAction" namespace="/" 
method="POST" enctype="multipart/form-data">
 
<s:file name="fileUpload" label="Válaszd ki a fájlt: " size="40" />
 
<s:submit value="mehet" name="submit" />
 
</s:form>

</body>
</html>