<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@  page import = "java.util.Calendar" %> 
<%@  page import = "java.util.Date" %> 
<%@  page import = "java.text.SimpleDateFormat" %>

<%
Calendar cal = Calendar.getInstance();
if ( request.getParameter("selected_date") !=null ) {
	cal.setTimeInMillis( Long.parseLong( request.getParameter("selected_date") ) );
}
Date date = cal.getTime();
String selected_date = new SimpleDateFormat("yyyy-MM-dd").format(date);
%>

<html>
<head>
<link href="css/cssmenu/menu_assets/styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Új naptárbejegyzés</title>
</head>
<body>
<h3>Új naptárbejegyzés létrehozása | <a href="new_event.jsp?selected_date=<%= cal.getTimeInMillis() %>">Új esemény létrehozása</a> </h3>
 <%@ include file='session_check.jsp' %>
 <hr/>
 
<div id="new_note_form"> 
 <form action="newnote">
  <div id="note_title">	
 	<label>Feljegyzés neve:</label><input type="text" name='note.title' />
  </div>
  <div id="note_date">	
    <label> Dátum: </label> <input type="text" name="selected_date" value="<%= selected_date  %>"   readonly /><br>
   </div> 
    
   <div id="note_privacy"> 
    <label>láthatóság:</label>
   	<input type="radio" name="privacy" value="private" />privát
   	<input type="radio" name="privacy" value="public" />publikus
   	<input type="radio" name="privacy" value="group" />csoportos<br>
   </div>
   <div id="note_text">	 
    <label>Feljegyzés:</label><br> 
	<textarea name="note.text" cols="30" rows="8"></textarea>
   </div>
   <div id="note_btn">	 	
 	<input type="submit" value="Mentés"/>
   </div>	
 </form> 
</div> 
 
</body>
</html>