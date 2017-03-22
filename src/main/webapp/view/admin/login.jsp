<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin</title>
    <script src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" />
    <link href="<%=request.getContextPath()%>/static/css/admin/login.css" rel="stylesheet">
</head>
<body>
<s:if test="#request.errorMessage!=null">
    <div class="alert alert-danger text-center" style="width: 50%;position: absolute;left: 25%;top: 50px">
        <a class="close" data-dismiss="alert">&times;</a>
        <strong>登录失败:</strong>${errorMessage}
    </div>
</s:if>
<div id="loginForm">
    <h2 class="text-center">管理员登录</h2>
    <form class="form-horizontal" method="post" action="login">
        <div class="form-group">
            <div class="col-sm-8 input-group">
            <span class="input-group-addon">
                <img src="<%=request.getContextPath()%>/static/img/user.png" class="image">
            </span>
                <input type="text" class="form-control" id="inputUsername" name="adminUser.username" placeholder="Username" value="${user}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-8 input-group">
            <span class="input-group-addon">
                <img src="<%=request.getContextPath()%>/static/img/password.png" class="image">
            </span>
                <input type="password" class="form-control" id="inputPassword" name="adminUser.password" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-4 col-sm-4">
                <button type="button" class="btn btn-default" onclick="window.location.href='/chatter'">回主页面</button>
                <button type="submit" class="btn btn-success">登录</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
