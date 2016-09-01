<%--
 Copyright (C) 2001-2016 wxyz <hyhjwzx@126.com>
 
 This program can be distributed under the terms of the GNU GPL Version 2.
 See the file LICENSE.
--%>
<%--
  User: wxyz
  Time: 2016-08-23_20:40
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="/WEB-INF/view/include/taglibs.jsp" %>
    <%@ include file="/WEB-INF/view/include/meta.jsp" %>
    <%@ include file="/WEB-INF/view/include/style.jsp" %>
    <title>登录到后台</title>
</head>
<body>

    <div id="container">
        <form id="login" action="${ctx}/user/login" method="post">
            <label>账号</label>
            <input type="text" name="username" placeholder="username">
            <br>
            <label>密码</label>
            <input type="password" name="password">
            <br>
            <input type="checkbox" name="remember" value="记住我一个月">
            <br>
            <button type="submit">登陆</button>
        </form>
    </div>

<%@ include file="/WEB-INF/view/include/script.jsp" %>
</body>
</html>
