<div id="cssmenu">
 <ul>
<% 
    String[] menuElemek = { "Napt�r", "Dokumentumok", "Csoportok", "T�rk�p", "Bejelentkez�s" };
	String[] menuLinkek = { "calendar.jsp","docsLists.action","groups.jsp","maps.jsp","login.jsp" };
    for (int i=0; i< menuElemek.length;i++)
	 out.println("<li><a href='" + menuLinkek[i] + "'><span>" + menuElemek[i] +"</span></a></li>");
%>
 </ul>
</div>