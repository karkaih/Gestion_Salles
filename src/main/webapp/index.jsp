<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%if(request.getSession(false).getAttribute("login")!=null){ 
	response.sendRedirect("dashboard.jsp");
}
	%>
<%@include file="mazer-main/dist/auth-login.html" %>
