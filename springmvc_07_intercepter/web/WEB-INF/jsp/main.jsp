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
<h1>首页</h1>
<span>
    ${username}
    <br>
    <a href="${pageContext.request.contextPath}/user/goOut">注销</a>
</span>
</body>
</html>
