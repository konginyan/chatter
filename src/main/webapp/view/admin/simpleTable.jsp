<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/static/js/admin/simpleTable.js"></script>
<html>
<table class="table">
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>创建日期</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <s:iterator value="#request.simpleUserList" var="list">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="username"/></td>
            <td><s:property value="createDate"/></td>
            <s:if test="#list.status==0">
                <td style="color: green">正常</td>
                <td><a onclick="forbidConfirm('<s:property value="id"/>',this)">封禁</a></td>
            </s:if>
            <s:else>
                <td style="color: red">封禁中</td>
                <td><a onclick="forbidConfirm('<s:property value="id"/>',this)">恢复</a></td>
            </s:else>

        </tr>
    </s:iterator>
</table>
<ul id="simplePager" class="pagination" data-total="<s:property value="#request.simpleTotalRecord"/>" data-pageindex="<s:property value="#request.simpleCurrentPage"/>" data-pagesize="10" data-pagegroupsize="10"
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
