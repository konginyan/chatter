<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div style="margin: 30px">
    <form class="form-horizontal col-md-3">
        <div class="form-group">
            <label class="col-sm-5 control-label">用户名：</label>
            <div class="col-sm-7">
                <p class="form-control-static">${pageMaster}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-5 control-label">粉丝数：</label>
            <div class="col-sm-7">
                <p class="form-control-static"><s:property value="#request.author.followerCount"/></p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-5 control-label">总文章数：</label>
            <div class="col-sm-7">
                <p class="form-control-static"><s:property value="#request.total"/></p>
            </div>
        </div>
    </form>
    <div style="font-size: 16px;" class="col-md-9">
        <h4 style="font-weight: bold">最近发表的文章</h4>
        <ul>
            <s:iterator value="#request.recent">
                <li><a><s:property value="title"/></a></li>
            </s:iterator>
        </ul>
    </div>
</div>

</html>
