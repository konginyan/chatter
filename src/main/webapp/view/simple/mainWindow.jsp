<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/static/js/simple/mainWindow.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-pagination.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap-pagination.min.css">
<html>
<div class="col-md-2">
    <dl>
        <dt><a id="allNotice">最新公告</a></dt>
        <s:iterator value="#request.recentNotice">
            <dd><a href="readNotice?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></dd>
        </s:iterator>
        <hr>
        <dt><a id="allFile">下载</a></dt>
        <s:iterator value="#request.recentFile">
            <dd><a onclick="downloadFile('<s:property value="id"/>')"><s:property value="fileName"/></a></dd>
        </s:iterator>
        <hr>
        <dt><a id="allArticle">最新文章</a></dt>
        <s:iterator value="#request.recentArticle">
            <dd><a href="readArticle?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></dd>
        </s:iterator>
    </dl>
</div>
<form id="downloadForm" method="post" action="admin/fm_downloadFile" hidden>
    <label for="fileId">id:</label>
    <input id="fileId" type="text" name="fileId">
    <input type="submit" value="submit">
</form>
<div class="col-md-10">
    <s:iterator value="#request.recentNotice">
        <div class="panel panel-default">
            <div class="panel-heading">
                <a href="readNotice?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a>
            </div>
            <div class="panel-body">
                <p><s:property value="notice" escapeHtml="false"/></p>
            </div>
        </div>
    </s:iterator>
</div>
</html>
