<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/static/js/simple/listView.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/simple/listView.css"/>
<html>
<div class="db">
    <label id="type" hidden>li_<s:property value="#request.type"/>List</label>
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
<ul id="pager" class="pagination" style="width: 100%" data-total="<s:property value="#request.TotalRecord"/>" data-pageindex="<s:property value="#request.CurrentPage"/>" data-pagesize="20" data-pagegroupsize="10"
    data-leftformatestring="本页{count}条记录/共{total}条记录"
    data-pagenumberformatestring="{pageNumber}"
    data-pagesizelistformatestring="每页显示{pageSize}条记录"
    data-prevpagetext="上一页" data-nextpagetext="下一页"
    data-prevgrouppagetext="上一组" data-nextgrouppagetext="下一组"
    data-firstpagetext="首页" data-lastpagetext="尾页"
    data-pageinput-placeholder="GO" data-pageinput-timeout="800"
    data-pagesizelist="[5, 10, 20, 50, 100, 200]"
    data-layoutscheme="lefttext,firstpage,prevgrouppage,prevpage,pagenumber,nextpage,nextgrouppage,lastpage,pageinput,righttext">
</ul>
<label id="search-key" hidden>${key}</label>
<form id="downloadForm" method="post" action="admin/fm_downloadFile" hidden>
    <label for="fileId">id:</label>
    <input id="fileId" type="text" name="fileId">
    <input type="submit" value="submit">
</form>
</html>
