$(document).ready(function(){
	//点击完成
	$("#complete").click(function() {
		if($("input[name='vol_name']").val()==""||$("input[name='id_card']").val()==""||$("input[name='political']").val()==""||$("input[name='vol_address']").val()==""||$("input[name='email']").val()==""){
			alert("请完善您的必填信息");
		}
		else if($("input[name='vol_phone']").val()==""||$("input[name='vol_qq']").val()==""){
			alert("请完善您的必填信息");
		}
		else{
			var vol_name = $("input[name='vol_name']").val();
			var vol_password = $("input[name='vol_password']").val();
			var id_card = $("input[name='id_card']").val();
			var vol_phone = $("input[name='vol_phone']").val();
			var user_sex = $("input[name='user_sex']").val();
			var political = $("input[name='political']").val();
			var vol_address = $("input[name='vol_address']").val();
			var profession = $("input[name='profession']").val();
			var email = $("input[name='email']").val();
			var vol_age = $("input[name='vol_age']").val();
			var vol_qq = $("input[name='vol_qq']").val();
			var vol_experience = $("textarea[name='vol_experience']").val();
			$.ajax({
				url: '',//新增志愿者信息接口
				type: 'POST',
				data: {vol_name : vol_name , vol_password : vol_password , id_card : id_card , vol_phone : vol_phone , user_sex : user_sex , political : political , vol_address : vol_address , profession : profession , email : email , vol_age : vol_age , vol_qq : vol_qq , vol_experience : vol_experience},
			})
			.success(function(data) {
				console.log("success");
			});
			$(".search_left_img1").hide();
			$(".search_left_img2").show();
			$(".complete_tips").show();
		    var num=$(".complete_tips_con span").text();
		    //console.log(num);
		    function tip_time(){
		    	num=num-1;
		    	//console.log(num);
		    	$('.complete_tips_con span').html(num);
		    	if(num==0){
		    		window.location.href="imformation.html";
		    	}
		    };
		    setInterval(tip_time,1000);
		}
	});
	//光标移开时会提示
	$("input[name='user_name']").blur(function() {
		if($("input[name='user_name']").val()==''){
			alert("请输入姓名");
		}
	});
	$("input[name='vol_password']").blur(function() {
		if($("input[name='vol_password']").val()==''){
			alert("请输入密码");
		}
	});
	$("input[name='id_card']").blur(function() {
		if($("input[name='id_card']").val()==''){
			alert("请输入身份证");
		}
	});
	$("input[name='political']").blur(function() {
		if($("input[name='political']").val()==''){
			alert("请输入政治面貌");
		}
	});
	$("input[name='vol_address']").blur(function() {
		if($("input[name='vol_address']").val()==''){
			alert("请输入联系地址");
		}
	});
	$("input[name='email']").blur(function() {
		if($("input[name='email']").val()==''){
			alert("请输入邮箱");
		}
	});
});