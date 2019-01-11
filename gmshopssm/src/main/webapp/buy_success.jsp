<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
		function jumpIndex(){
			window.location.href = "${pageContext.request.contextPath}/index";
		}
		window.setTimeout("jumpIndex()", 3000);
</script>
<body>
	下单成功，请注意查收！！！！！
	
</body>
</html>