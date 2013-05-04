<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link href="css/cssmenu/menu_assets/styles.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Naptár</title>
<style>
table{
	text-align: left; 
	width: 80%;
	table-layout: fixed;

}
td{
	height:65px;
	vertical-align:top;
	
}
#napok{
	font-size: 12px;
}
#esemeny-link{
	font-size: 12px;
}	
a:link{
	text-decoration:none;
	text-align:left;
	
}
#lepteto_kijelzo table{
	table-layout:auto;
	width:10%;
}
#mai_nap{
	background:green;
}
</style>
</head>
<body>

 <%@ include file='menu.jsp' %>
 <%@ include file='session_check.jsp' %>
 <h3>Naptár</h3>

<%@  page import = "java.util.Calendar" %> 
<%@  page import = "java.util.Date" %> 
<%@  page import = "java.text.SimpleDateFormat" %>
 
 <div id='actual-date'>
 <%
 	Calendar now = Calendar.getInstance();
 	Date  nowDate = now.getTime();
 	String df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E").format(nowDate);	
 	out.println(df);
 %>
 </div>
 
 <%
 	Calendar cal = Calendar.getInstance();	
 
 	if ( request.getParameter("timeInMillis") !=null )
 		cal.setTimeInMillis( Long.parseLong(request.getParameter("timeInMillis")) ) ;
 	
 
 	if ( request.getParameter("date-back") != null  )
 		cal.add(Calendar.MONTH,-1);
 	else if ( request.getParameter("date-next") != null )
 		cal.add(Calendar.MONTH,1);
 
 	Date userDate = cal.getTime();
 	String dateformat = new SimpleDateFormat("yyyy-MM").format(userDate);
 %>
 
<div id='lepteto_kijelzo'>
	<table>
		<tr>
			<td>
				<form action="calendar.jsp" method="post" >
					<input type="hidden" name="date-back" value="1" />
					<input type="hidden" name="timeInMillis" value="<%= cal.getTimeInMillis() %>" />	
					<input type="submit" value="&lt" />
				</form>
			</td>	
			<td><%= dateformat %></td>
			<td>
				<form action="calendar.jsp" method="post" >
					<input type="hidden" name="date-next" value="1" />
					<input type="hidden" name="timeInMillis" value="<%= cal.getTimeInMillis() %>" />	
					<input type="submit" value="&gt" />
				</form>
			</td>
		</tr>
	</table> 
</div>


 <%
 	 

 

 boolean mai_nap_volt = false;
 int melyik_nap_elseje=getFirstDayOfMonth(cal);
 Calendar cal_tmp = (Calendar) cal.clone();
 int nap;
 String [] napok = {"Hétfő","Kedd","Szerda","Csütörtök","Péntek","Szombat","Vasárnap"};

 
 if ( melyik_nap_elseje != Calendar.MONDAY){ //ha nem hetfore esik elseje...
  cal_tmp.add(Calendar.MONTH,-1); //elozo honap
  if ( melyik_nap_elseje == Calendar.SUNDAY )
   nap=cal_tmp.getActualMaximum( Calendar.DAY_OF_MONTH )-6;
  else 
   nap=cal_tmp.getActualMaximum( Calendar.DAY_OF_MONTH )-(melyik_nap_elseje-2);
  nap++;
  //cal_tmp.add(Calendar.MONTH,1); //vissza
  }
 else
  nap=1; //hetfore esik elseje BINGO!
 
 
 out.println("<div id=\"naptar\">");
 out.println("<table cellpadding='2' cellspacing='2' border='1' >");
 out.print("<tbody>");
 out.print("<tr>");
 
 for (int i=0;i<7;i++)
  out.print("<th>" + napok[i] + "</th>");
 out.print("</tr>");

 for (int i=0; i<=5; i++){
  out.print("<tr>");
  for (int j=0; j<=6; j++){
// az aktuális nap megjelölése a naptárban	  
	if ( nap == cal.get(Calendar.DAY_OF_MONTH) && cal.get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR) && cal.get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH) && mai_nap_volt == false  ){
		out.print("<td id='mai_nap'>");
		mai_nap_volt = true;
	}	
	else	
		out.print("<td>");

// napok sorszámának megjelenítése a naptárban

	
	Calendar calToParameter = (Calendar) cal_tmp.clone(); //az esemeny és bejegyzés linkekhez tartozó ?selected_date= paramétere
	//azért kell hogy az esemény/bejegyzés a naptáron kiválasztott dátumhoz kötődjék
	
//ha még előző hónap végén vagyunk,akkor elmegynk hó végéig
	if ( nap<=cal_tmp.getActualMaximum(Calendar.DAY_OF_MONTH) ){
	 out.print("<span id='napok'>" + nap++ + "</span>");
	 calToParameter.set(Calendar.DAY_OF_MONTH, nap-1);
	 
	}
// ha elmentünk hó végéig indítjuk az új napot
	else if (nap>cal_tmp.getActualMaximum(Calendar.DAY_OF_MONTH) ){
	  nap=1;
	  cal_tmp.add(Calendar.MONTH,1); 
 	  out.print("<span id='napok'>" + nap++ + "</span>");
//léptetjük a paraméter naptárat is 	  
 	  calToParameter.add(Calendar.MONTH,1);
 	  calToParameter.set(Calendar.DAY_OF_MONTH, nap-1);
	}
   out.print( "<a href=\"#\" onClick=\"window.open('new_note.jsp?selected_date=" + calToParameter.getTimeInMillis() + "','','width=680,height=600,top=0,left=0,toolbar=no,location=yes,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes')\"><span id='esemeny-link'>" + "+</span></a>" );
	   out.print("<br/>");
	   out.print("</td>");
        //nap++;
  }
  out.print("</tr>");
}
out.print("</tbody>");
out.print("</table>");
out.println("</div>");
 
 %>
 
 <%!
 public int getFirstDayOfMonth(Calendar calend){
	 Calendar cal_tmp = (Calendar) calend.clone();
	 cal_tmp.set(Calendar.DAY_OF_MONTH,1);
	 return cal_tmp.get(Calendar.DAY_OF_WEEK);
	} 
 %>
 
</body>
</html>