﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE	html PUBLIC	"-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录成功 贵美商城</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layout.css" />
	<script type="text/javascript">
		function jumpIndex(){
			window.location.href = "${pageContext.request.contextPath}/login.jsp";
		}
		window.setTimeout("jumpIndex()", 3000);
</script>
</head>
<body>
	<div id="container">
		<iframe src="${pageContext.request.contextPath}/index/header" width="980" height="136" frameborder="0"
			scrolling="no"></iframe>
		<p class="a_c lh24">
			<img src="../images/logo.jpg" alt="alt" /><br /> 抱歉账号密码错误 !!! <br />
			3秒后返回<br /> 登录页面
		</p>

		<iframe src="${pageContext.request.contextPath}/footer.jsp" width="980" height="150" frameborder="0"
			scrolling="no"></iframe>
	</div>
	<!--container	end-->
</body>
</html>
