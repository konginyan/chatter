<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/static/js/simple/listView.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/simple/listView.css"/>
<html>
<div class="db">
    <s:if test="#request.type=='notice'">
        <h3>公告</h3>
        <s:iterator value="List">
            <a href="readNotice?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a>
            <label><s:property value="createTime"/></label>
            <hr/>
        </s:iterator>
    </s:if>
    <s:elseif test="#request.type=='file'">
        <h3>下载</h3>
        <s:iterator value="List">
            <a onclick="downloadFile('<s:property value="id"/>')"><s:property value="fileName"/></a>
            <label><s:property value="uploadTime"/></label>
            <label class="description"><s:property value="description"/></label>
            <hr/>
        </s:iterator>
    </s:elseif>
    <s:else>
        <h3>文章</h3>
        <s:iterator value="List">
            <a href="readArticle?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a>
            <label><s:property value="createTime"/></label>
            <hr/>
        </s:iterator>
    </s:else>
</div>
<form id="downloadForm" method="post" action="admin/fm_downloadFile" hidden>
    <label for="fileId">id:</label>
    <input id="fileId" type="text" name="fileId">
    <input type="submit" value="submit">
</form>
</html>
