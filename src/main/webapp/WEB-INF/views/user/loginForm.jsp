<%@ page pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/auth/login" method="post">
		<div class="form-group">
			<label for="username">ID</label>
			<input type="text" name="username"class="form-control" placeholder="" id="username">
		</div>

		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" name="password" class="form-control" placeholder="" id="password">
		</div>

		<button id="btn-login" class="btn btn-primary">ログイン</button>
	</form>


</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>




