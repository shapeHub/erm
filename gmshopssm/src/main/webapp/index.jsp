<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE	html PUBLIC	"-//W3C//DTD XHTML 1.0 transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html	xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"	/>
 <title>贵美商城</title>
 <link rel="stylesheet"	type="text/css"	href="${pageContext.request.contextPath}/css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="${pageContext.request.contextPath}/css/layout.css?id=7"	/>
 <script type="text/JavaScript" src="${pageContext.request.contextPath}/js/index.js"></script>
</head>
<body> 
	<div id="container">
	<iframe id="header" src="${pageContext.request.contextPath}/index/header" width="980" height="136" frameborder="0" scrolling="no"></iframe>
	<div id="main">
    	<div class="cat">
			<c:forEach items="${products}" var="ps"  >
				<ul>
					<h1 style="line-height: 29px;">${ps.name }</h1>
					 <c:forEach items="${ps.categories }" var="p" >
						<li><a href="${pageContext.request.contextPath}/index/threeecatlist?id=${p.id }&currentPage=1&pageSize=4">${p.name }</a></li>
					</c:forEach> 
				</ul>
			</c:forEach>
    	</div> 
			<div id="content">
				<div class="content_top">
					<div>
			            <img src="${pageContext.request.contextPath}/images/ad-01.jpg" alt="9月新品新气象" id="div1" />
			            <img src="${pageContext.request.contextPath}/images/ad-02.jpg" alt="流行服饰魅力场" id="div2" />
			            <img src="${pageContext.request.contextPath}/images/ad-03.jpg" alt="食全食美" id="div3" />
			            <img src="${pageContext.request.contextPath}/images/ad-04.jpg" alt="outlets开张啦" id="div4" />
	         		 </div>
         	 	 	<div id="adv">
          				<a href="JavaScript:show(1);">1</a>&nbsp;<a class="adv" href="JavaScript:show(2);">2</a>&nbsp;<a class="adv" href="JavaScript:show(3);">3</a>&nbsp;<a class="adv" href="JavaScript:show(4);">4</a>
         		 	</div>
				</div> <!-- content_top end -->
      	<div class="content_list">
      	<c:forEach items="${showpage.lists }" var="sh">
	      	 <dl>
	        	<dt><img width="90" height="90"  src="${pageContext.request.contextPath}/upload/${sh.image }" alt="alt" /></dt>
				<dd><a href="${pageContext.request.contextPath}/index/showinfo?id=${sh.id } ">${sh.name}</a></dd>
			 </dl>
      	</c:forEach>          
			</div><!-- content_list end -->
		</div><!-- content end -->
    	<div class="sidebar">
        <div class="r1"></div>				
		<div	class="r2">
			<dl>
				<dt><img src="images/show1.jpg" alt="alt" /></dt>
				<dd><a href="${pageContext.request.contextPath}/index/showinfo?id=5 ">大牌狂降价，三折直送</a></dd>
				</dl>
				<dl>
					<dt><img src="images/show2.jpg" alt="alt" /></dt>
					<dd><a href="${pageContext.request.contextPath}/index/showinfo?id=5 ">大学要求老师开网店</a></dd>
				</dl>
				<dl>
					<dt><img src="images/show5.jpg" alt="alt" /></dt>
					<dd><a href="${pageContext.request.contextPath}/index/showinfo?id=5 ">黑眼圈推荐，美白不停</a></dd>
				</dl>
					<dl>
					<dt><img src="images/show4.jpg" alt="alt" /></dt>
					<dd><a href="${pageContext.request.contextPath}/index/showinfo?id=5 ">瘦身狂潮风，修形之选</a></dd>
				</dl>
		</div> <!--r2	end-->	    
		<div id="tab">
			<div id="tabtitle1" onmouseover="switchMe(1);"></div>
				<div id="tabtitle2" onmouseover="switchMe(2);"></div>		
				<div id="tabbody">
					<img src="${pageContext.request.contextPath}/images/tabbody2.gif" alt="手机充值" />
				</div>											  
		</div>
	</div> <!--sidebar end-->				
	</div>	<!--main end-->
    <iframe id="footer" src="${pageContext.request.contextPath}/footer.jsp" width="980" height="150" frameborder="0" scrolling="no"></iframe>
	<%-- <div id="pairflag" style="overflow: hidden;">
		<a class="f_l" href="#" id="advLeft"><img src="${pageContext.request.contextPath}/images/list1.jpg" alt="alt" /></a>
		<img class="f_l" id="closeLeft" onclick="leftClose();" src="${pageContext.request.contextPath}/images/close.gif" alt="alt" />
		<a href="#" class="f_r" id="advRight"><img src="${pageContext.request.contextPath}/images/list2.jpg" alt="alt" /></a>
		<img id="closeRight" class="f_r" onclick="rightClose();" src="${pageContext.request.contextPath}/images/close.gif" alt="alt" />
	</div> --%>
	</div>
	<!--container	end-->		
</body>
</html>
