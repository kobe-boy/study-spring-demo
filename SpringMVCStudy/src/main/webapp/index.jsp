<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
<h3>数据格式化 测试</h3>
<h4>测试日期类型,货币类型是否能正确转换</h4>
   <form action="data/get" method="post">
		username:<input type="text" name="username" ><br>
		birthday:<input type="text" name="birthday">格式yyyy-MM-dd<br>
		salary:<input type="text" name="salary">格式#,###,###.#s<br>
		<input type="submit" value="Submit">
	</form>
<h3>=====================================</h3>
<h3>测试接收对象类型参数</h3>
<h4>并返回json数据</h4>
<br><br>
	<form action="hello/user" method="post">
		username:<input type="text" name="username" ><br>
		password:<input type="text" name="password"><br>
		email:<input type="text" name="email"><br>
		age:<input type="text" name="age"><br>
		<input type="submit" value="Submit">
	</form>
<br><br>
<h3>=====================================</h3>
<h3>rest 风格</h3>
<br><br>
	<form action="rest/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="PUT Test">
	</form>
<br><br>
	<form action="rest/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="DELETE Test">
	</form>
<br><br>
	<form action="rest/testRest" method="post">
		<input type="submit" value="POST Test">
	</form>
<br><br>
	<a href="rest/testRest/1">Get Test</a>
</body>
</html>