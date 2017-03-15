<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap-switch.min.css">
<script src="<%=request.getContextPath()%>/static/js/bootstrap-switch.min.js"></script>
<script>
    $.fn.bootstrapSwitch.defaults.size = 'small';
    $("[name='check']").bootstrapSwitch();
</script>
<html>
<div class="fb">
    <label for="openPersonal" class="db">公开个人信息</label>
    <input id="openPersonal" name="check" type="checkbox" checked />
</div>
<div class="fb">
    <label for="openArticle" class="db">公开文章</label>
    <input id="openArticle" name="check" type="checkbox" checked />
</div>
<div class="fb">
    <label for="openCollection" class="db">公开收藏</label>
    <input id="openCollection" name="check" type="checkbox" checked />
</div>
<div class="fb">
    <label for="openFollow" class="db">公开关注</label>
    <input id="openFollow" name="check" type="checkbox" checked />
</div>
</html>
