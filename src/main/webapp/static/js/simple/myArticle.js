$(function () {
    var articlePager = BootstrapPagination($("#articlePager"),{
        pageChanged: function (pageIndex) {
            $("#myArticle").load("myArticle",{
                'key':$("#notice-search-key").val(),
                'page':pageIndex
            })
        }
    })
})
var deleteConfirm = (id,name)=>{
    if(confirm("确定删除标题为"+name+"的文章吗")){
        $.ajax({
            url:'ae_deleteArticle',
            type:'POST',
            data:{
                'id':id
            },
            success:function (data,textStatus) {
                alert(data)
                $("#myArticle").load("myArticle",{
                    'key':$("#article-search-key").val(),
                    'page':$(".pagination").attr("data-pageindex")
                });
            }
        })
    }
}

var downloadConfirm = (id)=>{
    $("#articleId").val(id);
    $("#downloadForm").submit()
}