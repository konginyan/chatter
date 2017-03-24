<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/simple/myPage.css">
<script src="<%=request.getContextPath()%>/static/js/simple/myPage.js"></script>
<html>
<div class="db">
    <h3><label id="pageMaster">${pageMaster}</label>
        <s:if test="#session.account!=#session.pageMaster">
            &nbsp;&nbsp;&nbsp;&nbsp;
            <label id="auId" hidden><s:property value="#request.author.id"/></label>
            <s:if test="#session.account!=null">
                <s:if test="#request.followed">
                    <button id="followUser" class="btn btn-danger">已关注</button>
                </s:if>
                <s:else>
                    <button id="followUser" class="btn btn-success">关注</button>
                </s:else>
            </s:if>
        </s:if>
        <s:else>
            <button style="margin-left: 30px" class="btn btn-default" data-toggle="modal" data-target="#passModal">修改密码</button>
        </s:else>
    </h3>

    <ul class="nav nav-tabs">
        <li class="active">
            <a href="#personal" data-toggle="tab">个人信息</a>
        </li>
        <li>
            <a href="#follow" data-toggle="tab">关注</a>
        </li>
        <li>
            <a href="#collection" data-toggle="tab">收藏</a>
        </li>
        <li>
            <a href="#article" data-toggle="tab">文章</a>
        </li>
        <s:if test="#session.account==#session.pageMaster">
            <li>
                <a href="#setting" data-toggle="tab">设置</a>
            </li>
        </s:if>
    </ul>
    <div class="tab-content">
        <div id="personal" class="tab-pane fade in active">
            <s:if test="(#session.account==#session.pageMaster)||(#request.author.userSetting.openPersonal)">
                <div id="myPersonal"></div>
            </s:if>
            <s:else>
                <p>该用户隐藏了此部分</p>
            </s:else>
        </div>
        <div id="follow" class="tab-pane fade">
            <s:if test="(#session.account==#session.pageMaster)||(#request.author.userSetting.openFollow)">
                <div id="myFollow"></div>
            </s:if>
            <s:else>
                <p>该用户隐藏了此部分</p>
            </s:else>
        </div>
        <div id="collection" class="tab-pane fade">
            <s:if test="(#session.account==#session.pageMaster)||(#request.author.userSetting.openCollection)">
                <div id="myCollection"></div>
            </s:if>
            <s:else>
                <p>该用户隐藏了此部分</p>
            </s:else>
        </div>
        <div id="article" class="tab-pane fade">
            <s:if test="(#session.account==#session.pageMaster)||(#request.author.userSetting.openArticle)">
                <div class="fb">
                    <s:if test="#session.account==#session.pageMaster">
                        <button id="post" class="btn btn-primary">发表文章</button>
                    </s:if>
                    <s:else>
                        <button class="btn btn-default">文章列表</button>
                    </s:else>
                    <div class="input-group col-md-6" style="float: right;">
                        <input id="article-search-key" type="text" class="form-control" placeholder="请输入字段名"/>
                        <span class="input-group-btn">
                        <button id="article-search-btn" class="btn btn-info btn-search">查找</button>
                    </span>
                    </div>
                </div>
                <div id="myArticle"></div>
            </s:if>
            <s:else>
                <p>该用户隐藏了此部分</p>
            </s:else>
        </div>
        <s:if test="#session.account==#session.pageMaster">
            <div id="setting" class="tab-pane fade">
                <div id="mySetting"></div>
            </div>
        </s:if>
    </div>
</div>

<!-- 模态框 -->
<div class="modal fade" id="passModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <label id="userId"><s:property value="#request.author.id"/></label>
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
                        <label for="oldPassword">原密码</label>
                        <input type="password" class="form-control" id="oldPassword">
                    </div>
                    <div id="passwordForm" class="form-group">
                        <label for="newPassword">新密码</label>
                        <input type="password" class="form-control" id="newPassword">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="cancel" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button id="updatePass" type="button" class="btn btn-primary">修改</button>
            </div>
        </div>
    </div>
</div>
</html>
