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
文件上传功能
    <br>
    <%--  multipart/form-data：指定传输数据为二进制类型  --%>
    <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
        <input type="file" name="file"/>
        <input type="submit" value="上传">
    </form>
    <br>
    <%--  直接下载文件  --%>
    <a href="${pageContext.request.contextPath}/statics/1.png">下载文件</a>
    <br>
    <a href="${pageContext.request.contextPath}/download">下载文件2</a>


</body>
</html>
