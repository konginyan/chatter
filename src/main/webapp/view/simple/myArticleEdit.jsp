<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/static/js/simple/myArticleEdit.js"></script>
<html>
<form>
    <div class="form-group">
        <label for="articleTitle">标题</label>
        <input type="text" class="form-control" id="articleTitle">
    </div>
    <div class="form-group">
        <label for="articleContent">内容</label>
        <textarea class="form-control" rows="10" id="articleContent"></textarea>
    </div>
    <div class="form-group">
        <label for="articleFile">附件</label>
        <input type="file" id="articleFile">
    </div>
    <button class="btn btn-primary">返回</button>
    <button id="postNotice" type="button" class="btn btn-default">提交</button>
</form>
</html>
