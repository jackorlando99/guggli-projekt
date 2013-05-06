<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link href="css/cssmenu/menu_assets/styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Térkép</title>
</head>
<body>

 <%@ include file='menu.jsp' %>
 <h3>Térkép</h3>
 <select>
  <option value="szeged">Szeged</option>
</select>




<table style="background-color:#FFFFFF" width="400" cellpadding="0" cellspacing="0">
	<tr>
		<td></td>
		<td><form action="maps.action?y=${y+1}&x=${x}" method="post">
		<center><input type="submit" style="width: 200px" name="button1" value="^" /></center>
		</form></td>
		<td></td>
	</tr>
	<tr>
		<td><form  action="maps.action?y=${y}&x=${x-1}" method="post">
		<center><input type="submit" style="height: 200px" name="button2" value="&lt;" /></center>
		</form></td>
		<td>
<table style="background-color:#FFFFff" width="340" cellpadding="0" cellspacing="0">

	<tr>
		<s:iterator value="MapArr4">
		<td><a href="celldetails.action?id=<s:property value="id"/>"><img src="<s:property value="path"/>"></a></td>
		</s:iterator>
		</tr>
	<tr>
		<s:iterator value="MapArr3">
		<td><a href="celldetails.action?id=<s:property value="id"/>"><img src="<s:property value="path"/>"></a></td>
		</s:iterator>
	</tr>
	<tr>
		<s:iterator value="MapArr2">
		<td><a href="celldetails.action?id=<s:property value="id"/>"><img src="<s:property value="path"/>"></a></td>
		</s:iterator>
	</tr>
	<tr>
		<s:iterator value="MapArr1">
		<td><a href="celldetails.action?id=<s:property value="id"/>"><img src="<s:property value="path"/>"></a></td>
		</s:iterator>
	</tr>
	

</table></td>
		<td><form action="maps.action?y=${y}&x=${x+1}" method="post">
		<center><input type="submit" style="height: 200px" name="button3" value="&gt;" /></center>
		</form></td>
	</tr>
	<tr>
		<td></td>
		<td><form action="maps.action?y=${y-1}&x=${x}" method="post">
		<center><input type="submit" style="width: 200px" name="button4" value="V" /></center>
		</form></td>
		<td></td>
	</tr>
</table>
</body>
</html>