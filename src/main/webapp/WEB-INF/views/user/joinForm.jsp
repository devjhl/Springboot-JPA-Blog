<%@ page pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			<label for="username">ID</label> <input type="text" class="form-control" placeholder="" id="username">
		</div>

		<div class="form-group">
			<label for="password">Password</label> <input type="password" class="form-control" placeholder="" id="password">
		</div>
		
			<div class="form-group">
			<label for="email">Email</label> <input type="email" class="form-control" placeholder="" id="email">
		</div>
		
		<button type="submit" class="btn btn-primary">登録</button>
	</form>


</div>
<%@ include file="../layout/footer.jsp"%>




