$(function () {
    $("#create").click(function () {
        $("#right").load("editPage")
    })

    $("#uploadFile").click(()=>{
        $("#fileForm").submit()
    })

    $("#notice-search-btn").click(function () {
        $("#noticeTable").load("noticeTable",{
            'key':$("#notice-search-key").val(),
            'page':'0'
        })
    })

    $("#file-search-btn").click(function () {
        $("#fileTable").load("fileTable",{
            'key':$("#file-search-key").val(),
            'page':'0'
        })
    })
    $("#notice-search-btn").click()
    $("#file-search-btn").click()
})