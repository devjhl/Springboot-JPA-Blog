<%@ page pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/auth/login" method="post">
		<div class="form-group">
			<label for="username">ID</label> <input type="text" name="username" class="form-control" placeholder="" id="username"> <span class="usernameChk"></span>
		</div>

		<div class="form-group">
			<label for="password">Password</label> <input type="password" name="password" class="form-control" placeholder="" id="password"> <span class="pwChk"></span>
		</div>
		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
			<font color="red">
				<p>
					IDとPasswordが違います。<br />
				</p> <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
			</font>
		</c:if>
		<button id="btn-login" class="btn btn-primary">ログイン</button>
	</form>




</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>




