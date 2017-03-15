$(function () {
    $("#myPersonal").load("myPersonal");
    $("#myCollection").load("myCollection");
    $("#myFollow").load("myFollow");
    $("#mySetting").load("mySetting")

    $("#post").click(()=>{
        $("#article").load("myArticleEdit");
    })

    $("#article-search-btn").click(()=>{
        $("#myArticle").load("myArticle",{
            'key':$("#article-search-key").val(),
            'page':'0'
        });
    })
    $("#article-search-btn").click()
});