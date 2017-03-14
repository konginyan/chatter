<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-pagination.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap-pagination.min.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/simple/readArticle.js"></script>
<html>
<head>
    <title>文章阅读</title>
</head>
<body style="margin: 10%">
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
            <input class="btn btn-default" type="button" value="提交">
        </div>
    </form>
</s:if>
<s:else>
    <label style="margin-top: 50px">
        要评论，请<a href="loginPage?requestUrl=readArticle?id=<s:property value="#request.article.id"/>">登录</a>
        还没有帐号，那还不赶紧<a href="registerPage?requestUrl=readArticle?id=<s:property value="#request.article.id"/>">注册</a>
    </label>
</s:else>
<form id="downloadForm" method="post" action="ae_downloadFile" hidden>
    <label for="articleId">id:</label>
    <input id="articleId" type="text" name="articleId" value="<s:property value="#request.article.id"/>">
    <input type="submit" value="submit">
</form>
</body>
</html>
