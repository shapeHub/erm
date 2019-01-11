<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
</head>
<body>
<jsp:forward page="/index"></jsp:forward>


<c:forEach items="${pages.lists }" var="p">
			<ul class="w20p check">
				<li><input type="checkbox" /></li>
			</ul>
			<ul class="w20p">
				<li><a href="${pageContext.request.contextPath}/info.jsp"><img  width=90 height=90 src="${pageContext.request.contextPath}/upload/${p.image }" alt="" /></a></li>
			</ul>
			<ul class="w50p info">
				<li><a href="${pageContext.request.contextPath}/index/showinfo?id=${p.id } ">${p.name }</a><br />出售者：<a href="#">ling112233<br /><a href="#"><img src="${pageContext.request.contextPath}/images/contactme.gif" alt="alt" /> <img src="${pageContext.request.contextPath}/images/addfav.gif" alt="收藏" />收藏</a></li>
			</ul>
			<ul class="w10p price">
				<li>一口价：<br />${p.price }</li>	
			</ul>
		</c:forEach>
</body>
</html>