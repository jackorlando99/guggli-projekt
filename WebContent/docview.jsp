<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/cssmenu/menu_assets/styles.css" rel="stylesheet" type="text/css">
<title>Megtekintés</title>
<script type="text/javascript" src="tinymce/js/tinymce/tinymce.min.js"></script>

<script type="text/javascript">
tinyMCE.init({
    mode : "textareas"

});
</script>
</head>
<body>
 <%@ include file='menu.jsp' %>
  <h3>Dokumentum neve: <s:property value="docName"/></h3>
 Létrehozva: <s:property value="created"/> Legutóbbi módosítás: <s:property value="updated"/><br>
 Tulajdonos: <s:property value="user"/><br> Naptárhoz kötött: <s:property value="calendar"/><br>
 [ <a href="docsedit.action?docID=<s:property value="docID" />">Szerkesztés</a>]  [ <a href="megosztja">Megosztom </a>]<br>
               <sjr:tinymce
                        id="richtextTinymceEditor"
                        name="text"
                        editorLocal="hu"
                        rows="10"
                        cols="80"
                        width="800"
                />	

</body>
</html>