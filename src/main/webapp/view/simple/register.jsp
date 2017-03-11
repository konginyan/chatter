<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register in Chatter</title>
    <script src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/simple/index.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/simple/login.css" />
    <script src="<%=request.getContextPath()%>/static/js/simple/register.js"></script>
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
<h2 class="text-center">注册</h2>
<form class="form-horizontal" method="post" action="register" onsubmit="return checkForm()">
    <s:token/>
    <div class="form-group" id="nameForm">
        <label for="inputUserName" class="col-sm-4 control-label">用户名/邮箱</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="inputUserName" name="simpleUser.username" placeholder="Username" required="required" onblur="checkUsername()">
        </div>
        <label id="name-label" class="help-block"></label>
    </div>
    <div class="form-group" id="passwordForm">
        <label for="inputPassword" class="col-sm-4 control-label">密码</label>
        <div class="col-sm-4">
            <input type="password" class="form-control" id="inputPassword" name="simpleUser.password" placeholder="Password" required="required">
        </div>
        <label id="password-label" class="help-block"></label>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-4 col-sm-4">
            <button type="submit" class="btn btn-default">注册</button>
        </div>
    </div>
</form>
</body>
</html>
