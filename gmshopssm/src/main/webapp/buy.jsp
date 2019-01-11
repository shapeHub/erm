<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE	html PUBLIC	"-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html	xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>贵美商城-商品购买页</title>
 <link rel="stylesheet"	type="text/css"	href="${pageContext.request.contextPath}/css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="${pageContext.request.contextPath}/css/layout.css"	/>
 <script type="text/JavaScript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>

 <script type="text/JavaScript" defer="true">
 	
 	/* 点击提交订单方法 */
 	function buyfrom() {
 		var buyform = document.getElementById("buyForm");
 		var order_address =document.getElementById("order_address").value;
 		var order_phone =document.getElementById("order_phone").value;
 	 	buyform.action = "${pageContext.request.contextPath}/buyshop/pay?address="+order_address+"&phone="+order_phone;
 	 	buyfrom.submit();
	}
 	
 	/* 选地址的方法，只能在ie运行 */
	function openWindow(){
		console.info("进入openwindow方法");
   		var address=window.showModalDialog("address.jsp","","dialogWidth=340px;dialogHeight=270px");
	 	
   		document.getElementById("address").value=address;	
	}
 	
    function priceCalc(oThis){
	  	//var oTr=document.getElementById("priceTable");
	  		
	  	var ids = oThis.parentNode.parentNode.getAttribute("proids");
	  	var number = oThis.value;
	  	//window.location.href = "${pageContext.request.contextPath}/buyshop/changeNumber?id="+ids+"&number="+number;
	  	//console.info("---------////---------------"+s1+" "+number);
	  	
	  	var url = "${pageContext.request.contextPath}/buyshop/changeNumber?id="+ids+"&number="+number;
		$.post(url,null,function(data){
			$("[id=sum]").text(data.beforeDiscount-data.afterDiscount);
			$("[id=youhui]").text(data.afterDiscount);
		},"json");
	  	
  	}
    
  	function remove(oThis){
  		var s1 = oThis.getAttribute("proid");
  		var url = "${pageContext.request.contextPath}/buyshop/deleteOneShop?id="+s1;
  		
		$.post(url,null,function(data){
			console.info(data.beforeDiscount+"_____"+data.afterDiscount);
			$("[id=sum]").text(data.before-data.after);
			$("[id=youhui]").text(data.after);
		},"json");
  		
  		
  		oFather = oThis.parentNode;
  		oFather.parentNode.parentNode.removeChild(oFather.parentNode);
  		
  		
  		
  		
  		//priceCalc(); 
	}
//	window.onload=priceCalc();
</script>
</head>
<body>
<div id="container">
	<iframe id="header" src="${pageContext.request.contextPath}/index/header" width="980" height="136" frameborder="0" scrolling="no"></iframe>
    	<div class="buy">
			<h4><img src="${pageContext.request.contextPath}/images/mycart.gif" alt="alt" /> <a href="#">全场运费一律2元</a> <a href="#" class="b" onclick="JavaScript:window.open('${pageContext.request.contextPath}/calc.jsp','计算器','width=200,height=200,toolbar=no,scrollbars=no,menubar=no,screenX=100,screenY=100')">简易计算器</a></h4>
      	<table class="buy" cellpadding="0" cellspacing="0">
    	<tbody id="priceTable">
			<tr class="buytitle"><td colspan="6" class="b">确认商品价格与交易条件</td></tr>
      		<tr>
		        <td class="w364 b">&nbsp;&nbsp;&nbsp;&nbsp;商品名</td>
		        <td class="w100 b">原价</td>
		        <td class="w100 b">优惠价</td>
		        <td class="w100 b">打折</td>
		        <td class="w100 b">数量</td>
		        <td class="w81 b">删除</td>
     	 	</tr>
		      
		    <c:forEach begin="0" items="${cars }" var="car" varStatus="proids" >
		      	 <tr class="h26 blue"  proids="${car.key }" >
			       <td><a href="${pageContext.request.contextPath}/index/showinfo?id=${car.value.productId}" title="攀高搓捶背靠垫按摩器（蓝色 ）（定制）">&nbsp;&nbsp;&nbsp;&nbsp;${car.value.shopName} </a></td>
			        <td><span class="c9">￥${car.value.price }</span></td>
			        <td><span class="red">￥${car.value.price*car.value.discount*0.1 }</span></td>
			        <td><span class="black">${car.value.discount} 折</span></td> 
			        <td><input onchange="priceCalc(this)" type="text" value="${car.value.number}" maxlength="4" size="3"/></td>
			        <td><a proid="${car.key }" href="JavaScript:void(0)" onclick="remove(this)">删除</a></td>
		    	 </tr>
		     </c:forEach>
		      
      
     
     
      <tr class="h26">
        <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index/catlist?currentPage=1&pageSize=8">继续挑选商品</a></td>
        <td class="a_c" colspan="2"  class="pl58">总共：￥<luoyi id="sum">${beforeDiscount-afterDiscount }</luoyi></td>
        <td colspan="3" >你共节省：￥<luoyi id="youhui">${afterDiscount }</luoyi></td>
      </tr>
    </tbody>
  	</table>
    <form id="buyForm" method="post" action="">
    <table class="buy">    
    <tbody>    
      <tr class="buytitle">
        <td colspan="2" >补充您的邮件地址和联系人基本信息</td>
      </tr>
      <tr>
				<td class="a_r"><label for="username">收件人：</label></td>
        <td><input type="text" name="username" id="username" />
			</tr>
      <tr>
				<td class="a_r"><label for="address">地&nbsp;&nbsp;&nbsp;址： </label></td>
        <td id="selectPlace">
        	<input id="order_address" type="text" name="address" id="address" />
        	<a href="javascript:openWindow()" class="b">请点击填写地址</a>
  			</td>
      </tr>      
      <tr>
		<td class="a_r"><label for="tel">电&nbsp;&nbsp;&nbsp;话：</label></td>
        <td><input class="w30" type="text" name="code"  size="4" id="tel" />-<input id="order_phone" class="w81" type="text" name="telnumber" size="8" />-<input class="w30" type="text" name="branchnumber" size="4" /><span class="red b"></span>（区号-电话号码-分机）</td>
      </tr>
      <tr>
        <td class="h65">&nbsp;</td>
        <td><input class="imginput" type="image" src="${pageContext.request.contextPath}/images/submit.gif" onclick="buyfrom()" /></td>
      </tr>
      </tbody>
  </table>
  </form>    		
		<iframe id="footer" src="${pageContext.request.contextPath}/footer.jsp" width="980" height="150" frameborder="0" scrolling="no"></iframe>
	</div><!--container	end-->
	
	
</body>
</html>