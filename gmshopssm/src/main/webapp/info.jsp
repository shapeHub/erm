<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE	html PUBLIC	"-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html	xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>贵美商城-商品分类页</title>
 <link rel="stylesheet"	type="text/css"	href="${pageContext.request.contextPath}/css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="${pageContext.request.contextPath}/css/layout.css"	/>
 <script type="text/JavaScript" defer="true">
	//var oImg=document.getElementById("show").getElementsByTagName("img");
	/* for(var i=1;i<=(oImg.length-3);i++){
		oImg[i].onmouseover=function(){oImg[0].src=this.src.replace('.jpg','_big.jpg');
			this.style.border='2px #ff7300 solid';}
		oImg[i].onmouseout=function(){this.style.border='2px #ccc solid';}
 	} */
 </script>
</head>
<body>
<div id="container">
	<iframe id="header" src="${pageContext.request.contextPath}/index/header" width="980" height="136" frameborder="0" scrolling="no"></iframe>
	<div class="good">
		<h1>${productinfo.name }</h1>
		<ul class="f_l" id="show">
			<li class="bigimg"><a href="${pageContext.request.contextPath}/upload/${productinfo.image}"><img width=380 height=300 src="${pageContext.request.contextPath}/upload/${productinfo.image}" alt="笔记本大图" /></a></li>
			<c:forEach begin="0"    items="${productinfo.images}" var="p" end="5">
				<li class="smallimg"><img width=50 height=50 src="${pageContext.request.contextPath}/upload/${p.url}" alt="小图" /></li>
			</c:forEach>
		
			
			<!-- <li class="smallimg"><img src="images/show1.jpg" alt="小图1" /></li>
			<li class="smallimg"><img src="images/show2.jpg" alt="小图2" /></li>
			<li class="smallimg"><img src="images/show3.jpg" alt="小图3" /></li>
			<li class="smallimg"><img src="images/show4.jpg" alt="小图4" /></li>
			<li class="smallimg"><img src="images/show5.jpg" alt="小图5" /></li>			 -->
			<li class="op clear f_l"><a href="#"><img src="${pageContext.request.contextPath}/images/share.gif" alt="分享" /></a></li>
			<li class="op f_l"><a href="#"><img src="${pageContext.request.contextPath}/images/favthis.gif" alt="藏" /></a></li>			
		</ul>
		<ul class="goodinfo f_l" >
			<li>一 口 价：<span>${productinfo.price}元 </span></li>
			<li>运　　费：<span>${productinfo.freight}</span></li>
			<li class="h74 buynow"><a href="${pageContext.request.contextPath}/buyshop/addToCar?id=${productinfo.id}"><img src="${pageContext.request.contextPath}/images/buynow.gif" alt="alt" /></a></li>
			<li class="onlinepay">此商品支持<a href="#">网银支付</a>，网上汇款免手续费。<br />收货满意后出售者才能拿钱，货款都安全！</li>
			<li>剩余时间：<span> ${productinfo.deadline}</span></li>
			<li>累计售出：<span>${productinfo.sellNum }件</span></li>
			<li class="f_l w175">商品类型：<span>${productinfo.category.name }</span></li>
			<li>所 在 地：<span>${productinfo.sellAddress }</span></li>
			<li class="f_l w175">商品库存：<span>${productinfo.stockNum}</span></li>
			<li>浏 览 量：<span>${productinfo.viewNum}次</span></li>			
		</ul>
	</div>
	<iframe id="footer" src="${pageContext.request.contextPath}/footer.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>

</div> <!--container end-->	




</body>
</html>
