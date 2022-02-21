<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2020/2/14
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>

<script>
    function a() {
        $.post({
          url:"${pageContext.request.contextPath}/a1",
          data:{"name":$("#username").val()},
          success:function(data){
            alert(data)
          }
        })
    }
</script>

<body>
<!--失去焦点-->
用户名：<input type="text" id="username" onblur="a()">
</body>
</html>
