<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function first()
	{
		
		if(window.confirm('你确定要退出登录吗？')){
			
			window.parent.location.href='${pageContext.request.contextPath }/userController/exit';
		
            return true;
         }else{
            //alert("取消");
            return false;
        }
		
	}
		
</script>
<body >
	<a href="${pageContext.request.contextPath }/user/wellcome.jsp" target="right" >个人信息</a>
	<hr/>
	<a href="${pageContext.request.contextPath }/user/dingdan.jsp" target="right" >订单信息</a>
	<hr/>
	<a  onclick="first()" target="right" >退出登录</a>
	<hr/>
</body>
</html>