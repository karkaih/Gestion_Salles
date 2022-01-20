<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%if(request.getSession(false).getAttribute("login")==null){ 
	response.sendRedirect("index.jsp");
}
	%>
<%@include file="menu.jsp" %>
<%@include file="ContenuDashboard.jsp" %>
