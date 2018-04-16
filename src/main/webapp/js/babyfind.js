$(document).ready(function(){
//首页轮播图start
	var slideBox = $(".slideBox");
	var ul = slideBox.find("ul");
	var oneWidth = slideBox.find("ul li").eq(0).width();
	var number = slideBox.find(".spanBox span");            //注意分号 和逗号的用法
	var timer = null;
	var sw = 0;
	//每个span绑定click事件，完成切换颜色和动画，以及读取参数值
	number.on("click",function (){
	$(this).addClass("active").siblings("span").removeClass("active");
	sw=$(this).index();
	ul.animate({
	    "right":oneWidth*sw,    //ul标签的动画为向左移动；
	       });
	});
	//左右按钮的控制效果
	$(".next").stop(true,true).click(function (){
	 sw++;
	 if(sw==number.length){sw=0};
	 number.eq(sw).trigger("click");
	 });
	$(".prev").stop(true,true).click(function (){
	sw--;
	if(sw==number.length){sw=0};
	number.eq(sw).trigger("click");
	});
	//定时器的使用，自动开始
	timer = setInterval(function (){
	sw++;
	if(sw==number.length){sw=0};
	number.eq(sw).trigger("click");
	},2000);
	//hover事件完成悬停和，左右图标的动画效果
	slideBox.hover(function(){
	$(".next,.prev").animate({
	    "opacity":1,
	    },200);
	clearInterval(timer);
	},function(){
	    $(".next,.prev").animate({
	        "opacity":0.1,
	        },500);
		timer = setInterval(function (){
			sw++;
			if(sw==number.length){sw=0};
			number.eq(sw).trigger("click");
		},2000);
	})
//首页轮播图end

	//上传照片并显示照片
	$('.img_file').change(function() {
	    return change(this, 'file-one');
	});
	function change(obj, itemId) {
	    var a = URL.createObjectURL(obj.files[0]);
	    var urla = obj.files[0];
	    var template = '<img src="'+a+'" width="100%" >';
	    $('.img_box').append(template.replace('{src}', URL.createObjectURL(obj.files[0])));
	}
	//点击寻亲登记中的上一步按钮
	$("#prevstemp").click(function() {
		$(".search_right").show();
		$(".search_left_img1").show();
		$(".search_right_two").hide();
		$(".search_left_img2").hide();
	});
	//点击寻亲登记中的下一步按钮
	$("#nextstemp").click(function() {
		$(".search_right").hide();
		$(".search_left_img1").hide();
		$(".search_right_two").show();
		$(".search_left_img2").show();
	});
	$("#nextstemp2").click(function() {
		if($("input").val()==""){
			alert("请完善您的必填信息");
		}
		else if($(".birth_date").val()==""||$(".miss_date").val()==""){
			alert("请选择日期");
		}
		else if($("number[name='family_phone']").val()==""){
			alert("请正确输入手机号码");
		}
		else if($("textarea[name='feature_description']").val()==''){
			alert("请填写关于失踪人的特征等信息");
		}
		else{
			$(".search_right_two").hide();
			$(".search_left_img2").hide();
			$(".search_right_three").show();
			$(".search_left_img3").show();
		}
	});
	//点击寻亲登记中的完成按钮
	$("#complete").click(function() {
		$(".search_left_img3").hide();
		$(".search_left_img4").show();
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
	});
	//寻亲登记中光标移开时会提示
	$("input[name='user_name']").blur(function() {
		if($("input[name='user_name']").val()==''){
			alert("请输入姓名");
		}
	});
	$("input[name='family_name']").blur(function() {
		if($("input[name='family_name']").val()==''){
			alert("请输入联系人姓名");
		}
	});
	$("input[name='miss_place']").blur(function() {
		if($("input[name='miss_place']").val()==''){
			alert("请输入失踪地点");
		}
	});
	//关于我们中点击跳转到指定位置
	$(".about_list_intro").click(function() {
		var t = $('.about_partgrey').offset().top;
        $('html, body').animate({scrollTop:t}, 300);
	});
	$(".about_list_purpose").click(function() {
		var t = $('.about_partwhite').offset().top;
		$('html, body').animate({scrollTop:t}, 300);
	});
	$(".about_list_recruit").click(function() {
		var t = $('.about_partgrey_two').offset().top;
		$('html, body').animate({scrollTop:t}, 300);
	});
	$(".about_list_contact").click(function() {
		var t = $('.about_partwhite_two').offset().top;
		$('html, body').animate({scrollTop:t}, 300);
	});
	$(".about_top").click(function() {
		$('html, body').animate({scrollTop:0}, 'slow');
	});
	//点击照片对比中的下一步
	$("#upload_next").click(function() {
		if($(".img_box") != null){
			$(".photo_contrast").show();
		}
	});
});
