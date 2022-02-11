<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">

	<form>
		<div class="form-group">
			<label for="title">タイトル</label> 
			<input type="text" class="form-control" placeholder="" id="title">
			<span class="titleChk"></span>
		</div>

		<div class="form-group">
			<label for="content">内容</label> 
			<textarea class="form-control summernote" rows="5" id="content"></textarea>
		</div>
	</form>
	<a href="/" role="button" class="btn btn-secondary">キャンセル</a>
	<button id="btn-save" class="btn btn-primary">投稿</button>

</div>
<script>
  $('.summernote').summernote({
    tabsize: 2,
    height: 300
  });
</script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>

