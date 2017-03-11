$(function () {
    var simplePager = BootstrapPagination($("#simplePager"),{
        pageChanged: function (pageIndex) {
            $("#simpleTable").load("simpleTable",{
                'key':$("#simple-search-key").val(),
                'page':pageIndex
            })
        }
    })
})

var forbidConfirm = (id, obj) => {
    if(confirm("确定"+obj.innerText+"id为"+id+"的帐号吗")){
        $.ajax({
            url:'um_forbidSimple',
            type:'POST',
            data:{
                'id':id
            },
            success:function (data,textStatus) {
                alert(data)
                $("#simpleTable").load("simpleTable",{
                    'key':$("#simple-search-key").val(),
                    'page':$(".pagination").attr("data-pageindex")
                })
            }
        });

    }
}