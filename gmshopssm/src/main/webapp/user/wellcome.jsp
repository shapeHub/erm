<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="width: 100%;height: 500px;background: yellow;">
			<div style="background: pink;width: 500px;height: 100%;border: 1px solid black;">
				
				<div style="width: 120px;height: 120px;background: green;margin-left: 60px;"><img alt="图片" src="${pageContext.request.contextPath}/userImage/${conditionUser.userImg}" width="119" height="119"></div>
				<div style="padding-top: 30px;">
					<div style="float: left;width: 10%;height: 30px; background: pink;line-height: 30px;">姓	名:</div>
					<div style="float: left;width: 90%;height: 30px; background: pink;line-height: 30px;">${conditionUser.myName }</div>
				</div>
				<div>
					<div style="float: left;width: 10%;height: 25px; background: pink;line-height: 30px;">性	别:</div>
					<div style="float: left;width: 90%;height: 25px; background: pink;line-height: 30px;">${conditionUser.sex }</div>
				</div>
				<div>
					<div style="float: left;width: 10%;height: 25px; background: pink;line-height: 30px;">生	日:</div>
					<div style="float: left;width: 90%;height: 25px; background: pink;line-height: 30px;">${conditionUser.bornDay}</div>
				</div>
				<div>
					<div style="float: left;width: 10%;height: 25px; background: pink;line-height: 30px;">email:</div>
					<div style="float: left;width: 90%;height: 25px; background: pink;line-height: 30px;">${conditionUser.email}</div>
				</div>
			</div>
		
		
		</div>
</body>
</html>