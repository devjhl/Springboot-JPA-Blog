let index = {
		init: function(){
			$("#btn-save").on("click", ()=>{ 
				if($("#username").val() =='' || $("#password").val() =='' || $("#email").val() =='' ) {
					this.check();
				}else if($("#username").val() !='' || $("#password").val() !='' || $("#email").val() !='' ){
					this.check();
					this.save();
				}
			
				});
			$("#btn-update").on("click", ()=>{ 
				if($("#password").val() =='' || $("#email").val() =='') {
					this.check();
				}else if($("#password").val() !='' || $("#email").val() !=''){
					this.check();
					this.update();
				}
				
			});
			$("#btn-login").on("click", ()=>{
				if($("#username").val() =='' && $("#password").val() =='') {
					alert("IDとパスワードを入力してください。");
					return false;
				}
				else if($("#username").val() =='') {
					alert("IDを入力してください。");
					return false;
				}else if($("#password").val() =='') {
					alert("Passwordを入力してください。");
					return false;
				}
			})
			
		},
		
		check: function() {
			if($("#username").val() =='') {
				$(".usernameChk").text("IDを入力してください。");
				$(".usernameChk").css("color", "red");
			}else if(($("#username").val() !='')) {
				$(".usernameChk").text("");
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
			}if($("#password").val() =='') {
				$(".pwChk").text("passwordを入力してください。");
				$(".pwChk").css("color", "red");			
			}else if(($("#password").val() !='')){
				$(".pwChk").text("");
			}
			if($("#email").val() =='') {
				$(".emailChk").text("emailを入力してください。");
				$(".emailChk").css("color", "red");
			}else if(($("#email").val() !='')){
				$(".emailChk").text("");
				var email =  $("#email").val();
				 $.ajax({
			        	async: false,
			            type : 'POST',
			            data : email,
			            url : "/auth/emailCheck",
			            contentType: "application/json; charset=UTF-8",
			            success : function(data) {
			                if (data == "S2") {
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
			}
		},
		
		save: function(){
			let data = {
					username:$("#username").val(),
					password:$("#password").val(),
					email:$("#email").val()
			};
			// 会員加入
			// データ→json insert
			$.ajax({
				type: "POST",
				url: "/auth/join",
				data: JSON.stringify(data), // // http body
				contentType: "application/json; charset=utf-8", // body data
																// type
				dataType:"json" // javascript 文字列
			}).done(function(resp){
				if(resp.status == 500) {
					alert("会員加入が失敗しました。");	
				}else {
					alert("会員加入が完了しました。");
					location.href="/";
				}
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
			$.ajax({
				type: "PUT",
				url: "/user",
				data: JSON.stringify(data), // // http body
				contentType: "application/json; charset=utf-8", // body data
																// type
				dataType:"json" // javascript 文字列
			}).done(function(resp){
				alert("会員情報を変更しました。");
				location.href="/";
			}).fail(function(error){
				return false;
			});
		}
	}

	index.init();