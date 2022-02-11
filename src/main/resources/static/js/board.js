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
			});
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
				alert("投稿が完了しました。.");
				location.href = "/";
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		},
}

index.init();
