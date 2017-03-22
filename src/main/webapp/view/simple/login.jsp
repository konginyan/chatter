<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login in Chatter</title>
    <script src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/simple/index.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/simple/login.css" />
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index">Chatter</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li id="li1"><a href="registerPage"> 注册</a></li>
            <li id="li2"><a href="loginPage"> 登录</a></li>
            <li><a href="admin/loginPage"> 管理员登录</a></li>
        </ul>
    </div>
</nav>
<s:if test="#request.errorMessage!=null">
    <div class="alert alert-danger text-center" style="width: 50%;">
        <a class="close" data-dismiss="alert">&times;</a>
        <strong>登录失败:</strong>${errorMessage}
    </div>
</s:if>
<h2 class="text-center">登录</h2>
<form class="form-horizontal" method="post" action="login">
    <s:token/>
    <div class="form-group">
        <label for="inputUsername" class="col-sm-4 control-label">用户名/邮箱</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="inputUsername" name="simpleUser.username" placeholder="Username" value="${user}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword" class="col-sm-4 control-label">密码</label>
        <div class="col-sm-4">
            <input type="password" class="form-control" id="inputPassword" name="simpleUser.password" placeholder="Password">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-4 col-sm-4">
            <div class="checkbox">
                <label>
                    <input type="checkbox" name="autoLogin" value="autoLogin"> 自动登录
                </label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-4 col-sm-4">
            <button type="submit" class="btn btn-default">登录</button>
        </div>
    </div>
    <input type="text" name="responseUrl" value="${requestUrl}" hidden>
</form>
</body>
</html>
