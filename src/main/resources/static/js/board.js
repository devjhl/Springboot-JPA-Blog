let index = {
		init: function(){
			$("#btn-save").on("click", ()=>{ 
				if($("#title").val() =='') {
					$(".titleChk").text("タイトルを入力してください。");
					$(".titleChk").css("color", "red");
				}else {
					$(".titleChk").text("");
				}
				this.save();
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
}

index.init();
