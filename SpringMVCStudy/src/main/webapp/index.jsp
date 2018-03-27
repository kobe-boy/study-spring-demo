<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>

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