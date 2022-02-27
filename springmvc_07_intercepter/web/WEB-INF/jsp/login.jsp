<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2020/2/15
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登陆页面</h1>

<form action="${pageContext.request.contextPath}/user/login" method="get">
    用户名：<input type="text" name="username">
    <br>
    密码:<input type="password" name="password">
    <input type="submit" value="提交">
</form>

</body>
</html>
