<div id="cssmenu">
 <ul>
<% 
    String[] menuElemek = { "Naptár", "Dokumentumok", "Csoportok", "Térkép", "Bejelentkezés" };
	String[] menuLinkek = { "calendar.jsp","docsLists.action","groups.jsp","maps.jsp","login.jsp" };
    for (int i=0; i< menuElemek.length;i++)
	 out.println("<li><a href='" + menuLinkek[i] + "'><span>" + menuElemek[i] +"</span></a></li>");
%>
 </ul>
</div>