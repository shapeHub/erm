
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE	html PUBLIC	"-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html	xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"	/>
 <title>贵美商城</title>
 <link rel="stylesheet"	type="text/css"	href="${pageContext.request.contextPath}/css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="${pageContext.request.contextPath}/css/layout.css"	/>
 	<script type="text/JavaScript">
	var strHome = 'http://www.gmgw.com';
	function addFav(){
		switch(getNav()){
			case 1:
			  window.external.addFavorite(strHome,'贵美商城');
			  break;
			case 2:
			  window.sidebar.addPanel('贵美商城',strHome,'');
			  break;
			case 0:
			  alert("加入收藏失败");
			  break;
		}		
		function getNav(){
			if(navigator.userAgent.indexOf("MSIE")!=-1)    return 1;
			if(navigator.userAgent.indexOf("Firefox")!=-1) return 2;
			return 0;
			}
	}
	function setHome(oThis){
		oThis.style.behavior='url(#default#homepage)';
		oThis.setHomePage(strHome);
		return false;
	} 	
	function showTime(){
		now=new Date;
		document.write(now.getFullYear()+"年"+(now.getMonth()+1)+"月"+now.getDate()+"日"+now.getHours()+"点"+now.getMinutes()+"分");	
	}

	</script>
	
	<script language="javascript" type="text/javascript">
	with(window){
		function sousuo(){
			var findname = document.getElementById("findname").value;
			console.info(findname);
			var form1 = document.getElementById("Myform");
			form1.method="post";
			var url = " ${pageContext.request.contextPath}/index/showByName?name="+findname+"&currentPage=1&pageSize=4";
			form1.target="_parent";
			form1.action=url;
			form1.submit();
			/* window.location.href = url; */
			
		}
	}
	

	</script>
</head>
<body>
		<div id="header">
			<div id="logo"></div>
			<div class="menu">
				<ul>
					<li class="pic pic1"></li>
					<li class="txt"><a href="${pageContext.request.contextPath}/index/showbuy" target="_parent">购物车</a></li>
					<li class="pic pic2"></li>
					<li class="txt"><a href="${pageContext.request.contextPath}/help.jsp" target="_parent">帮助中心</a></li>
					<li class="pic pic3"></li>
					<li class="txt"><a href="JavaScript:void(0);" onclick="addFav();">加入收藏</a></li>		
					<li class="pic pic4"></li>
					<li class="txt"><a href="JavaScript:void(0);" onclick="setHome(this);">设为首页</a></li>			
					<li class="pic btn txt"><a href="${pageContext.request.contextPath}/login.jsp" target="_parent">登录</a></li>
					<li class="pic btn txt"><a href="${pageContext.request.contextPath}/register.jsp" target="_parent">注册</a></li>
					
				</ul>
			</div> <!--menu	end-->
			<div class="f_r w62p">
				<ul>
					<li class="txt hello">你好，欢迎${conditionUser.myName }&nbsp;访问贵美商城！<script type="text/JavaScript">showTime();</script></li>
				</ul>
			</div> 
  		<div class="nav f_l w100p">
  			<ul>
  				<li><a href="${pageContext.request.contextPath}/index" target="_parent">&nbsp;首&nbsp;&nbsp;&nbsp;页&nbsp;</a></li>
  				
  				<c:forEach items="${allType}" var="ps"  >
  					<li><a href="${pageContext.request.contextPath}/index/secondcatlist?id=${ps.id }&currentPage=1&pageSize=4" target="_parent">${ps.name }</a></li>
  				</c:forEach>
  				<li><a href="${pageContext.request.contextPath}/help.jsp" target="_parent">帮助中心</a></li>
  				<li><a href="${pageContext.request.contextPath}/help.jsp" target="_parent">免费开店</a></li>
  				<li><a href="${pageContext.request.contextPath}/help.jsp" target="_parent">全球咨询</a></li>  	
  				<form id="Myform"  >
  					<input id = "findname" type="text" style="width: 230px; height: 25px;line-height: 25px;"/> 
					<input  type="button" style="width: 60px; height: 25px;line-height: 25px; background-image:url('${pageContext.request.contextPath}/images/sousuo.png'); " onclick="sousuo()" value=" "/> 
  				</form>
  			</ul>
  		</div>	<!--nav	end-->		
		</div> <!--header	end-->	
		
 </body>
 
</html>
