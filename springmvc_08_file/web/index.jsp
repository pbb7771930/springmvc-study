<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2020/2/15
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
https://blog.kuangstudy.com/index.php/archives/486/
<br>

<form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="upload">
</form>

</body>
</html>
