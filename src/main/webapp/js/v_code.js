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
            //这里做与后台做交互
            alert("登录成功");
            window.location.href="#";
        }
    }
}
