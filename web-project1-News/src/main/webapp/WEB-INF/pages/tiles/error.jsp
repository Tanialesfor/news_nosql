<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/pages/tiles/localizationGeneral.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="styles/newsStyle.css">

</head>
<body>
<h1>${error_page}</h1>
<h3> ${error_text} </h3>

<c:if test="${not (sessionScope.errorMessage eq null)}">
		<font color="red" > 
			<c:out value="${sessionScope.errorMessage}" />
		</font> 
</c:if>

<form action="controller" method="post">
		<input type="hidden" name="command" value="go_to_base_page" /> 
		<input type="submit" value="${back}" />
	</form>

</body>
</html>