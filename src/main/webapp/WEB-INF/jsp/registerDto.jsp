<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/12
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/registerDto">
    用户名<input type="text" name="username"><span style="color: red">${erroe.username}</span>
    密码<input type="text" name="password"><span style="color: red">${erroe.password}</span>
    email<input type="text" name="email"><span style="color: red">${erroe.email}</span>
   文件上传 <input type="file" name="file">
     <input type="submit" 提交>
</form>
</body>
</html>
