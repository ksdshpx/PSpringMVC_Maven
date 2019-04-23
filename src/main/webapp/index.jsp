<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<a href="some.do">发起some.do的请求</a><br/>
	<a href="springmvc/myhello">发起myhello的请求</a><br/>
	<!-- <img alt="图片不能加载" src="images/ppp.png"/> -->
	<form action="springmvc/testReceiveParam" method="post">
		name:<input type="text" name="name"/><br/>
		age:<input type="text" name="age"/><br/>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>