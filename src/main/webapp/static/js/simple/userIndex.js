$(function () {
    $("#li3").click(()=>{
        $("#mainWindow").load("myPage",{
            'pageMaster':$("#account").text()
        })
    })

    $("#index-search-button").click(()=>{
        $("#mainWindow").load("li_articleList",{
            key:$("#index-search-key").val(),
            page:'0'
        })
    })
})