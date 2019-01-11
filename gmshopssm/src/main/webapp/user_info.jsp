<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE	html PUBLIC	"-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html	xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"	/>
 <title>注册成功 贵美商城</title>
<link rel="stylesheet"	type="text/css"	href="${pageContext.request.contextPath}/css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="${pageContext.request.contextPath}/css/layout.css"	/>

</head>
</body>
	<%--  <frameset rows="25%,*">
		<iframe src="${pageContext.request.contextPath}/index/header" width="980" height="136" frameborder="0" scrolling="no" name="top"></iframe>
		<frameset cols="10%,*">
			<iframe  src="${pageContext.request.contextPath }/user/left.jsp" name="left"></iframe>
			<iframe src="${pageContext.request.contextPath }/user/wellcome.jsp" name="right"></iframe>
		</frameset>
		
	</frameset> --%>
	<div id="container">
	 <iframe src="${pageContext.request.contextPath}/index/header" width="980" height="136" frameborder="0" scrolling="no" name="top"></iframe>	
	<div style="width: 100%;height: 400px;">
		<div style="width: 20%;height: 100%;float: left;background: pink">
			<iframe src="${pageContext.request.contextPath }/user/left.jsp" name="left" width="100%" height="100%"></iframe>
		</div>
		<div style="width: 80%;height: 100%;float: left;">
			<iframe src="${pageContext.request.contextPath }/user/wellcome.jsp" name="right" width="100%" height="100%"></iframe>
		</div>
		
	</div>
	<iframe id="footer" src="${pageContext.request.contextPath}/footer.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
	</div>
</body>
</html>		

