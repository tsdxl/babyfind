//寻亲者验证码
function createCode() {
    code = "";
    var codeLength = 4; //验证码的长度
    var checkCode = document.getElementById("checkCode");
    // var checkcode=$("#checkCode").attr();
    var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
    'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //所有候选组成验证码的字符，当然也可以用中文的
    for (var i = 0; i < codeLength; i++){
        var charNum = Math.floor(Math.random() * 52);
        code += codeChars[charNum];
    }
    if (checkCode){
        checkCode.className = "code";
        checkCode.innerHTML = code;
    }
}
function validateCode(){
    var inputCode = document.getElementById("inputCode").value;
    if (inputCode.length <= 0){
        alert("请输入验证码！");
    }
    else if (inputCode.toUpperCase() != code.toUpperCase()){
        alert("验证码输入有误！");
        createCode();
        $("#inputCode").val("");
        $("#inputCode").focus();
    }
    else{
        $("input[name='vol_name']").blur(function() {
            if($("input[name='vol_name']").val()==''){
                alert("请输入姓名");
            }
        });
        $("input[name='vol_password']").blur(function() {
            if($("input[name='vol_password']").val()==''){
                alert("请输入密码");
            }
        });
        if($("input").val()==""){
            alert("请完善您的必填信息");
        }
        else{
            var flag=$(".login_button").attr('value');
            var phone = $("input[name='family_phone']").val();
            var password = $("input[name='family_password']").val();
            //这里做与后台做交互
            $.ajax({
                url: '/userLogin/register',
                type: 'POST',
                data: {phone : phone , password : password,flag : flag},
            });
            .success(function(data) {
                console.log(data);
                alert("登录成功");
                //顶部显示"个人信息"可以跳转至个人信息页面
                $("#login_before").hide();
                $("#login_later").show();
                //window.location.href="information.html";
            });
        }
    }
}
//点击切换选框
function login_middle_right_search(){
    $(".login_title_search").css({"background-color":"#b02505","color":"#fff"});
    $(".login_title_vol").css({"background-color":"#fff","color":"#000"});
    $(".login_button").attr('value', '0');

}
function login_middle_right_vol(){
    $(".login_title_vol").css({"background-color":"#b02505","color":"#fff"});
    $(".login_title_search").css({"background-color":"#fff","color":"#000"});
    $(".login_button").attr('value', '1');
}
