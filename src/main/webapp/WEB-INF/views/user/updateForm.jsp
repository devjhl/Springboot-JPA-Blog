<%@ page pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<input type="hidden" id="id" value="${principal.user.id}"/>
		<div class="form-group">
			<label for="username">ID</label> 
			<input type="text" value="${principal.user.username }" class="form-control" placeholder="" id="username" readonly="readonly">
		</div>

		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" class="form-control" placeholder="" id="password">
			<span class="pwChk"></span>
		</div>
		
			<div class="form-group">
			<label for="email">Email</label> 
			<input type="email" class="form-control" placeholder="${principal.user.email}" id="email">
			<span class="emailChk"></span>
		</div>
	</form>
	<button id="btn-update" class="btn btn-primary">変更</button>


</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>




