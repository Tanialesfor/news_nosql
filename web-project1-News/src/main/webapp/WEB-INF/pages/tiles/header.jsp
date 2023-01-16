<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/pages/tiles/localizationGeneral.jsp" %>

<div class="wrapper">
	<div class="newstitle"> ${news_management}</div>


	<div class="local-link">

		<div align="left">
		
       <form action="controller" method="post" style ='display:inline-block;'>
        <input type="hidden" name="command" value="do_localization" />
		<input type="hidden" name="local" value="en" /> 
        <input type="submit" value="${en_button}" />
	</form>
	</div>
	<div align="right">
	
      <form action="controller" method="post">
      <input type="hidden" name="command" value="do_localization" style ='display:inline-block;'/>
		<input type="hidden" name="local" value="ru" /> 
		<input type="submit" value="${ru_button}" />
	</form>
</div>

			<!--  <a href=""> en </a> &nbsp;&nbsp; 
			<a	href=""> ru </a> <br /> <br />
		</div>-->

		<c:if test="${not (sessionScope.user eq 'active')}">

			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_in" /> 
					Enter login: <input type="text" name="login" value="" /><br /> 
					Enter password: <input type="password" name="password" value="" /><br />

					<c:if test="${not (requestScope.AuthenticationError eq null)}">
						<font color="red"> 
						   <c:out value="${requestScope.AuthenticationError}" />
						</font> 
					</c:if>
					
					<a href="">Registration</a> <input type="submit" value="Sign In" /><br />
				</form>
			</div>

		</c:if>
		
		<c:if test="${sessionScope.user eq 'active'}">

			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_out" /> 
					<input type="submit" value="Sign Out" /><br />
				</form>
			</div>

		</c:if>
	</div>

</div>
