<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"	type="text/css"	href="${pageContext.request.contextPath}/css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="${pageContext.request.contextPath}/css/layout.css"	/>
</head>
	<div id="container" style="width:500px;height: 400px;">
	<frameset rows="25%,*" style="background: red;" >
		<frame src="${pageContext.request.contextPath }/index/header" name="top"/>
		<frameset cols="10%,*">
			<frame src="${pageContext.request.contextPath }/user/left.jsp" name="left"/>
			<frame src="${pageContext.request.contextPath }/user/wellcome.jsp" name="right"/>
		</frameset>
		<%-- <frame src="${pageContext.request.contextPath }/footer.jsp" name="buttom"/> --%>
	</frameset>
	
	</div>
</html>