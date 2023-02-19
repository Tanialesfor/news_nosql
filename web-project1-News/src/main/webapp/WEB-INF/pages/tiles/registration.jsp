<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/pages/tiles/localizationGeneral.jsp" %>

<div class="body-title">
	<h2> ${registration_page} </h2>
	<h3> ${registration_text} </h3>
</div>

<div class="add-table-margin">
	<form action="controller" method="post">
	
	<table class="news_text_format">
		<tr>
			<td class="space_around_title_text">${name}    </td>
			<td class="space_around_view_text">
			<div class="word-breaker">
				<input type="text" name="name" value="${requestScope.user.userName}" > 
			</div></td>
			
		</tr>
		<tr>
			<td class="space_around_title_text">${email}</td>
			<td class="space_around_view_text">
			<div class="word-breaker">
				<input type="text" name="email" value="${requestScope.user.email}" > 
			</div></td>
				
		</tr>
		<tr>
			<td class="space_around_title_text">${login}</td>
			<td class="space_around_view_text">
			<div class="word-breaker">
				<input type="text" name="login" value="${requestScope.user.login}" > 
			</div></td>
			
		</tr>
		<tr>
			<td class="space_around_title_text">${password}</td>
			<td class="space_around_view_text">
			<div class="word-breaker">
				<input type="text" name="password" value="${requestScope.user.password}" > 
			</div></td>
			
		</tr>
    	</table>
	
	
	<div class="first-view-button">
		<input type="hidden" name="command" value="do_registration" /> 
		<input type="submit" value="${registration_button}" />
	</div>

</form> 
	
	<div class="second-view-button">
	<form action="controller" method="post">
		<input type="hidden" name="command" value="do_sign_out" /> 
		<input type="submit" value="${cancel}" />
	</form>
 </div>   

</div>






