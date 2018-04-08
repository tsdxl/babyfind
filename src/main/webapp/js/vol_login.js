$(document).ready(function(){
	//点击下一步
	// $("#complete").click(function() {
	// 	if($("input").val()==""){
	// 		alert("请完善您的必填信息");
	// 	}
	// 	else if($(".birth_date").val()==""||$(".miss_date").val()==""){
	// 		alert("请选择日期");
	// 	}
	// 	else if($("number[name='family_phone']").val()==""){
	// 		alert("请正确输入手机号码");
	// 	}
	// 	else if($("textarea[name='feature_description']").val()==''){
	// 		alert("请填写关于失踪人的特征等信息");
	// 	}
	// 	else{
	// 		$(".search_right_two").hide();
	// 		$(".search_left_img2").hide();
	// 		$(".search_right_three").show();
	// 		$(".search_left_img3").show();
	// 	}
	// });
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














/*//轮播不完整版
var i=0;
var timer;
$(function(){
	$(".banner ul li").eq(0).show().siblings().hide();//显示第一张图片，其余隐藏。
	ShowTime();
	$(".tab").hover(function(){
		 //获取到当前鼠标放上去的那个下标索引
		i=$(this).index();
		Show();
		clearInterval(timer);//清除轮播
	},function(){
		ShowTime();//当鼠标离开之后继续轮播
	});
	//左边按钮
	$(".flex_prev").click(function() {
		clearInterval(timer);//清除轮播
		if(i==0){
			i=4;
		}
		i--;//先显示再开始轮播
		Show();
		ShowTime();//轮播
	});
	//右边按钮
	$(".flex_next").click(function(){
		clearInterval(timer);//清除轮播
		if(i==3)
		{
            i=-1;
        }
        i++;
        //先显示再开始轮播
        Show();//显示
        ShowTime();//轮播
    });
});
//图片以及下标显示方法
function Show(){
    //下标为i的图片显示，其余隐藏。
    $(".banner").eq(i).fadeIn(300).siblings().fadeOut(300);
    //当轮播到对应的图片时给下面序号加上一个bg样式，其他移除样式bg。
    $(".tab").eq(i).addClass("bg").siblings().removeClass("bg");
};
//轮播过程方法
function ShowTime() {
    //轮播过程  图片间隔4S轮播一次
    timer=setInterval(function(){
        //间隔多长时间执行前面的方法function(){}
        i++;
        if(i==4)
        {
            i=0;
        }
        Show();
    },4000);
    //轮播过程结束
};
//鼠标移入移出 箭头显示隐藏
$(function(){
	$(".banner").mouseenter(function() {
		$(".banner_btn").fadeIn(500);
	});
	$(".banner").mouseleave(function() {
		$(".banner_btn").fadeOut(500);
	});
});*/