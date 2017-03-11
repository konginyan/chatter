$(document).ready(function () {
    $("#dt1").click(()=>{
        $("#right").load("systemView")
    });
    $("#dt2").click(function () {
        $("#right").load("userManager")
    });

    $("#dt3").click(function () {
        $("#right").load("resourceManager")
    })
});