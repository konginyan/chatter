<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/simple/myArticleEdit.js"></script>
<html>
<form method="post" action="ae_postArticle" enctype="multipart/form-data">
    <div class="form-group">
        <label for="articleTitle">标题</label>
        <input type="text" class="form-control" id="articleTitle" name="articleTitle">
    </div>
    <div class="form-group">
        <label for="articleContent">内容</label>
        <textarea class="form-control" rows="10" id="articleContent" name="articleContent"></textarea>
    </div>
    <div class="form-group">
        <label for="articleFile">附件</label>
        <input type="file" id="articleFile" name="file">
    </div>
    <button id="postNotice" type="submit" class="btn btn-default">提交</button>
</form>

</html>
