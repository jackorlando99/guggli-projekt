<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<%-- <jsp:forward page="/documents.action" /> --%>

<!-- <META HTTP-EQUIV="Refresh" CONTENT="0;URL=documents.action"> -->
<link href="css/cssmenu/menu_assets/styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="userName"/> dokumentumai</title>
</head>


<body>
 <%@ include file='menu.jsp' %>
 <h3><s:property value="userName"/> dokumentumai</h3>

<!-- teszt tablazat -->
<table cellpadding="0" cellspacing="0" border="0" width="250">
<tr>
<td width="50"></td>
<td width="50">Dokumentumok/<s:property value="parentDirName"/></td>
<td width="50">Művelet</td></tr>
<s:iterator value="dirslistlist" var="dirslist">
<tr>
<td width="50">DIR</td>
<td width="50"><a href="documents.action?pID=<s:property value="id"/>"><s:property value="name"/></a></td>
<td width="50"><a href="docsdelete.action?delDirID=<s:property value="id"/>">Törlés</a></td>
</tr></s:iterator>
<s:iterator value="userlistlist" var="userlist">
<tr>
<td width="50">DOC</td>
<td width="50"><a href="docsview.action?docID=<s:property value="id"/>"><s:property value="name"/></a></td>
<td width="50"><a href="docsdelete.action?delDocID=<s:property value="id"/>">Törlés</a></td>
<td width="50"><a href="docsedit.action?docID=<s:property value="id"/>">Szerk.</a></td>
</tr></s:iterator>
<s:iterator value="sharedirslistlist" var="sharedirslist">
<tr>
<td width="50"><span style="color:green">DIR</span></td>
<td width="50"><a href="docsview.action?docID=<s:property value="id"/>"><s:property value="name"/></a></td>
<td width="50"><span style="color:green">Shared</span></td>
</tr></s:iterator>
</table>

<p>
Új mappa létrehozása:
<s:form method="post" action="newdir" namespace="/">
 
 <s:textfield label="Új mappa neve" name="newDocName" />
 

     
               <s:submit value="Mehet" name="submit" />
                </s:form>
                
               <p>
<s:form action="doUpload" method="post" enctype="multipart/form-data">
    <s:file name="uploadFile" label="Dokumentum feltöltése"/>
    <s:submit value="Mehet"/>

</s:form>
<!--  <div id="cssmenu"> -->
<div>
 <ul>
<li><a href="<s:url action="docscreate"/>">Dokumentum létrehozás</a></li>
 </ul>
</div>

</body>
</html>