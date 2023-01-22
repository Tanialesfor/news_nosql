<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="body-title">
	<h2>Registration page </h2>
	<h3>To fill in the empty fields, please: </h3>
</div>

<div class="add-table-margin">
	<form action="controller" method="post">
	
	<table class="news_text_format">
		<tr>
			<td class="space_around_title_text">Enter name</td>
			<td class="space_around_view_text">
			<div class="word-breaker">
				<input type="text" name="name" value="${requestScope.user.userName}" > 
			</div></td>
			
		</tr>
		<tr>
			<td class="space_around_title_text">Enter email</td>
			<td class="space_around_view_text">
			<div class="word-breaker">
				<input type="text" name="email" value="${requestScope.user.email}" > 
			</div></td>
				
		</tr>
		<tr>
			<td class="space_around_title_text">Enter login</td>
			<td class="space_around_view_text">
			<div class="word-breaker">
				<input type="text" name="login" value="${requestScope.user.login}" > 
			</div></td>
			
		</tr>
		<tr>
			<td class="space_around_title_text">Enter password</td>
			<td class="space_around_view_text">
			<div class="word-breaker">
				<input type="text" name="password" value="${requestScope.user.password}" > 
			</div></td>
			
		</tr>
    	</table>
	
	
	<div class="first-view-button">
		<input type="hidden" name="command" value="do_registration" /> 
		<input type="submit" value="Registration" />
	</div>

</form> 
	
	<div class="second-view-button">
	<form action="controller" method="post">
		<input type="hidden" name="command" value="do_sign_out" /> 
		<input type="submit" value="Cancel" />
	</form>
 </div>   

</div>






