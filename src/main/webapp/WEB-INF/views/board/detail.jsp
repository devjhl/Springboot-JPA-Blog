<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<a href="/" role="button" class="btn btn-secondary">＜</a>
	<c:if test="${principal.user.role=='ROLE_ADMIN'}">
		<a href="/board/${board.id}/updateForm" class="btn btn-warning">修正</a>
		<button id="btn-delete" type="button" class="btn btn-danger">削除</button>
	</c:if>
	<br>
	<br> <input type="hidden" id="username" value="${principal.user.username}" /> <input type="hidden" id="id" value="${board.id}" />
	<hr />
	<div>
		<h3>${board.title}</h3>
	</div>
	<hr />
	<div>
		<div>${board.content}</div>
	</div>
	<hr />

	<div class="card">
		<form>
		<input type="hidden" id="userId" value="${principal.user.id}">
		<input type="hidden" id="boardId" value="${board.id}">
		<div class="card-body">
			<textarea id="reply-content" class="form-control" rows="1"></textarea>
		</div>
		<c:if test="${!empty principal}">
		<div class="card-footer">
			<button type="button" id="btn-reply-save" class="btn btn-primary">作成</button>
		</div>
		</c:if>
		</form>
	</div>
	<br />
	<div class="card">
		<div class="card-header">コメント一覧</div>
		<ul id="reply-box" class="list-group">
			<c:forEach var="reply" items="${board.replys}">
				<li id="reply-${reply.id}" class="list-group-item d-flex justify-content-between">
					<div>${reply.content}</div>
					<div class="d-flex">
						<div class="font-italic">作成者：${reply.user.username} &nbsp;</div>
						<c:if test="${principal.user.id == reply.user.id || principal.user.role =='ROLE_ADMIN'}">
						<button onclick="index.replyDelete(${board.id},${reply.id})"　class="badge">削除</button>
						</c:if>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>


</div>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>

