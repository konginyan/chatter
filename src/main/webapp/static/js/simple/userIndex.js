$(function () {
    $("#li3").click(()=>{
        $("#mainWindow").load("myPage",{
            'pageMaster':$("#account").text()
        })
    })
})