<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/static/js/simple/myCollection.js"></script>
<html>
<div style="margin-top: 10px">
    <s:iterator value="#request.articleList" var="articlelist">
        <div class="txt">
            <a href="readArticle?id=<s:property value="id"/>" target="_blank"><s:property value="title"/></a>
            <label style="float: right">发表日期:<s:property value="createTime"/></label>
            <br/><br/>
            附件：
            <s:if test="#articlelist.attachment.getFileName()!=null">
                <img src="<%=request.getContextPath()%>/static/img/zip.png" style="width: 20px;height: 20px">
                <a onclick="downloadConfirm('<s:property value="id"/>')"><s:property value="attachment.getFileName()"/></a>
            </s:if>
            <s:else>
                无
            </s:else>
            <label style="float: right">
                点击量:<s:property value="clickCount"/>
                <s:if test="#session.account==#session.pageMaster">
                    <a onclick="cancelConfirm('<s:property value="id"/>','<s:property value="title"/>')">取消收藏</a>
                </s:if>
            </label>
        </div>
        <hr/>
    </s:iterator>
</div>

<form id="downloadForm" method="post" action="ae_downloadFile" hidden>
    <label for="articleId">id:</label>
    <input id="articleId" type="text" name="articleId">
    <input type="submit" value="submit">
</form>
</html>