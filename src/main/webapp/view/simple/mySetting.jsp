<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap-switch.min.css">
<script src="<%=request.getContextPath()%>/static/js/bootstrap-switch.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/simple/mySetting.js"></script>
<script>
    $.fn.bootstrapSwitch.defaults.size = 'small';
    $("[name='check']").bootstrapSwitch();
</script>
<html>
<div class="fb">
    <label for="openPersonal" class="db">公开个人信息</label>
    <input id="openPersonal" class="setToggle" name="check" onchange="changeSetting()" type="checkbox"
            <s:if test="#request.openPersonal">checked</s:if>/>
</div>
<div class="fb">
    <label for="openArticle" class="db">公开文章</label>
    <input id="openArticle" class="setToggle" name="check" type="checkbox" onchange="changeSetting()"
           <s:if test="#request.openArticle">checked</s:if>/>
</div>
<div class="fb">
    <label for="openCollection" class="db">公开收藏</label>
    <input id="openCollection" class="setToggle" name="check" type="checkbox" onchange="changeSetting()"
           <s:if test="#request.openCollection">checked</s:if>/>
</div>
<div class="fb">
    <label for="openFollow" class="db">公开关注</label>
    <input id="openFollow" class="setToggle" name="check" type="checkbox" onchange="changeSetting()"
           <s:if test="#request.openFollow">checked</s:if>/>
</div>
</html>
