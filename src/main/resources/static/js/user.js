

let index = {
		init: function(){
			$("#btn-save").on("click",()=>{ 
				if($("#username").val() =='') {
					$(".usernameChk").text("usernameを入力してください。");
					$(".usernameChk").css("color", "red");
				}else if($("#username").val() !='') {
					$(".usernameChk").text("");
				}if($("#password").val() =='') {
					$(".pwChk").text("passwordを入力してください。");
					$(".pwChk").css("color", "red");			
				}else if($("#password").val() !=''){
					$(".pwChk").text("");
				}if($("#email").val() =='') {
					$(".emailChk").text("emailを入力してください。");
					$(".emailChk").css("color", "red");
				}else if($("#email").val() !=''){
					$(".emailChk").text("");
				}if($("#username").val() !='' && $("#password").val() !=''&& $("#email").val() !='') {
					this.save();
				} 
			});
		},
		save: function(){
		
			let data = {
					username:$("#username").val(),
					password:$("#password").val(),
					email:$("#email").val()
			};
			
			//会員加入 
			//データ→json insert
			$.ajax({
				
				type: "POST",
				url: "/blog/api/user",
				data: JSON.stringify(data), // // http body
				contentType: "application/json; charset=utf-8", // body data type
				dataType:"json" // javascript 文字列
			}).done(function(resp){
				alert("会員加入が完了しました。");
				location.href="/blog";
			}).fail(function(error){
				alert(JSON.stringify(error))
			});
		}
	}

	index.init();

