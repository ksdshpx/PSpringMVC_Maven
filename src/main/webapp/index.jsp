<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	String path = request.getRequestURI();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<base href="<%=basePath%>">
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			$.ajax({
				url : "springmvc/myajax.do",
				data : {
					"name" : "zhangSan",
					"age" : 25
				},
				type : "POST",
				dataType : "json",
				success : function(resp) {
					alert(resp.name + ":" + resp.age);
				}
			});
		});
		$("#btn2").click(function() {
			$.ajax({
				url : "springmvc/myajaxbyfastjson.do",
				data : {
					"name" : "liSi",
					"age" : 30
				},
				type : "POST",
				dataType : "json",
				success : function(resp) {
					alert(resp.name + ":" + resp.age);
				}
			});
		});
		$("#btn3").click(function() {
			$.ajax({
				url : "springmvc/myajaxreturnstring.do",
				data : {
					"name" : "李四",
					"age" : 30
				},
				type : "POST",
				success : function(resp) {
					alert(resp);
				}
			});
		});
		$("#btn4").click(function() {
			$.ajax({
				url : "springmvc/myajaxreturnstu.do",
				type : "POST",
				success : function(resp) {
					alert(resp.name + ":" + resp.age);
				}
			});
		});
		$("#btn5").click(function() {
			$.ajax({
				url : "springmvc/myajaxreturnlist.do",
				type : "POST",
				dataType : "json",
				success : function(resp) {
					$.each(resp,function(i,n){
						alert(n.name+":"+n.age)
					});
				}
			});
		});
	});
</script>
<title>index.jsp</title>
</head>
<body>
	<a href="some.do">发起some.do的请求</a>
	<br />
	<a href="springmvc/myhello">发起myhello的请求</a>
	<br />
	<!-- <img alt="图片不能加载" src="images/ppp.png"/> -->
	<form action="springmvc/testReceiveParam" method="post">
		name:<input type="text" name="rname" /><br /> age:<input type="text"
			name="rage" /><br /> <input type="submit" value="Submit" />
	</form>
	<br />
	<form action="springmvc/testRequestParamByObject" method="post">
		name:<input type="text" name="name" /><br /> age:<input type="text"
			name="age" /><br /> <input type="submit"
			value="TestRequestParamByObject" />
	</form>
	<br />
	<button id="btn">发起Ajax请求</button>
	<br />
	<button id="btn2">发起Ajax2请求</button>
	<br />
	<button id="btn3">发起Ajax3请求(返回String数据)</button>
	<br />
	<button id="btn4">发起Ajax4请求(返回自定义对象数据)</button>
	<br />
	<button id="btn5">发起Ajax5请求(返回List数据)</button>
	<br />
	<a href="springmvc/testPathVariable/delete/1">Test PathVariable</a>
</body>
</html>