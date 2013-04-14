<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/cssmenu/menu_assets/styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dokumentum létrehozása</title>
<s:head />
</head>
<body>
 <%@ include file='menu.jsp' %>
 <h3>Létrehozás</h3>
 <s:form action="docscreates" namespace="/">
 
 <s:textfield label="Dokumentum neve:" name="docName" />
 

<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
                <sjr:tinymce
                        id="richtextTinymceEditor"
                        name="echo"
                        rows="10"
                        cols="80"
                        width="800"
                        editorTheme="simple"
                        value="Ide ird a szoveget, de meg nem csinal semmit. Es folyamatosan probalok betenni egy wysiwyg-t."
                />
	<s:submit value="Mehet" name="submit" />
                </s:form>
</body>
</html>