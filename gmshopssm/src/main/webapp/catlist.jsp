<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE	html PUBLIC	"-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html	xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>贵美商城</title>
 <link rel="stylesheet"	type="text/css"	href="${pageContext.request.contextPath}/css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="${pageContext.request.contextPath}/css/layout.css"	/>
 <script type="text/JavaScript">
 	function multiCheck(oThis){
 		var oInput=document.getElementsByTagName("input");
 		for (var i=1;i<oInput.length;i++){ 	
 				oInput[i].checked=oThis.checked;}
 	}
 </script>
 
</head>
<body>
<div id="container">
	<iframe id="header" runat="server" src="${pageContext.request.contextPath}/index/header" width="980" height="136" frameborder="0" scrolling="no"></iframe>
	
	<div class="catlist a_c">
		<ul class="w20p check">
			<h3><input type="checkbox" name="checkall" onclick="multiCheck(this)" />全选</h3>
		</ul>
		<ul class="w20p">
			<h3>商品图片</h3>
		</ul>
		<ul class="w50p info">
			<h3>商品名称/出售者/联系方式</h3>
		</ul>
		<ul class="w10p price">
			<h3>价格</h3>
			
		</ul>
	
		<c:forEach items="${pages.lists }" var="p">
			<ul class="w20p check">
				<li><input type="checkbox" /></li>
			</ul>
			<ul class="w20p">
				<li><a href="${pageContext.request.contextPath}/index/showinfo?id=${p.id } "><img  width=90 height=90 src="${pageContext.request.contextPath}/upload/${p.image }" alt="" /></a></li>
			</ul>
			<ul class="w50p info">
				<li><a href="${pageContext.request.contextPath}/index/showinfo?id=${p.id } ">${p.name }</a><br />出售者：<a href="#">ling112233<br /><a href="#"><img src="${pageContext.request.contextPath}/images/contactme.gif" alt="alt" /> <img src="${pageContext.request.contextPath}/images/addfav.gif" alt="收藏" />收藏</a></li>
			</ul>
			<ul class="w10p price">
				<li>一口价：<br />${p.price }</li>	
			</ul>
		</c:forEach>
		
		
		<script type="text/JavaScript">
			
			
		
		</script>
		
		<div>
		   <div id="body-bottom" style="margin-top: 40px;" >
            <div name="anniu"><a href="${pageContext.request.contextPath}/index/${controllerName }currentPage=1&pageSize=4">首页</a></div>
            <div name="anniu"><a href="${pageContext.request.contextPath}/index/${controllerName }currentPage=${pages.currentPage-1 }&pageSize=4">上一页</a></div>
            <div name="anniu"><a href="${pageContext.request.contextPath}/index/${controllerName }currentPage=${pages.currentPage+1 }&pageSize=4">下一页</a></div>
            <div name="anniu"><a href="${pageContext.request.contextPath}/index/${controllerName }currentPage=${pages.totalPage }&pageSize=4">尾页</a></div>
			总记录数:${ pages.count} </br>
			页数/总页数:${pages.currentPage }/${pages.totalPage }
        </div>
	
	</div>
	<iframe id="footer"  src="${pageContext.request.contextPath}/footer.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
</div> <!--container end-->	
</body>
<style>
    div[name="biaoti"]{
        color: black;
        float: left;
        width: 19%;
        height: 25px;
        border: 1px solid black;
        line-height: 25px;
        text-align: center;
    }
    div[name="anniu"]{
        color: black;
        float: left;
        width: 20%;
        margin-left: 15px;
        height: 25px;
        border: 1px solid black;
        line-height: 25px;
        text-align: center;
    }
</style>

</html>
