<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="ISO-8859-1"%>
         
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page import="java.util.ResourceBundle" %>
<%@ page import="jakarta.servlet.jsp.jstl.fmt.LocalizationContext" %>

<%-- the include to copy
 <%@ include file="/WEB-INF/pages/tiles/localizationGeneral.jsp" %>
 --%>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />

<fmt:message bundle="${loc}" key="local.header.en" var="en_button"/>
<fmt:message bundle="${loc}" key="local.header.ru" var="ru_button"/>
<fmt:message bundle="${loc}" key="local.baseLayout.welcom" var="welcom"/>
<fmt:message bundle="${loc}" key="local.header.news_management" var="news_management"/>



<!--<fmt:message bundle="${loc}" key="local.general.submit.delete" var="delete"/>-->
<!--<fmt:message bundle="${loc}" key="local.general.news_title" var="news_title"/>-->