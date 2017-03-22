<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/static/js/simple/myFollow.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/simple/myFollow.css">
<html>
<s:iterator value="#request.follows">
    <div class="follow-block">
        <img style="width: 50px;height: 50px" src="<%=request.getContextPath()%>/static/img/usercircle.png">
        <br>
        <a onclick="visitAuthor('<s:property value="username"/>')"><s:property value="username"/></a>
    </div>
</s:iterator>
</html>
