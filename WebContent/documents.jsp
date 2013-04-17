<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link href="css/cssmenu/menu_assets/styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dokumentumok</title>
</head>


<body>
 <%@ include file='menu.jsp' %>
 <h3>Dokumentumok</h3>
<!--  <div id="cssmenu"> -->
<div>
 <ul>
<li><a href="<s:url action='docsup'/>">Dokumentum feltöltése</a></li>
<li><a href="<s:url action="docscreate"/>">Dokumentum létrehozás</a></li>
 </ul>
</div>
 <s:label key="userName" />
<dl><dt>User/Főmappa</dt>
<dd>- Almappád</dd>
<dd>- Almappád2</dd>
<dd>Fájl1</dd>
<dd>Fájl2</dd>
<dd>Fájl3</dd>
</dl>

[ <a href="<s:url action="sehovameg"/>">Új mappa</a> ]
<p>és alapból a rootmappa tartalma majd a kiválaszotott mappán belül vhogy dinamikusan mutassa a tartalmát...(?)
</body>
</html>