<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/static/js/simple/mainWindow.js"></script>
<html>
<div class="col-md-2">
    <dl>
        <dt>最新公告</dt>
        <s:iterator value="#request.recentNotice">
            <dd><a onclick="readNotice('<s:property value="id"/>')"><s:property value="title"/></a></dd>
        </s:iterator>
        <hr>
        <dt>下载</dt>
        <s:iterator value="#request.recentFile">
            <dd><a onclick="downloadFile('<s:property value="id"/>')"><s:property value="fileName"/></a></dd>
        </s:iterator>
        <hr>
        <dt>最新文章</dt>
        <dd><a>article one</a></dd>
        <dd><a>article two</a></dd>
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
                <a onclick="readNotice('<s:property value="id"/>')"><s:property value="title"/></a>
                <span style="float: right">作者：<a><s:property value="author"/></a></span>
            </div>
            <div class="panel-body">
                <p><s:property value="notice" escapeHtml="false"/></p>
            </div>
        </div>
    </s:iterator>
</div>
</html>
