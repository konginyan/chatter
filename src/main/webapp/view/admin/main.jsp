<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Manager</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-pagination.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/admin/main.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap-pagination.min.css">
    <script src="<%=request.getContextPath()%>/static/js/admin/main.js"></script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">Chatter Manager System</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/chatter">回主页面</a></li>
            <li id="li1"><a>${username}</a></li>
            <li id="li2"><a href="loginPage">退出</a></li>
        </ul>
    </div>
</nav>
<div>
    <div id="left" class="col-md-2">
        <dl>
            <dt id="dt1">系统管理</dt>
            <dt id="dt2">用户管理</dt>
            <dt id="dt3">资源管理</dt>
        </dl>
    </div>
    <div class="col-md-10">
        <div id="right"></div>
    </div>
</div>
</body>
</html>
