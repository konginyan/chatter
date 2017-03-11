$(function () {
    $("#postNotice").click(function () {
        $.ajax({
            url:'um_postNotice',
            type:'POST',
            data:{
                'title':$("#noticeTitle").val(),
                'content':$("#noticeContent").val()
            },
            success:function (data,textStatus) {
                alert("success")
                $("#right").load("resourceManager")
            }
        })
    })
})