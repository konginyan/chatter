$(function () {
    $("#myPersonal").load("myPersonal");
    $("#myCollection").load("myCollection");
    $("#myFollow").load("myFollow");
    $("#mySetting").load("mySetting");

    $("#post").click(()=>{
        $("#article").load("myArticleEdit");
    });

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
    });

    $("#passModal").click(()=>{
        $("#oldPassword").val("");
        $("#newPassword").val("");
    });

    $("#updatePass").click(()=>{
        if(confirm("确定修改密码吗")){
            $.ajax({
                url:'um_changePassword',
                type:'POST',
                data:{
                    'id':$("#userId").text(),
                    'oldPassword':$("#oldPassword").val(),
                    'newPassword':$("#newPassword").val()
                },
                success:function (data,textStatus) {
                    $("#cancel").click();
                    alert(data)
                }
            })
        }
    });

    $("#article-search-btn").click(()=>{
        $("#myArticle").load("myArticle",{
            'key':$("#article-search-key").val(),
            'page':'0'
        });
    })
    $("#article-search-btn").click()
});