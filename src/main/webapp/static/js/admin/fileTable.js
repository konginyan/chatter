$(function () {
    var filePager = BootstrapPagination($("#filePager"),{
        pageChanged: function (pageIndex) {
            $("#fileTable").load("fileTable",{
                'key':$("#file-search-key").val(),
                'page':pageIndex
            })
        }
    })
})

var deleteConfirm = (id) => {
    if(confirm("确定删除id为"+id+"的文件吗")){
        $.ajax({
            url:'fm_deleteFile',
            type:'POST',
            data:{
                'id':id
            },
            success:function (data,textStatus) {
                alert(data)
                $("#fileTable").load("fileTable",{
                    'key':$("#file-search-key").val(),
                    'page':$(".pagination").attr("data-pageindex")
                })
            }
        })
    }
}

var downloadConfirm = (id) => {
    $("#fileId").val(id)
    $("#downloadForm").submit()
}