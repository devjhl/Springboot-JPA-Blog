let index = {
		init: function(){
			$("#btn-save").on("click", ()=>{ 
				if($("#title").val() =='' || $("#content").val() == '') {
					alert("入力してください。");
				}else {
					this.save();
				}
				
			})
			$("#btn-delete").on("click", ()=>{ 
				var res = confirm("削除してもいいですか？");
				if(res) {
					this.deleteById();
				}else {
					return false;
				}
			})
			$("#btn-update").on("click", ()=>{ 
				this.update();
			})
			$("#btn-reply-save").on("click", ()=>{ 
				this.replySave();
			})
			
		},
		save: function(){
			let data = {
					title: $("#title").val(),
					content: $("#content").val()
			};
			$.ajax({ 
				type: "POST",
				url: "/api/board",
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp){
				alert("投稿が完了しました。");
				location.href = "/";
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		},
		deleteById: function(){
			let id = $("#id").val();
			$.ajax({ 
				type: "DELETE",
				url: "/api/board/"+id,
				dataType: "json"
			}).done(function(resp){
				alert("削除が完了しました。");
				location.href = "/";
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		},
		update: function(){
			let id = $("#id").val();
			let data = {
					title: $("#title").val(),
					content: $("#content").val()
			};
			$.ajax({ 
				type: "PUT",
				url: "/api/board/"+id,
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp){
				alert("編集が完了しました。.");
				location.href = "/";
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		},
		replySave: function(){
			let data = {
				userId:$("#userId").val(),
				boardId:$("#boardId").val(),
				content: $("#reply-content").val()
			};
			$.ajax({ 
				type: "POST",
				url: `/api/board/${data.boardId}/reply`,
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp){
				alert("コメントを作成しました。");
				location.href = `/board/${data.boardId}`;
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		},
		replyDelete : function(boardId, replyId){
			$.ajax({ 
				type: "DELETE",
				url: `/api/board/${boardId}/reply/${replyId}`,
				dataType: "json"
			}).done(function(resp){
				alert("コメントを削除しました。");
				location.href = `/board/${boardId}`;
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		},
}

index.init();
