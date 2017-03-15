$(function () {
    var pager = BootstrapPagination($("#pager"),{
        pageChanged: function (pageIndex) {
            $("#mainWindow").load($("#type").text(),{
                'key':$("#search-key").val(),
                'page':pageIndex
            })
        }
    })
})
var downloadFile = (id)=>{
    $("#fileId").val(id)
    $("#downloadForm").submit()
}