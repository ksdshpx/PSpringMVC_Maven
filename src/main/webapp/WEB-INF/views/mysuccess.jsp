<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success.jsp</title>
</head>
<body>
	<h1>MySuccess</h1>
	name:${name }<br/>
	age:${age }<br/>
	request student:${requestScope.student }<br/>
	session student:${sessionScope.student }<br/>
	<fmt:message key="i18n.username"></fmt:message><br/>
	<fmt:message key="i18n.password"></fmt:message>
</body>
</html>