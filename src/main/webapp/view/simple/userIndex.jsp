<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome to chatter's world!</title>
    <script src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/simple/index.css" />
    <script src="<%=request.getContextPath()%>/static/js/simple/userIndex.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/simple/getMainWindow.js"></script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="userIndex">Chatter</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li id="li1"><a>${account}</a></li>
            <li id="li2"><a href="logout">退出</a></li>
        </ul>
        <form class="navbar-form navbar-right">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">搜索</button>
        </form>
    </div>
</nav>
<div id="mainWindow"></div>
</body>
</html>
