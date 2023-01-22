<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/pages/tiles/localizationGeneral.jsp" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> ${error_text}</h1>

<c:if test="${not (sessionScope.errorMessage eq null)}">
		<font color="red"> 
			<c:out value="${sessionScope.errorMessage}" />
		</font> 
</c:if>

<a href="controller?command=go_to_base_page">  </a> 
					<input type="submit" value="${back}" /><br />

<!--  <form action="controller?command=go_to_base_page" method="post">
	<input type="submit" value="${back}" />
</form>-->

</body>
</html>


