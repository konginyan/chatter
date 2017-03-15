<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-pagination.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap-pagination.min.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/simple/readArticle.js"></script>
<script src="<%=request.getContextPath()%>/static/js/simple/userIndex.js"></script>
<html>
<head>
    <title>文章阅读</title>
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
<div id="mainWindow" style="margin-left: 10%;margin-right: 10%">
    <article>
        <section>
            <h1 class="text-center"><s:property value="#request.article.title"/></h1>
            <label style="color: gray" class="text-center">作者：<a href="#"><s:property value="#request.article.author"/></a>
                &nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#request.article.createTime"/></label>
            <hr/>
            <p style="font-size: 20px"><s:property value="#request.article.content" escapeHtml="false"/></p>
        </section>
        <section>
            <s:if test="#request.article.attachment!=null">
                <div>
                    <img src="<%=request.getContextPath()%>/static/img/zip.png" style="height: 15px;width: 15px">
                    <a onclick="downloadFile()"><s:property value="#request.article.attachment.fileName"/></a>
                </div>
            </s:if>
        </section>
    </article>
    <s:if test="#session.account!=null">
        <form style="margin-top: 50px">
            <div class="form-group">
                <label for="inputComment">评论</label>
                <textarea class="form-control" rows="5" id="inputComment"></textarea>
            </div>
            <div class="form-group">
                <input id='makeComment' class="btn btn-default" type="button" value="提交">
            </div>
        </form>
    </s:if>
    <s:else>
        <label style="margin-top: 50px">
            要评论，请<a href="loginPage?requestUrl=readArticle?id=<s:property value="#request.article.id"/>">登录</a>
            还没有帐号，那还不赶紧<a href="registerPage?requestUrl=readArticle?id=<s:property value="#request.article.id"/>">注册</a>
        </label>
    </s:else>
    <br/>
    <label style="margin-top: 20px"><s:property value="#request.comments.size()"/>&nbsp;评论</label>
    <hr style="margin-top: 3px"/>
    <s:iterator value="#request.comments" var="cos">
        <a><s:property value="author"/></a>
        <s:if test="#session.account == #cos.author">
            <a onclick="deleteComment('<s:property value="id"/>')" style="float: right">删除</a>
        </s:if>
        <br/>
        <p><s:property value="content" escapeHtml="false"/></p>
        <br/>
        <span style="float: right"><s:property value="createTime"/></span>
        <hr/>
    </s:iterator>
</div>

<form id="downloadForm" method="post" action="ae_downloadFile" hidden>
    <label for="articleId">id:</label>
    <input id="articleId" type="text" name="articleId" value="<s:property value="#request.article.id"/>">
    <input type="submit" value="submit">
</form>
</body>
</html>
