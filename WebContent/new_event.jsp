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
<title>Új esemény létrehozása</title>
</head>
<body>
<h3> <a href="new_note.jsp?selected_date=<%= cal.getTimeInMillis() %>"> Új naptárbejegyzés létrehozása</a> | Új esemény létrehozása </h3>
 <%@ include file='session_check.jsp' %>
 <hr/>
 
<div id="new_event_form"> 
 <form action="event.action">
  <div id="event_title">	
 	<label>Esemény neve:</label><input type="text" name='event.title' />
  </div>
  <div id="event_date">	
    <label> Dátum: </label> <input type="text" name="selected_date" value="<%= selected_date %>" />
   </div> 
  <div id="event_starts" >
  
  	<label>Esemény kezdete:</label>
  	<select>
  		<% 
  		for (int i=0;i<=24;i++)
  			out.print( "<option value='hour'>" + i + "</option>" );
  		%>
	</select>
	<label>:</label>
	<select>
		
  		<%  		
  		for (int i=0;i<=9;i++)
  			out.print( "<option value='minute'>0" + i + "</option>" );
  		
  		for (int i=10;i<=60;i++)
  			out.print( "<option value='minute'>" + i + "</option>" );
  		%>
	</select><br>
	
  
  </div>
   
   <div id="event_ends" >
  
  	<label>Esemény vége:</label>
  	<select>
  		<% 
  		for (int i=0;i<=24;i++)
  			out.print( "<option value='hour'>" + i + "</option>" );
  		%>
	</select>
	<label>:</label>
	<select>
		
  		<%  		
  		for (int i=0;i<=9;i++)
  			out.print( "<option value='minute'>0" + i + "</option>" );
  		
  		for (int i=10;i<=60;i++)
  			out.print( "<option value='minute'>" + i + "</option>" );
  		%>
	</select><br>
	
  
  </div>
  
    <div id="place">	
    <label> Helyszín: </label>
   
    <select>
    <option value="nincs">nincs</option>
    
    </select><br>
   </div>
    
   <div id="event_privacy"> 
    <label>láthatóság:</label>
   	<input type="radio" name="privacy" value="private" />privát
   	<input type="radio" name="privacy" value="group" />csoportos<br>
   </div>
   <div id="event_text">	 
    <label>Megjegyzés:</label><br> 
	<textarea name="event.text" cols="30" rows="8"></textarea>
   </div>
   <div id="event_btn">	 	
 	<input type="submit" value="Létrehozás"/>
   </div>	
 </form> 
</div> 
 
</body>
</html>