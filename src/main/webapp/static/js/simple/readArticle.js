$(function () {
    $("#makeComment").click(() => {
        $.ajax({
            url: 'co_make',
            type: 'POST',
            data: {
                'articleId': $("#articleId").val(),
                'content': $("#inputComment").val()
            },
            success: (data, textStatus) => {
                alert(data);
                location.reload()
            }
        })
    })
    $(".collect").click(() => {
        $.ajax({
            url: 'um_collectArticle',
            type: 'POST',
            data: {
                'articleId': $("#articleId").val()
            },
            success: (data, textStatus) => {
                location.reload()
            }
        })
    });
})

var downloadFile = () => {
    $('#downloadForm').submit()
};

var deleteComment = (id) => {
    if (confirm('你要删除此评论吗？')) {
        $.ajax({
            url: 'co_delete',
            type: 'POST',
            data: {
                'id': id
            },
            success: (data, textStatus) => {
                alert(data);
                location.reload()
            }
        })
    }
}

var visitAuthor = (author)=>{
    $("#mainWindow").load("myPage",{
        'pageMaster':author
    })
}
