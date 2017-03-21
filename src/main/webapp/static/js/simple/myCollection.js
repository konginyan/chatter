var cancelConfirm = (id,name)=>{
    if(confirm("确定取消收藏标题为"+name+"的文章吗")){
        $.ajax({
            url:'um_collectArticle',
            type:'POST',
            data:{
                'articleId':id
            },
            success:function (data,textStatus) {
                alert(data)
                $("#myCollection").load("myCollection");
            }
        })
    }
}

var downloadConfirm = (id)=>{
    $("#articleId").val(id);
    $("#downloadForm").submit()
}