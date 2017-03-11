<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/static/js/admin/fileTable.js"></script>
<html>
<table class="table">
    <tr>
        <th>id</th>
        <th>文件</th>
        <th>上传人</th>
        <th>发布时间</th>
        <th>下载次数</th>
        <th>操作</th>
    </tr>
    <s:iterator value="#request.fileList">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="fileName"/></td>
            <td><s:property value="uploader"/></td>
            <td><s:property value="uploadTime"/></td>
            <td><s:property value="downloadCount"/></td>
            <td>
                <a onclick="downloadConfirm('<s:property value="id"/>')">下载</a>
                <a onclick="deleteConfirm('<s:property value="id"/>')">删除</a>
            </td>
        </tr>
    </s:iterator>
</table>
<form id="downloadForm" method="post" action="fm_downloadFile" hidden>
    <label for="fileId">id:</label>
    <input id="fileId" type="text" name="fileId">
    <input type="submit" value="submit">
</form>
<ul id="filePager" class="pagination" data-total="<s:property value="#request.fileTotalRecord"/>" data-pageindex="<s:property value="#request.fileCurrentPage"/>" data-pagesize="10" data-pagegroupsize="10"
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
