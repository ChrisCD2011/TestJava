<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016-02-18
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<s:form action="login">
  <s:textfield name="userName" key="用户名"/>
  <s:textfield name="passWord" key="密码"/>
  <s:submit key="login"/>
</s:form>
</body>
</html>
