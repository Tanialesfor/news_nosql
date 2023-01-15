<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="body-title">
	<a href="">News >> </a> Add News
</div>

<div class="add-table-margin">
	<table class="news_text_format">
		<tr>
			<td class="space_around_title_text">News Title</td>
			<td class="space_around_view_text">
			<div class="word-breaker">
				 <input type="text" value="${requestScope.news.title }" > 
			</div></td>
			
		</tr>
		<tr>
			<td class="space_around_title_text">News Date</td>
			<td class="space_around_view_text">
			<div class="word-breaker">
				<input type="text" value="${requestScope.news.newsDate }">
			</div></td>
				
		</tr>
		<tr>
			<td class="space_around_title_text">Brief</td>
			<td class="space_around_view_text">
			<div class="word-area-breaker">
			
			<textarea rows="8" cols="50"> 
			<c:out value="${requestScope.news.briefNews }" />
			</textarea>
			</div></td>
			
		</tr>
		<tr>
			<td class="space_around_title_text">Content</td>
			<td class="space_around_view_text">
			<div class="word-area-breaker">
			
			<textarea rows="12" cols="50" > 
			<c:out value="${requestScope.news.content }" />
			</textarea>
			</div></td>
			
		</tr>
	</table>
</div>


<c:if test="${sessionScope.role eq 'admin'}">
<div class="first-view-button">
	<form action="controller" method="post">
		<input type="hidden" name="command" value="do_add_news" /> 
		<input type="hidden" name="id" value="${news.idNews}" /> 
		<input type="submit" value="SAVE" />
	</form>
</div>

<div class="second-view-button">
	<form action="controller" method="post">
		<input type="hidden" name="command" value="go_to_news_list" /> 
		<input type="hidden" name="id" value="${news.idNews}" /> 
		<input type="submit" value="CANCEL" />
	</form>
</div>
</c:if>

