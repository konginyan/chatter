$(document).ready(function () {
    $("#createAdmin").click(function () {
        if($("#nameForm").hasClass("has-success")&&$("#inputPassword").val()!=""){
            $("#myModal").modal('hide')
            $.ajax({
                url:'um_createAdmin',
                type:'POST',
                data:{
                    'username':$("#inputUserName").val(),
                    'password':$("#inputPassword").val()
                },
                success:function (data,textStatus) {
                    alert(data)
                    $("#adminTable").load("adminTable",{
                        'key':$("#admin-search-key").val(),
                        'page':$(".pagination").attr("data-pageindex")
                    })
                }
            })
        }
        else {
            alert("用户名或者密码不正确")
        }
    })
    $("#admin-search-btn").click(function () {
        $("#adminTable").load("adminTable",{
            'key':$("#admin-search-key").val(),
            'page':'0'
        })
    })
    $("#simple-search-btn").click(function () {
        $("#simpleTable").load("simpleTable",{
            'key':$("#simple-search-key").val(),
            'page':'0'
        })
    })
    $("#create").click(function () {
        $("#nameForm").removeClass("has-error").removeClass("has-success")
        $("#inputUserName").val("")
        $("#inputPassword").val("")
        $("#name-label").text("")
    })

    $("#simple-search-btn").click()
    $("#admin-search-btn").click()
})

var checkUsername = function () {
    $.ajax({
        url:'um_checkAdmin',
        type:'POST',
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