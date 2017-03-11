<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/static/js/admin/resourceManager.js"></script>
<html>
<ul class="nav nav-tabs">
    <li class="active">
        <a href="#noticePage" data-toggle="tab">公告</a>
    </li>

    <li>
        <a href="#filePage" data-toggle="tab">文件</a>
    </li>

    <li>
        <a href="#articlePage" data-toggle="tab">文章</a>
    </li>
</ul>
<div class="tab-content">
    <div id="filePage" class="tab-pane fade">
        <div class="fb">
            <button id="upload" class="btn btn-primary" data-toggle="modal" data-target="#myModal">上传文件</button>

            <!-- 模态框 -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">上传文件</h4>
                        </div>
                        <div class="modal-body">
                            <form id="fileForm" method="post" action="fm_uploadFile" enctype="multipart/form-data">
                                <input type="file" id="inputFile" name="file">
                                <div class="form-group">
                                    <label for="inputDescription">文件描述</label>
                                    <input type="text" class="form-control" id="inputDescription" placeholder="description" name="description">
                                    <label id="description-label" class="help-block"></label>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button id="uploadFile" type="button" class="btn btn-primary">上传</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="input-group col-md-6" style="float: right;">
                <input id="file-search-key" type="text" class="form-control" placeholder="请输入字段名"/>
                <span class="input-group-btn">
                    <button id="file-search-btn" class="btn btn-info btn-search">查找</button>
                </span>
            </div>
        </div>
        <div id="fileTable"></div>
    </div>
    <div id="noticePage" class="tab-pane fade in active">
        <div class="fb">
            <button id="create" class="btn btn-primary">新建公告</button>
            <div class="input-group col-md-6" style="float: right;">
                <input id="notice-search-key" type="text" class="form-control" placeholder="请输入字段名"/>
                <span class="input-group-btn">
                    <button id="notice-search-btn" class="btn btn-info btn-search">查找</button>
                </span>
            </div>
        </div>
        <div id="noticeTable"></div>
    </div>
    <div id="articlePage" class="tab-pane fade">
        <div class="input-group col-md-6 fb" style="float: right;">
            <input id="article-search-key" type="text" class="form-control" placeholder="请输入字段名"/>
            <span class="input-group-btn">
                    <button id="article-search-btn" class="btn btn-info btn-search">查找</button>
                </span>
        </div>
        <div id="articleTable"></div>
    </div>
</div>
</html>
