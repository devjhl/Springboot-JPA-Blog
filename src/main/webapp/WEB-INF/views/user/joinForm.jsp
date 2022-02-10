<%@ page pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			<label for="username">ID</label> 
			<input type="text" class="form-control" placeholder="" id="username">
			<span class="usernameChk"></span>
		</div>

		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" class="form-control" placeholder="" id="password">
			<span class="pwChk"></span>
		</div>
		
			<div class="form-group">
			<label for="email">Email</label> 
			<input type="email" class="form-control" placeholder="" id="email">
			<span class="emailChk"></span>
		</div>
	</form>
	<button id="btn-save" class="btn btn-primary">登録</button>


</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>




