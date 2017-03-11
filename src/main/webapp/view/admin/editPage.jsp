<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/static/js/admin/editPage.js"></script>
<html>
<h2>发布公告</h2>
<form>
    <div class="form-group">
        <label for="noticeTitle">标题</label>
        <input type="text" class="form-control" id="noticeTitle">
    </div>
    <div class="form-group">
        <label for="noticeContent">内容</label>
        <textarea class="form-control" rows="16" id="noticeContent"></textarea>
    </div>
    <button id="postNotice" type="button" class="btn btn-default">提交</button>
</form>
</html>
