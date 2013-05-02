  <%@ taglib prefix="s" uri="/struts-tags" %> 

<div id="cssmenu">
 <ul>
<s:if test="#session['logined'] == 'true' " >
<% 
	
    String[] menuElemek = { "Napt�r", "Dokumentumok", "Csoportok", "T�rk�p" };
	String[] menuLinkek = { "calendar.jsp","documents.jsp","groups.jsp","maps.jsp" };
    for (int i=0; i< menuElemek.length;i++)
	 out.println("<li><a href='" + menuLinkek[i] + "'><span>" + menuElemek[i] +"</span></a></li>");    
%>
</s:if> 

<s:if test="#session['logined'] != 'true' " >
<% 
	
    String[] menuElemek = { "T�rk�p" };
	String[] menuLinkek = { "maps.jsp" };
    for (int i=0; i< menuElemek.length;i++)
	 out.println("<li><a href='" + menuLinkek[i] + "'><span>" + menuElemek[i] +"</span></a></li>");    
%>
</s:if>
 
<s:if test="#session['logined'] != 'true' " >
<li> 
	<a href="login.jsp">
		<span id='login'>Bejelentkez�s</span>
	</a>			  
</li>	
</s:if> 
<s:if test="#session['logined'] == 'true' " > 
<li>
	<a href="<s:url action='userinfo' />" > 
		<span id='login_name'> Bejelentkezve mint: 
			<s:property value="%{#session['fullName']}" />
		</span>
	</a>
</li>
<li>
<a href="<s:url action='logout' />"><span id='logout'>Kijelentkez�s</span></a>
</li>
</s:if>



</ul>
</div>