<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/static/js/simple/myArticle.js"></script>
<html>
<hr/>
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
                <a onclick="deleteConfirm('<s:property value="id"/>','<s:property value="title"/>')">删除</a>
            </s:if>
        </label>
    </div>
    <hr/>
</s:iterator>

<div class="col-md-2"></div>
<div class="col-md-10">
    <ul id="articlePager" class="pagination" style="width: 100%" data-total="<s:property value="#request.articleTotalRecord"/>" data-pageindex="<s:property value="#request.articleCurrentPage"/>" data-pagesize="10" data-pagegroupsize="10"
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
</div>

<form id="downloadForm" method="post" action="ae_downloadFile" hidden>
    <label for="articleId">id:</label>
    <input id="articleId" type="text" name="articleId">
    <input type="submit" value="submit">
</form>

</html>
