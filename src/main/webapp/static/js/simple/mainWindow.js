$(function () {
    $("#allNotice").click(()=>{
        $("#mainWindow").load("li_noticeList",{
            key:"",
            page:'0'
        })
    })
    $("#allFile").click(()=>{
        $("#mainWindow").load("li_fileList",{
            'key':"",
            'page':'0'
        })
    })
    $("#allArticle").click(()=>{
        $("#mainWindow").load("li_articleList",{
            'key':"",
            'page':'0'
        })
    })
    $("#index-search-button").click(()=>{
        $("#mainWindow").load("li_noticeList",{
            key:$("#index-search-key").val(),
            page:'0'
        })
    })
})

var downloadFile = (id)=>{
    $("#fileId").val(id)
    $("#downloadForm").submit()
}