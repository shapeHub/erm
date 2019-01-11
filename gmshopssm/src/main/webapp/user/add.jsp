<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.form.js"></script>
<script type="text/javascript">
	$(function(){
		$("#form1").ajaxForm({
			url:"${pageContext.request.contextPath }/user/ajaxadd",
			type:"post",
			success:function(data){
				alert(data);
				if(data.cause=='NO_LOGIN'){
					alert(data.msg);
					window.top.location.href="${pageContext.request.contextPath }/security/tologin";
				}
				alert(data.msg);
			},
		});
		
	});
</script>
</head>
<body>
	<h1>显示ajax提交</h1>
	<form id="form1">
		用户名：<input type="text" value="" name="userName"/><br/>
		真   名：<input type="text" value="" name="realname"/><br/>
		密   码：<input type="password" value="" name="password"/><br/>
		<input type="submit" value="提交" />
		
	</form>

	<h1>显示普通表单提交</h1>
	<form action="${pageContext.request.contextPath }/user/add" method="get">
		用户名：<input type="text" value="" name="userName"/><br/>
		真   名：<input type="text" value="" name="realname"/><br/>
		密   码：<input type="password" value="" name="password"/><br/>
		<input type="submit" value="提交" />
		
	</form>
	
</body>
</html>