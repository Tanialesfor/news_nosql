<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="ISO-8859-1"%>
         
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page import="java.util.ResourceBundle" %>
<%@ page import="jakarta.servlet.jsp.jstl.fmt.LocalizationContext" %>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />

<fmt:message bundle="${loc}" key="local.general.news_" var="news_"/>
<fmt:message bundle="${loc}" key="local.general.no_news" var="no_news"/>
<fmt:message bundle="${loc}" key="local.general.news_title" var="news_title"/>
<fmt:message bundle="${loc}" key="local.general.news_date" var="news_date"/>
<fmt:message bundle="${loc}" key="local.general.brief" var="brief"/>
<fmt:message bundle="${loc}" key="local.general.content" var="content"/>
<fmt:message bundle="${loc}" key="local.general.submit.delete" var="delete"/>
<fmt:message bundle="${loc}" key="local.general.submit.save" var="save"/>
<fmt:message bundle="${loc}" key="local.general.submit.cancel" var="cancel"/>

<fmt:message bundle="${loc}" key="local.header.en" var="en_button"/>
<fmt:message bundle="${loc}" key="local.header.ru" var="ru_button"/>
<fmt:message bundle="${loc}" key="local.header.news_management" var="news_management"/>
<fmt:message bundle="${loc}" key="local.header.enter_login" var="enter_login"/>
<fmt:message bundle="${loc}" key="local.header.enter_password" var="enter_password"/>
<fmt:message bundle="${loc}" key="local.header.submit.sign_In" var="sign_In"/>
<fmt:message bundle="${loc}" key="local.header.submit.sign_Out" var="sign_Out"/>
<fmt:message bundle="${loc}" key="local.header.registration" var="registration"/>

<fmt:message bundle="${loc}" key="local.menu.news" var="news"/>
<fmt:message bundle="${loc}" key="local.menu.news_list" var="news_list"/>
<fmt:message bundle="${loc}" key="local.menu.add_news" var="add_news"/>

<fmt:message bundle="${loc}" key="local.baseLayout.welcom" var="welcom"/>

<fmt:message bundle="${loc}" key="local.newsList.news_list" var="news_list_b"/>
<fmt:message bundle="${loc}" key="local.newsList.edit" var="editlink"/>
<fmt:message bundle="${loc}" key="local.newsList.view" var="viewlink"/>

<fmt:message bundle="${loc}" key="local.viewNews.submit.edit" var="edit"/>
<fmt:message bundle="${loc}" key="local.viewNews.view_news" var="view_news_b"/>

<fmt:message bundle="${loc}" key="local.addNews.add_news" var="add_news_b"/>

<fmt:message bundle="${loc}" key="local.editNews.edit_news" var="edit_news_b"/>

<fmt:message bundle="${loc}" key="local.guestInfo.guest_info" var="guest_info"/>
<fmt:message bundle="${loc}" key="local.guestInfo.latest_news" var="latest_news"/>

<fmt:message bundle="${loc}" key="local.error.submit.back_to_first_page" var="back"/>
<fmt:message bundle="${loc}" key="local.error.text" var="error_text"/>

<fmt:message bundle="${loc}" key="local.footer" var="footer"/>
