<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/simple/myPage.css">
<script src="<%=request.getContextPath()%>/static/js/simple/myPage.js"></script>
<html>
<div class="db">
    <h3>my zone</h3>
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
            <a href="#article" data-toggle="tab">我的文章</a>
        </li>
        <li>
            <a href="#comment" data-toggle="tab">我的评论</a>
        </li>
        <li>
            <a href="#setting" data-toggle="tab">设置</a>
        </li>
    </ul>
    <div class="tab-content">
        <div id="personal" class="tab-pane fade in active">
            <div id="myPersonal"></div>
        </div>
        <div id="follow" class="tab-pane fade">
            <div id="myFollow"></div>
        </div>
        <div id="collection" class="tab-pane fade">
            <div id="myCollection"></div>
        </div>
        <div id="article" class="tab-pane fade">
            <div id="myArticle"></div>
        </div>
        <div id="comment" class="tab-pane fade">
            <div id="myComment"></div>
        </div>
        <div id="setting" class="tab-pane fade">
            <div id="mySetting"></div>
        </div>
    </div>
</div>
</html>
