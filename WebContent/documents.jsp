<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<!-- <META HTTP-EQUIV="Refresh" CONTENT="0;URL=documents.action"> -->
<link href="css/cssmenu/menu_assets/styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dokumentumok</title>
</head>


<body>
 <%@ include file='menu.jsp' %>
 <h3>Dokumentumok</h3>
<s:form action="doUpload" method="post" enctype="multipart/form-data">
    <s:file name="uploadFile" label="Fájl kiválasztása"/>
    <s:submit value="Mehet"/>

</s:form>
<!--  <div id="cssmenu"> -->
<div>
 <ul>
<li><a href="<s:url action="docscreate"/>">Dokumentum létrehozás</a></li>
 </ul>
</div>

<dl><dt><s:property value="userName"/>
/Főmappa</dt>
<dd>- Almappád</dd>
<dd>- Almappád2</dd>
<dd><a href="<s:url value="C:/projectSave/proba.html"/>">Fájl1</a></dd>
<dd>Fájl2</dd>
<dd>Fájl3</dd>
</dl>

[ <a href="<s:url action="sehovameg"/>">Új mappa</a> ]
<p>és alapból a rootmappa tartalma majd a kiválaszotott mappán belül vhogy dinamikusan mutassa a tartalmát...(?)




</body>
</html>