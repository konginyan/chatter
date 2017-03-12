<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/static/js/simple/myArticle.js"></script>
<html>
<div class="fb">
    <button id="post" class="btn btn-primary">发表文章</button>
    <div class="input-group col-md-6" style="float: right;">
        <input id="article-search-key" type="text" class="form-control" placeholder="请输入字段名"/>
        <span class="input-group-btn">
            <button id="article-search-btn" class="btn btn-info btn-search">查找</button>
        </span>
    </div>
</div>
</html>
