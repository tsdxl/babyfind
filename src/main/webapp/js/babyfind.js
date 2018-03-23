//首页轮播图
$(document).ready(function(){
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
})















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