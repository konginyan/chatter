$(function () {
    var noticePager = BootstrapPagination($("#noticePager"),{
        pageChanged: function (pageIndex) {
            $("#noticeTable").load("noticeTable",{
                'key':$("#notice-search-key").val(),
                'page':pageIndex
            })
        }
    })
})

var deleteConfirm = (id) => {
    if(confirm("确定删除id为"+id+"的公告吗")){
        $.ajax({
            url:'um_deleteNotice',
            type:'POST',
            data:{
                'id':id
            },
            success:function (data,textStatus) {
                alert(data)
                $("#noticeTable").load("noticeTable",{
                    'key':$("#notice-search-key").val(),
                    'page':$(".pagination").attr("data-pageindex")
                })
            }
        })
    }
}