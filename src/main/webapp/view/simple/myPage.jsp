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
</html>
