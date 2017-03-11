var checkUsername = function () {
    $.ajax({
        url:'um_checkSimple',
        type:'GET',
        data:{
            'key':$("#inputUserName").val()
        },
        dataType:"text",
        success:function (data,textStatus) {
            if(data == "exist"){
                $("#nameForm").addClass("has-error").removeClass("has-success")
                $("#name-label").text("用户名非法或已存在")
            }
            else {
                $("#nameForm").addClass("has-success").removeClass("has-error")
                $("#name-label").text("用户名可用")
            }
        }
    })
}

var checkForm = function(){
    if($("#nameForm").hasClass("has-success")) return true;
    else {
        alert("用户名或密码不合法")
        return false;
    }
}
