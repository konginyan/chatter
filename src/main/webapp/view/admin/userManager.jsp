<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/static/js/admin/userManager.js"></script>
<html>
<ul class="nav nav-tabs">
    <li class="active">
        <a href="#adminPage" data-toggle="tab">管理员</a>
    </li>

    <li>
        <a href="#simplePage" data-toggle="tab">用户</a>
    </li>
</ul>
<div class="tab-content">
    <div id="adminPage" class="tab-pane fade in active">
        <div class="fb">
            <button id="create" class="btn btn-primary" data-toggle="modal" data-target="#myModal">创建管理员</button>

            <!-- 模态框 -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">新增管理员</h4>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div id="nameForm" class="form-group">
                                    <label for="inputUserName">用户名</label>
                                    <input type="text" class="form-control" id="inputUserName" placeholder="Username" onblur="checkUsername()">
                                    <label id="name-label" class="help-block"></label>
                                </div>
                                <div id="passwordForm" class="form-group">
                                    <label for="inputPassword">密码</label>
                                    <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                                    <label id="password-label" class="help-block"></label>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button id="createAdmin" type="button" class="btn btn-primary">添加</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="input-group col-md-6" style="float: right;">
                <input id="admin-search-key" type="text" class="form-control" placeholder="请输入字段名"/>
                <span class="input-group-btn">
                    <button id="admin-search-btn" class="btn btn-info btn-search">查找</button>
                </span>
            </div>
        </div>
        <div id="adminTable"></div>
    </div>
    <div id="simplePage" class="tab-pane fade">
        <div class="input-group col-md-6 fb" style="float: right;">
            <input id="simple-search-key" type="text" class="form-control" placeholder="请输入字段名"/>
            <span class="input-group-btn">
                    <button id="simple-search-btn" class="btn btn-info btn-search">查找</button>
                </span>
        </div>
        <div id="simpleTable"></div>
    </div>
</div>
</html>
