let index = {
		init: function(){
			$("#btn-save").on("click",()=>{ 
				if($("#username").val() =='') {
					$(".usernameChk").text("IDを入力してください。");
					$(".usernameChk").css("color", "red");
				}else if($("#username").val() !='') {
					 var username =  $("#username").val(); 
				        $.ajax({
				        	async: false,
				            type : 'POST',
				            data : username,
				            url : "/auth/idCheck",
				            contentType: "application/json; charset=UTF-8",
				            success : function(data) {
				                if (data == "S") {
				                	$(".usernameChk").text("");
				                } else {
				                	$(".usernameChk").text("既に登録されています。");
									$(".usernameChk").css("color", "red");	
				                }
				            },
				            error: function(req, status, errThrown) {
								alert("network error occur");
							}
				        });
				}
				if($("#password").val() =='') {
					$(".pwChk").text("passwordを入力してください。");
					$(".pwChk").css("color", "red");			
				}else if($("#password").val() !=''){
					$(".pwChk").text("");
				}if($("#email").val() =='') {
					$(".emailChk").text("emailを入力してください。");
					$(".emailChk").css("color", "red");
				}else if($("#email").val() !=''){
					var email =  $("#email").val();
					$(".emailChk").text("");
					 $.ajax({
				        	async: false,
				            type : 'POST',
				            data : email,
				            url : "/auth/emailCheck",
				            contentType: "application/json; charset=UTF-8",
				            success : function(data) {
				                if (data == "S") {
				                	$(".emailChk").text("");
				                } else {
				                	$(".emailChk").text("既に登録されています。");
									$(".emailChk").css("color", "red");	
				                }
				            },
				            error: function(req, status, errThrown) {
								alert("network error occur");
							}
				        });
				}if($("#username").val() !='' && $("#password").val() !=''&& $("#email").val() !='') {
					this.save();
				}
			});
			
		},
		init: function(){
			$("#btn-update").on("click",()=>{ 
				if($("#password").val() =='') {
					$(".pwChk").text("passwordを入力してください。");
					$(".pwChk").css("color", "red");			
				}else if($("#password").val() !=''){
					$(".pwChk").text("");
				}if($("#email").val() =='') {
					$(".emailChk").text("emailを入力してください。");
					$(".emailChk").css("color", "red");
				}else if($("#email").val() !=''){
					var email =  $("#email").val();
					$(".emailChk").text("");
					 $.ajax({
				        	async: false,
				            type : 'POST',
				            data : email,
				            url : "/auth/emailCheck",
				            contentType: "application/json; charset=UTF-8",
				            success : function(data) {
				                if (data == "S") {
				                	$(".emailChk").text("");
				                } else {
				                	$(".emailChk").text("既に登録されています。");
									$(".emailChk").css("color", "red");	
				                }
				            },
				            error: function(req, status, errThrown) {
								alert("network error occur");
							}
				        });
				}if($("#password").val() !=''&& $("#email").val() !='') {
					this.update();
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
				url: "/auth/join",
				data: JSON.stringify(data), // // http body
				contentType: "application/json; charset=utf-8", // body data type
				dataType:"json" // javascript 文字列
			}).done(function(resp){
				alert("会員加入が完了しました。");
				location.href="/";
			}).fail(function(error){
				return false;
			});
		},
		update: function(){
			let data = {
					id:$("#id").val(),
					username:$("#username").val(),
					password:$("#password").val(),
					email:$("#email").val()
			};
			//会員加入 
			//データ→json insert
			$.ajax({
				type: "PUT",
				url: "/user",
				data: JSON.stringify(data), // // http body
				contentType: "application/json; charset=utf-8", // body data type
				dataType:"json" // javascript 文字列
			}).done(function(resp){
				alert("会員情報が変更しました。");
				location.href="/";
			}).fail(function(error){
				return false;
			});
		}
	}

	index.init();