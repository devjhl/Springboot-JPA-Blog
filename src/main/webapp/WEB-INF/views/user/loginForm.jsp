<%@ page pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/action_page.php">
		<div class="form-group">
			<label for="username">ID</label> <input type="text" class="form-control" placeholder="" id="username">
		</div>

		<div class="form-group">
			<label for="password">Password</label> <input type="password" class="form-control" placeholder="" id="password">
		</div>

		<div class="form-group form-check">
			<label class="form-check-label"> <input class="form-check-input" type="checkbox"> ログイン状態を保持する		
			</label>
		</div>

		<button type="submit" class="btn btn-primary">ログイン</button>
	</form>


</div>
<%@ include file="../layout/footer.jsp"%>




