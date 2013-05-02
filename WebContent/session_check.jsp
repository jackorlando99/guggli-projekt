<%@ taglib prefix="s" uri="/struts-tags" %>
    
<s:if test="#session['logined'] != 'true' ">
	<jsp:forward page="/login.jsp"></jsp:forward>
</s:if>    