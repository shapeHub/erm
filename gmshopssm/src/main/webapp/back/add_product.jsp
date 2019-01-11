
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
</head>
<body>

	<form  id="product" method="post"  action="${pageContext.request.contextPath}/productController/addProduct" enctype="multipart/form-data">
		名称:<input type="text" name="name" /> <br />
		<!--  价格:<input type="text" name="price" /> <br />
		 运费:<input type="text" name="freight" /> <br /> 
		 失效时间:<input type="text" name="expireTime" /> yyyy/MM/dd格式 <br />
		 库存:<input type="text" name="stockNum" /> <br /> 
		 所在地:<input type="text" name="sellAddress" /> <br /> 
		商品类型: <select name="categoryId" >
				<option value ="家用电器111">家用电器111</option>
				<option value ="书籍444">书籍444</option>
				<option value="户外休闲">户外休闲</option>
				<option value="管理学手机数码333">管理学手机数码333</option>
		</select>
		<br/>
		 商品主图片:<input type="file" name="images" /> <br/>
		商品副图片1:<input type="file" name="images" /> <br/>
		商品副图片2:<input type="file" name="images" /> <br/>
		商品副图片3:<input type="file" name="images" /> <br/>
		商品副图片4:<input type="file" name="images" /> <br />  -->
		<input  type="submit" ></input>
		<input type="reset"></input>
	</form>
</body>
</html>