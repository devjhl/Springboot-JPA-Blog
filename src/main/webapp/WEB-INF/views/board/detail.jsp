<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<a href="/" role="button" class="btn btn-secondary">＜</a>
	<c:if test="${principal.user.privilege=='ADMIN'}">
	<a href="/board/${board.id}/updateForm" class="btn btn-warning">修正</a>
	<button id="btn-delete" type="button" class="btn btn-danger">削除</button>
	</c:if>
	<br><br>
   <input type="hidden" id="username" value="${principal.user.username}" />
   <input type="hidden" id="id" value="${board.id}" />
	<hr />
	<div>
		<h3>${board.title}</h3>
	</div>
	<hr />
	<div>
		<div>${board.content}</div>
	</div>
	<hr/>


</div>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>

