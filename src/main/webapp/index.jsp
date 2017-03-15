<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome to chatter's world!</title>
    <script src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/simple/index.css" />
    <script src="<%=request.getContextPath()%>/static/js/simple/getMainWindow.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/simple/userIndex.js"></script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index">Chatter</a>
        </div>
        <s:if test="#session.account==null">
            <ul class="nav navbar-nav navbar-right">
                <li id="li1"><a href="registerPage?requestUrl=index"> 注册</a></li>
                <li id="li2"><a href="loginPage?requestUrl=index"> 登录</a></li>
                <li><a href="admin/loginPage"> 管理员登录</a></li>
            </ul>
        </s:if>
        <s:else>
            <ul class="nav navbar-nav navbar-right">
                <li id="li3"><a id="account">${account}</a></li>
                <li id="li4"><a href="logout">退出</a></li>
            </ul>
        </s:else>
        <form class="navbar-form navbar-right">
            <div class="form-group">
                <input id="index-search-key" type="text" class="form-control" placeholder="Search">
            </div>
            <button id="index-search-button" type="button" class="btn btn-default">搜索</button>
        </form>
    </div>
</nav>
<div id="mainWindow"></div>
</body>
</html>
