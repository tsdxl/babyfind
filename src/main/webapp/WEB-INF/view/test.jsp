<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/user/getUserInfo"	method="post">
		<label>账号：</label> 
		<input type="text" id="name" name="name"/><br /> 
		<input type="submit" value="提交" /> <input type="reset" value="重置" />
	</form>
</body>
</html>