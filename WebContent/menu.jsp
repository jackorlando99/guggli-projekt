  <%@ taglib prefix="s" uri="/struts-tags" %> 

<div id="cssmenu">
 <ul>
<% 
    String[] menuElemek = { "Napt�r", "Dokumentumok", "Csoportok", "T�rk�p", "Bejelentkez�s" };
	String[] menuLinkek = { "calendar.jsp","documents.action","groups.jsp","maps.action","login.jsp" };
    for (int i=0; i< menuElemek.length;i++)
	 out.println("<li><a href='" + menuLinkek[i] + "'><span>" + menuElemek[i] +"</span></a></li>");    
%>
<%--! <s:if test="#session.logged_in == 'true' "> --%>
	<%--! out.println("<li> <a href='#'> <span id=login_name> Bejelentkezve mint </span></a> </li> <li> <a href='#'> <span id=logout>Kijelentkez�s</span> </a> </li>"); --%>
<%-- </s:if> --%> 
<li>
<a href='#'> <span id='login_name'> Bejelentkezve mint <s:property value="%{#session['loginId]}" /> </span></a>
</li>
<li>
<a href="<s:url action='logOut' />"><span>Kijelentkez�s</span></a>
</li>
 </ul>
</div>