<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<form class="form-horizontal">
    <div class="form-group">
        <label class="col-sm-2 control-label">Author</label>
        <div class="col-sm-10">
            <p class="form-control-static">Kongin Yan</p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">System Name</label>
        <div class="col-sm-10">
            <p class="form-control-static">Chatter</p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Version</label>
        <div class="col-sm-10">
            <p class="form-control-static">1.0.2</p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Framework</label>
        <div class="col-sm-10">
            <p class="form-control-static">spring4, struts2, hibernate4</p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Last Update</label>
        <div class="col-sm-10">
            <p class="form-control-static">2017-3-8</p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Visitors Count</label>
        <div class="col-sm-10">
            <p class="form-control-static">${visitorCount}</p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Online User Count</label>
        <div class="col-sm-10">
            <p class="form-control-static">${onlineUserCount}</p>
        </div>
    </div>
</form>
</html>
