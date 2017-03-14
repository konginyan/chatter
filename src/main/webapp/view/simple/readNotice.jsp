<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bootstrap-pagination.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap-pagination.min.css">
<html>
<article style="margin: 10%">
    <h1 class="text-center">${title}</h1>
    <h6 style="color: gray" class="text-center">${time}</h6>
    <hr/>
    <p style="font-size: 20px">${content}</p>
</article>
</html>
