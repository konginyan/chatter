<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/simple/myPage.css">
<script src="<%=request.getContextPath()%>/static/js/simple/myPage.js"></script>
<html>
<div class="db">
    <h3>${pageMaster}</h3>
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
            <div class="fb">
                <div class="input-group col-md-6" style="float: right;">
                    <input id="follow-search-key" type="text" class="form-control" placeholder="请输入字段名"/>
                    <span class="input-group-btn">
                        <button id="follow-search-btn" class="btn btn-info btn-search">查找</button>
                    </span>
                </div>
            </div>
            <div id="myFollow"></div>
        </div>
        <div id="collection" class="tab-pane fade">
            <div class="fb">
                <div class="input-group col-md-6" style="float: right;">
                    <input id="collection-search-key" type="text" class="form-control" placeholder="请输入字段名"/>
                    <span class="input-group-btn">
                        <button id="collection-search-btn" class="btn btn-info btn-search">查找</button>
                    </span>
                </div>
            </div>
            <div id="myCollection"></div>
        </div>
        <div id="article" class="tab-pane fade">
            <div class="fb">
                <button id="post" class="btn btn-primary">发表文章</button>
                <div class="input-group col-md-6" style="float: right;">
                    <input id="article-search-key" type="text" class="form-control" placeholder="请输入字段名"/>
                    <span class="input-group-btn">
                        <button id="article-search-btn" class="btn btn-info btn-search">查找</button>
                    </span>
                </div>
            </div>
            <div id="myArticle"></div>
        </div>
        <div id="comment" class="tab-pane fade">
            <div class="fb">
                <div class="input-group col-md-6" style="float: right;">
                    <input id="comment-search-key" type="text" class="form-control" placeholder="请输入字段名"/>
                    <span class="input-group-btn">
                        <button id="comment-search-btn" class="btn btn-info btn-search">查找</button>
                    </span>
                </div>
            </div>
            <div id="myComment"></div>
        </div>
        <div id="setting" class="tab-pane fade">
            <div id="mySetting"></div>
        </div>
    </div>
</div>
</html>
