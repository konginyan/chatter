$(document).ready(function () {
    var adminPager = BootstrapPagination($("#adminPager"),{
        pageChanged: function (pageIndex) {
            $("#adminTable").load("adminTable",{
                'key':$("#admin-search-key").val(),
                'page':pageIndex
            })
        }
    })
})

var injectModel = (id,username) => {
    $("#id-label").text(id)
    $("#passUserName").val(username)
    $("#passPassword").val("")
}

var updateConfirm = () => {
    if(confirm("确定修改密码吗")){
        $.ajax({
            url:'um_changePassword',
            type:'POST',
            data:{
                'id':$("#id-label").text(),
                'password':$("#passPassword").val()
            },
            success:function (data,textStatus) {
                alert(data)
                $("#cancel").click()
            }
        })
    }
}

var deleteConfirm = (id) => {
    if(confirm("确定删除id为"+id+"的管理员帐号吗")){
        $.ajax({
            url:'um_deleteAdmin',
            type:'POST',
            data:{
                'id':id
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
}
