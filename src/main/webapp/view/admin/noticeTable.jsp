<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/static/js/admin/noticeTable.js"></script>
<html>
<table class="table">
    <tr>
        <th>id</th>
        <th>标题</th>
        <th>作者</th>
        <th>发布时间</th>
        <th>点击量</th>
        <th>操作</th>
    </tr>
    <s:iterator value="#request.noticeList">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="title"/></td>
            <td><s:property value="author"/></td>
            <td><s:property value="createTime"/></td>
            <td><s:property value="clickCount"/></td>
            <td>
                <a onclick="deleteConfirm('<s:property value="id"/>')">删除</a>
            </td>
        </tr>
    </s:iterator>
</table>
<ul id="noticePager" class="pagination" data-total="<s:property value="#request.noticeTotalRecord"/>" data-pageindex="<s:property value="#request.noticeCurrentPage"/>" data-pagesize="10" data-pagegroupsize="10"
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

</html>
