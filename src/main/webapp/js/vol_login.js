$(document).ready(function(){
	//点击完成
	$("#complete").click(function() {
		if($("input[name='vol_name']").val()==""||$("input[name='id_card']").val()==""||$("input[name='political']").val()==""||$("input[name='vol_address']").val()==""||$("input[name='email']").val()==""){
			alert("请完善您的必填信息");
		}
		else if($("number[name='vol_phone']").val()==""||$("number[name='vol_qq']").val()==""){
			alert("请完善您的必填信息");
		}
		else{
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
		    		window.location.href="index.html"
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