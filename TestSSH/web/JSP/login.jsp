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
<script language="JavaScript">
function regist(){
  var targetForm = document.forms[0];
  targetForm.action = "regist";
}
function login(){
  var targetForm = document.forms[0];
  targetForm.action = "login";
}
</script>
<s:form>
  <s:textfield name="userName" key="用户名"/>
  <s:textfield name="passWord" key="密码"/>
  <input type="submit" value="登录" onclick="login()">
  <input type="submit" value="注册" onclick="regist()">
</s:form>
</body>
</html>
