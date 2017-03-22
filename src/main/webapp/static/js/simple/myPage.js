$(function () {
    $("#myPersonal").load("myPersonal");
    $("#myCollection").load("myCollection");
    $("#myFollow").load("myFollow");
    $("#mySetting").load("mySetting")

    $("#post").click(()=>{
        $("#article").load("myArticleEdit");
    })

    $("#followUser").click(()=>{
        $.ajax({
            url: 'um_follow',
            type: 'POST',
            data: {
                'id': $("#auId").text()
            },
            success: (data, textStatus) => {
                $("#mainWindow").load("myPage",{
                    'pageMaster':$("#pageMaster").text()
                })
            }
        })
    })

    $("#article-search-btn").click(()=>{
        $("#myArticle").load("myArticle",{
            'key':$("#article-search-key").val(),
            'page':'0'
        });
    })
    $("#article-search-btn").click()
});