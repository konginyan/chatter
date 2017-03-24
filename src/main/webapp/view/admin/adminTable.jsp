<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/static/js/admin/adminTable.js"></script>
<html>
<table class="table">
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>创建日期</th>
        <th>操作</th>
    </tr>
    <s:iterator value="#request.adminUserList">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="username"/></td>
            <td><s:property value="createDate"/></td>
            <td>
                <a data-toggle="modal" data-target="#passModal" onclick="injectModel('<s:property value="id"/>','<s:property value="username"/>')">编辑</a>
                <a onclick="deleteConfirm('<s:property value="id"/>')">删除</a>
            </td>
        </tr>
    </s:iterator>
</table>

<!-- 模态框 -->
<div class="modal fade" id="passModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改密码</h4>
            </div>
            <div class="modal-body">
                <form>
                    <label id="id-label" hidden></label>
                    <div id="nameForm" class="form-group">
                        <label for="passUserName">用户名</label>
                        <input type="text" class="form-control" id="passUserName" disabled>
                    </div>
                    <div id="passwordForm" class="form-group">
                        <label for="passPassword">新密码</label>
                        <input type="password" class="form-control" id="passPassword" placeholder="Password">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="cancel" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button id="changePass" type="button" class="btn btn-primary" onclick="updateConfirm()">修改</button>
            </div>
        </div>
    </div>
</div>

<ul id="adminPager" class="pagination" data-total="<s:property value="#request.adminTotalRecord"/>" data-pageindex="<s:property value="#request.adminCurrentPage"/>" data-pagesize="10" data-pagegroupsize="10"
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
