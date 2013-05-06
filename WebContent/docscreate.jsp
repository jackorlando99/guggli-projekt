<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/cssmenu/menu_assets/styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dokumentum létrehozása</title>
<!-- OF COURSE YOU NEED TO ADAPT NEXT LINE TO YOUR tiny_mce.js PATH -->
<script type="text/javascript" src="tinymce/js/tinymce/tinymce.min.js"></script>

<script type="text/javascript">
tinyMCE.init({
    mode : "textareas"



});
</script>
</head>
<body>
 <%@ include file='menu.jsp' %>
 <h3>Dokumentum létrehozás</h3>
 <s:form method="post" action="docsresult" namespace="/">
 
 <s:textfield label="Dokumentum neve:" name="docName" />
 

               <sjr:tinymce
                        id="richtextTinymceEditor"
                        name="text"
                        editorLocal="hu"
                        rows="10"
                        cols="80"
                        width="800"
                />	
               <s:submit value="Mehet" name="submit" />
                </s:form>
                
</body>
</html>